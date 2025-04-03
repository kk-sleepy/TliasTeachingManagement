package com.kksleepy.controller;

import com.kksleepy.pojo.Emp;
import com.kksleepy.pojo.LoginInfo;
import com.kksleepy.pojo.Result;
import com.kksleepy.service.EmpService;
import com.kksleepy.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private EmpService empService;
    @PostMapping
    public Result login(@RequestBody Emp emp) {
        log.info("登陆信息:{}",emp);
        LoginInfo loginInfo = empService.login(emp);
        if(loginInfo != null) {
            return Result.success(loginInfo);
        } else {
            return Result.error("用户名或密码错误");
        }
    }
}
