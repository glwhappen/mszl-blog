package cn.glwsq.blog.service.impl;

import cn.glwsq.blog.domain.SysUser;
import cn.glwsq.blog.service.LoginService;
import cn.glwsq.blog.service.SysUserService;
import cn.glwsq.blog.utils.JWTUtils;
import cn.glwsq.blog.vo.ErrorCode;
import cn.glwsq.blog.vo.Result;
import cn.glwsq.blog.vo.params.LoginParams;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate; // spring boot redis整合

    private static final String salt = "mszlu!@#";

    @Override
    public Result login(LoginParams loginParams) {
        /**
         * 1. 检查参数是否合法
         * 2. 根据用户名和密码去user表中查询
         * 3. 如果不存在 登录失败
         * 4. 如果存在 使用 jwt 生成 token 返回给前端
         * 5. token放入redis当中 redis 有 token : user之间的信息 设置过期时间
         * （登录认证的时候 先认证token字符串是否合法，去redis认证是否存在）
         */
        String account = loginParams.getAccount();
        String password = loginParams.getPassword();
        if(StringUtils.isBlank(account) || StringUtils.isBlank((password))) {
            return Result.fail(ErrorCode.PARAMS_ERROR.getCode(), ErrorCode.PARAMS_ERROR.getMsg());
        }
        password = DigestUtils.md5Hex(password + salt);

        SysUser sysUser = sysUserService.findUser(account, password);
        if(sysUser == null) {
            return Result.fail(ErrorCode.ACCOUNT_PWD_NOT_EXIST.getCode(), ErrorCode.ACCOUNT_PWD_NOT_EXIST.getMsg());
        }
        String token = JWTUtils.createToken(sysUser.getId());
        redisTemplate.opsForValue().set("TOKEN_" + token, JSON.toJSONString(sysUser), 1, TimeUnit.DAYS);
        return Result.success(token);
    }

    @Override
    public SysUser checkToken(String token) {
        if(StringUtils.isBlank(token)) {
            return null;
        }
        Map<String, Object> stringObjectMap =  JWTUtils.checkToken(token);
        if(stringObjectMap == null) {
            return null;
        }
        String userJson = redisTemplate.opsForValue().get("TOKEN_" + token);
        if(StringUtils.isBlank(userJson)) {
            return null;
        }
        SysUser sysUser = JSON.parseObject(userJson, SysUser.class);
        return sysUser;
    }

    @Override
    public Result logout(String token) {
        redisTemplate.delete("TOKEN_" + token);
        return Result.success(null);
    }

    @Override
    public Result register(LoginParams loginParams) {
        /**
         * 1. 判断参数是否合法
         * 2. 判断账户是否存在
         *      - 存在，返回账户已经被注册
         *      - 不存在，注册用户
         * 3. 生成token
         * 4. 存入redis，并返回
         * 5. 注意 加上事务，一旦中间的任何过程出现问题，那么就要回滚
         */
        String account = loginParams.getAccount();
        String password = loginParams.getPassword();
        String nickname = loginParams.getNickname();
        if(StringUtils.isBlank(account) || StringUtils.isBlank(password) || StringUtils.isBlank(nickname)) {
            return Result.fail(ErrorCode.PARAMS_ERROR.getCode(), ErrorCode.PARAMS_ERROR.getMsg());
        }
        SysUser sysUser = sysUserService.findUserByAccount(account);
        if(sysUser != null) {
            return Result.fail(ErrorCode.ACCOUNT_EXIST.getCode(), ErrorCode.ACCOUNT_EXIST.getMsg());
        }
        sysUser = new SysUser();
        sysUser.setNickname(nickname);
        sysUser.setAccount(account);
        sysUser.setPassword(DigestUtils.md5Hex(password + salt));
        sysUser.setCreateDate(System.currentTimeMillis());
        sysUser.setLastLogin(System.currentTimeMillis());
        sysUser.setAvatar("/static/img/logo.b3a48c0.png");
        sysUser.setAdmin(true); //1 为true
        sysUser.setDeleted(false); // 0 为false
        sysUser.setSalt("");
        sysUser.setStatus("");
        sysUser.setEmail("");
        this.sysUserService.save(sysUser);

        String token = JWTUtils.createToken(sysUser.getId());
        redisTemplate.opsForValue().set("TOKEN_" + token, JSON.toJSONString(sysUser), 1, TimeUnit.DAYS);
        return Result.success(token);
    }
}
