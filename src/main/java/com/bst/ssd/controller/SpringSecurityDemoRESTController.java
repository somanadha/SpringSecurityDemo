package com.bst.ssd.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecurityDemoRESTController {

    @GetMapping("Hello")
    public String respondToHello(HttpServletRequest request) {
        return "Hi! User With Session ID: "+ request.getSession().getId();
    }

    @GetMapping("About")
    public String tellAboutThisApp (HttpServletRequest request) {
        return "This is a Secured Spring Boot based Java Application: " +
                request.getSession().getId();
    }
}
