package com.bst.ssd.service;

import com.bst.ssd.model.SSDUser;
import com.bst.ssd.repo.SSDUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SSDUserService {
    @Autowired
    private SSDUserRepository repository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
    public SSDUser save(SSDUser user) {
        System.out.println("Password Before Encryption:"+ user.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println("Password After Encryption:"+ user.getPassword());
        return repository.save(user);
    }
}
