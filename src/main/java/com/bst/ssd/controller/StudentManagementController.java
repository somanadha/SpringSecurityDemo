package com.bst.ssd.controller;

import com.bst.ssd.model.Student;
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

    private List<Student> studentList = new ArrayList<Student>(List.of(
            new Student(1, "Satya", "CPP"),
            new Student(2, "Srikar", "Java")));

    @GetMapping("Students")
    public Iterable<Student > getStudents() {
        return studentList;
    }

    @PostMapping("Student")
    public Student createStudent(@RequestBody Student student) {
        studentList.add(student);
        return student;
    }

    @GetMapping ("csrf")
    public CsrfToken getCSRFToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
