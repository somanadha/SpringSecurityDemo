package com.bst.ssd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
@Entity
@Table(name = "SSDUser")
@Scope("prototype")
public class SSDUser {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int userId;
    @Column(unique = true)
    private String userName;
    private String password;
//    private boolean isAccountExpired;
//    private boolean isAccountLocked;
//    private boolean isCredentialsExpired;
//    private boolean isAccountEnabled;

}
