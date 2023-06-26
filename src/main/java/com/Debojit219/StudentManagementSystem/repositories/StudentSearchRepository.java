package com.Debojit219.StudentManagementSystem.repositories;

import com.Debojit219.StudentManagementSystem.entities.Student;

import java.util.List;

public interface StudentSearchRepository {
    List<Student> searchStudents (String text);
}