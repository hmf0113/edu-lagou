package com.lagou.authorityboot.controller;

import com.lagou.authorityboot.entity.UserDTO;
import com.lagou.authorityboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@CrossOrigin//跨域
public class AuthorityController {

    @Autowired
    private UserService userService;

    @GetMapping("login")
    public UserDTO login(String phone,String password){
        return userService.login(phone,password);
    }
    @GetMapping("checkToken")
    public UserDTO checkToken(String token){
        return userService.checkToken(token);
    }

}
