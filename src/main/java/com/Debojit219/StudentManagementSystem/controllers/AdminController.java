package com.Debojit219.StudentManagementSystem.controllers;

import com.Debojit219.StudentManagementSystem.entities.Admin;
import com.Debojit219.StudentManagementSystem.repositories.AdminRepository;
import com.Debojit219.StudentManagementSystem.repositories.AdminSearchRepository;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    AdminSearchRepository adminSearchRepository;
    @Hidden
    @RequestMapping(value = "/admins")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/allAdmins")
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @GetMapping("/allAdmins/{text}")
    public List<Admin> searchAdmin(@PathVariable String text) {
        return adminSearchRepository.searchAdmins(text);
    }

    @PostMapping("/addAdmin")
    public Admin addAdmin(@RequestBody Admin admin) {
        return adminRepository.save(admin);
    }
}
