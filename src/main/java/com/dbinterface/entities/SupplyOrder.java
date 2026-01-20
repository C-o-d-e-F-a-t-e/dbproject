package com.dbinterface.entities;

import java.sql.Timestamp;

public class SupplyOrder{
    private int supplyOrderID;
    private int employeeID;
    private int supplierID;
    private Timestamp orderDate;
    private String status;
    private double totalAmount;

    // Constructors
    public SupplyOrder() {}

    public SupplyOrder(int employeeID, int supplierID, double totalAmount) {
        this.employeeID = employeeID;
        this.supplierID = supplierID;
        this.totalAmount = totalAmount;
        this.status = "pending";
    }

    // Getters and Setters
    public int getSupplyOrderID() { return supplyOrderID; }
    public void setSupplyOrderID(int supplyOrderID) { this.supplyOrderID = supplyOrderID; }
    
    public int getEmployeeID() { return employeeID; }
    public void setEmployeeID(int employeeID) { this.employeeID = employeeID; }
    
    public int getSupplierID() { return supplierID; }
    public void setSupplierID(int supplierID) { this.supplierID = supplierID; }
    
    public Timestamp getOrderDate() { return orderDate; }
    public void setOrderDate(Timestamp orderDate) { this.orderDate = orderDate; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    @Override
    public String toString() {
        return "SupplyOrder{" +
                "supplyOrderID=" + supplyOrderID +
                ", employeeID=" + employeeID +
                ", supplierID=" + supplierID +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}