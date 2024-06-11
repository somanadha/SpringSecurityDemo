package com.bst.ssd.service;

import com.bst.ssd.model.SSDUserDetailsPrinciple;
import com.bst.ssd.repo.SSDUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SSDUserDetailsPrincipalService implements UserDetailsService {
    @Autowired
    private SSDUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var user = repository.findByUserName(username);
        if (user == null){
            String errorMessage = "Error: User Not Found: "+username;
            System.out.println(errorMessage);
            throw new UsernameNotFoundException(errorMessage);
        }
        return new SSDUserDetailsPrinciple(user);
    }
}
