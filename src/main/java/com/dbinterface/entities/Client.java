package com.dbinterface.entities;

import java.sql.Timestamp;

public class Client {
    private int ClientID;
    private String firstName;
    private String lastName;
    private int age;
    private String phone;
    private String email;
    private Timestamp dateOfFirstPurchase;

    // Constructors
    public Client() {}

    public Client(String firstName, String lastName, int age, 
                 String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    // Getters and Setters
    public int getClientID() { return ClientID; }
    public void setClientID(int ClientID) { this.ClientID = ClientID; }
    
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
    
    public Timestamp getDateOfFirstPurchase() { return dateOfFirstPurchase; }
    public void setDateOfFirstPurchase(Timestamp dateOfFirstPurchase) { 
        this.dateOfFirstPurchase = dateOfFirstPurchase; 
    }

    @Override
    public String toString() {
        return "Client{" +
                "ClientID=" + ClientID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", dateOfFirstPurchase=" + dateOfFirstPurchase +
                '}';
    }
}