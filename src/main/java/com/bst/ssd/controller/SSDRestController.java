package com.bst.ssd.controller;

import com.bst.ssd.model.SSDUser;
import com.bst.ssd.service.SSDUserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SSDRestController {

    @Autowired
    private SSDUserService userService;

    @GetMapping("hello")
    public String respondToHello(HttpServletRequest request) {
        return "Hi! User With Session ID: "+ request.getSession().getId();
    }

    @GetMapping("about")
    public String aboutThisApp (HttpServletRequest request) {
        return "This is a Secured Spring Boot based Java Application: " +
                request.getSession().getId();
    }

    @PostMapping("register")
    public SSDUser registerUser(@RequestBody SSDUser user){
        return userService.save(user);
    }
}
