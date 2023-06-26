package com.Debojit219.StudentManagementSystem.repositories;

import com.Debojit219.StudentManagementSystem.entities.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
}
