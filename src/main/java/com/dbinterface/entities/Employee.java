package com.dbinterface.entities;

import java.sql.Timestamp;

public class Employee {
    private int EmployeeID;
    private String firstName;
    private String lastName;
    private int age;
    private String phone;
    private String email;
    private String role;
    private Timestamp dateOfEmployment;

    // Constructors
    public Employee() {}

    public Employee(String firstName, String lastName, int age, 
                   String phone, String email, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.role = role;
    }

    // Getters and Setters
    public int getEmployeeID() { return EmployeeID; }
    public void setEmployeeID(int EmployeeID) { this.EmployeeID = EmployeeID; }
    
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    
    public Timestamp getDateOfEmployment() { return dateOfEmployment; }
    public void setDateOfEmployment(Timestamp dateOfEmployment) { 
        this.dateOfEmployment = dateOfEmployment; 
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeID=" + EmployeeID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", dateOfEmployment=" + dateOfEmployment +
                '}';
    }
}