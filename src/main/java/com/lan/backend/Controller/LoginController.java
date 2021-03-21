package com.lan.backend.Controller;

import com.lan.backend.DTO.User;
import com.lan.backend.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @GetMapping("user/login")
    int login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password){
        User user = new User(username,password);
        return (int) loginService.login(user);
    }

}
