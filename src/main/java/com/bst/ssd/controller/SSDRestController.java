package com.bst.ssd.controller;

import com.bst.ssd.model.SSDUserDetails;
import com.bst.ssd.service.SSDJwtService;
import com.bst.ssd.service.SSDUserDetailsService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SSDRestController {

    @Autowired
    private SSDUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SSDJwtService jwtService;

    @GetMapping("users")
    public Iterable<String> getUsernameList(){
        return userDetailsService.getUsernameList();
    }

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
    public SSDUserDetails registerUser(@RequestBody SSDUserDetails userDetails){
        return userDetailsService.save(userDetails);
    }

    @PostMapping("login")
    public String loginUser(@RequestBody SSDUserDetails userDetails){
        String message = "Login Failed";
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword()));

            if (authentication != null && authentication.isAuthenticated()) {
                message = "Login Success. JWT Token: " + jwtService.generateToken(userDetails.getUsername());
            }
            else {
                message += ": Unknown Reason For Authentication Failure";
            }
        }
        catch (Exception ex) {
            System.out.println("Exception in Authenticating: "+ex);
            message += ": "+ex.getMessage();
        }
        return message;
    }
}
