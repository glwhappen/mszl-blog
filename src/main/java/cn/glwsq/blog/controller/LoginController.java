package cn.glwsq.blog.controller;

import cn.glwsq.blog.service.LoginService;
import cn.glwsq.blog.vo.Result;
import cn.glwsq.blog.vo.params.LoginParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result login(@RequestBody LoginParams loginParams) {
        // 登录 验证用户 访问用户表
        return loginService.login(loginParams);
    }
}
