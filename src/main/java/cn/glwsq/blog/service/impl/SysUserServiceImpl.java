package cn.glwsq.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.glwsq.blog.domain.SysUser;
import cn.glwsq.blog.service.SysUserService;
import cn.glwsq.blog.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author happen
* @description 针对表【ms_sys_user】的数据库操作Service实现
* @createDate 2022-03-09 14:36:35
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findUserById(Long id) {
        SysUser sysUser = sysUserMapper.selectById(id);
        if(sysUser == null) {
            sysUser = new SysUser();
            sysUser.setNickname("无名氏");
        }
        return sysUser;
    }
}




