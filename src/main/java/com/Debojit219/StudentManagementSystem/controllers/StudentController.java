package com.Debojit219.StudentManagementSystem.controllers;

import com.Debojit219.StudentManagementSystem.entities.Student;
import com.Debojit219.StudentManagementSystem.repositories.StudentRepository;
import com.Debojit219.StudentManagementSystem.repositories.StudentSearchRepository;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentSearchRepository studentSearchRepository;

    @Hidden
    @RequestMapping(value = "/students")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/allStudents")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/allStudents/{text}")
    public List<Student> searchStudent(@PathVariable String text) {
        return studentSearchRepository.searchStudents(text);
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }
}
