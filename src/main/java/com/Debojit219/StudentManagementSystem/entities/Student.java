package com.Debojit219.StudentManagementSystem.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Data
@Document(collection = "Students")
public class Student {
    private String name;
    private String uniqueId;
    private List<DayOfWeek> regularClassDays;
    private double feeAmount;
    private String emailId;
    private String phoneNumber;
    private String classOrPurpose;
    private LocalDate dateOfBirth;
    private String password;
    private boolean isAdmin;
}
