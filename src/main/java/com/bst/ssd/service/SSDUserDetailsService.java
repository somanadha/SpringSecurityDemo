package com.bst.ssd.service;

import com.bst.ssd.model.SSDUserDetails;
import com.bst.ssd.repo.SSDUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SSDUserDetailsService implements UserDetailsService {
    @Autowired
    private SSDUserRepository repository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SSDUserDetails userDetails = repository.findByUsername(username);
        if (userDetails == null){
            String errorMessage = "Error: User Not Found: "+username;
            System.out.println(errorMessage);
            throw new UsernameNotFoundException(errorMessage);
        }
        return userDetails;
    }

    public SSDUserDetails save(SSDUserDetails userDetails) {
        System.out.println("User Name:"+ userDetails.getUsername());
        System.out.println("Password Before Encryption:"+ userDetails.getPassword());
        userDetails.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        System.out.println("Password After Encryption:"+ userDetails.getPassword());
        return repository.save(userDetails);
    }

    public Iterable<String> getUsernameList() {
        List<SSDUserDetails> userDetailsList = repository.findAll();
        List<String> usernamesList = new ArrayList<>();
        userDetailsList.forEach( userDetail -> usernamesList.add(userDetail.getUsername()));
        return usernamesList;
    }
}
