package com.bst.ssd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Component
@Data
@Entity
@Table(name = "SSDStudent")
@Scope("prototype")
public class SSDStudent {
    @Id
    private int id;
    private String name;
    private String techStack;
 }
