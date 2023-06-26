package com.Debojit219.StudentManagementSystem.repositories;

import com.Debojit219.StudentManagementSystem.entities.Admin;

import java.util.List;

public interface AdminSearchRepository {
    List<Admin> searchAdmins (String text);
}
