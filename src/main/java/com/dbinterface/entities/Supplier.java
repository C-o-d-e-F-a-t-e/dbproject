package com.dbinterface.entities;

import java.sql.Timestamp;

public class Supplier {
    private int supplierID;
    private String companyName;
    private String contactPerson;
    private String phone;
    private String email;
    private String address;
    private Timestamp dateOfFirstContact;

    // Constructors
    public Supplier() {}

    public Supplier(String companyName, String contactPerson, 
                   String phone, String email, String address) {
        this.companyName = companyName;
        this.contactPerson = contactPerson;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    // Getters and Setters
    public int getSupplierID() { return supplierID; }
    public void setSupplierID(int supplierID) { this.supplierID = supplierID; }
    
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    
    public String getContactPerson() { return contactPerson; }
    public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public Timestamp getDateOfFirstContact() { return dateOfFirstContact; }
    public void setDateOfFirstContact(Timestamp dateOfFirstContact) { 
        this.dateOfFirstContact = dateOfFirstContact; 
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierID=" + supplierID +
                ", companyName='" + companyName + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", dateOfFirstContact=" + dateOfFirstContact +
                '}';
    }
}