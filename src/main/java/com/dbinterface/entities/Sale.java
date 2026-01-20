package com.dbinterface.entities;

import java.sql.Timestamp;

public class Sale {
    private int saleID;
    private int employeeID;
    private int clientID;
    private Timestamp saleDate;
    private double totalAmount;

    // Constructors
    public Sale() {}

    public Sale(int employeeID, double totalAmount) {
        this.employeeID = employeeID;
        this.totalAmount = totalAmount;
    }

    // Getters and Setters
    public int getSaleID() { return saleID; }
    public void setSaleID(int saleID) { this.saleID = saleID; }
    
    public int getEmployeeID() { return employeeID; }
    public void setEmployeeID(int employeeID) { this.employeeID = employeeID; }
    
    public int getClientID() { return clientID; }
    public void setClientID(int clientID) { this.clientID = clientID; }
    
    public Timestamp getSaleDate() { return saleDate; }
    public void setSaleDate(Timestamp saleDate) { this.saleDate = saleDate; }
    
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    @Override
    public String toString() {
        return "Sale{" +
                "saleID=" + saleID +
                ", employeeID=" + employeeID +
                ", clientID=" + clientID +
                ", saleDate=" + saleDate +
                ", totalAmount=" + totalAmount +
                '}';
    }
}