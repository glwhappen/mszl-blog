package cn.glwsq.blog.service;

import cn.glwsq.blog.domain.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author happen
* @description 针对表【ms_sys_user】的数据库操作Service
* @createDate 2022-03-09 14:36:35
*/
public interface SysUserService extends IService<SysUser> {
    SysUser findUserById(Long id);

    SysUser findUser(String account, String password);
}
