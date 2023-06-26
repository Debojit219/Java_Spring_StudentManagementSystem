package com.Debojit219.StudentManagementSystem.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Admins")
public class Admin {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private double totalOnlinePayment;
    private double totalCashPayment;
    private boolean isAdmin;
}