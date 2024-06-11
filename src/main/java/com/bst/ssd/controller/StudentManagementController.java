package com.bst.ssd.controller;

import com.bst.ssd.model.SSDStudent;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentManagementController {

    private List<SSDStudent> ssdStudentList = new ArrayList<SSDStudent>(List.of(
            new SSDStudent(1, "Satya", "CPP"),
            new SSDStudent(2, "Srikar", "Java")));

    @GetMapping("students")
    public Iterable<SSDStudent> getStudents() {
        return ssdStudentList;
    }

    @PostMapping("student")
    public SSDStudent registerStudent(@RequestBody SSDStudent SSDStudent) {
        ssdStudentList.add(SSDStudent);
        return SSDStudent;
    }

    @GetMapping ("csrf")
    public CsrfToken getCSRFToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
