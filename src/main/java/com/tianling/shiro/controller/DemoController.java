package com.tianling.shiro.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: TianLing
 * @Year: 2020
 * @DateTime: 2020/7/16 18:43
 */
@Controller
@Slf4j
public class DemoController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/add")
    public String add(){
        return "add";
    }
    @RequestMapping("/add2")
    public String add2(){
        return "add2";
    }
    @RequestMapping("/test")
    public String test(){
        return "test";
    }
    @GetMapping("/login")
    public String demo(){
        return "login";
    }

    @PostMapping("/login")
    public String login(String username,String password){

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        try {
            subject.login(usernamePasswordToken);
        }catch (UnknownAccountException e){
            log.info("没有账号");
            return "login";
        }catch (IncorrectCredentialsException e){
            log.info("密码错误");
            return "login";
        }
        return "demo/demo";
    }
}
