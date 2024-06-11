package com.bst.ssd.repo;

import com.bst.ssd.model.SSDUser;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Scope("singleton")
public interface SSDUserRepository extends JpaRepository<SSDUser, Integer> {
    SSDUser findByUserName(String userName);
}
