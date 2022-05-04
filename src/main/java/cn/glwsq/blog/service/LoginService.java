package cn.glwsq.blog.service;

import cn.glwsq.blog.domain.SysUser;
import cn.glwsq.blog.vo.Result;
import cn.glwsq.blog.vo.params.LoginParams;

public interface LoginService {
    /**
     * 登录功能
     * @param loginParams
     * @return
     */
    Result login(LoginParams loginParams);

    SysUser checkToken(String token);

    /**
     * 退出登录
     * @param token
     * @return
     */
    Result logout(String token);
}
