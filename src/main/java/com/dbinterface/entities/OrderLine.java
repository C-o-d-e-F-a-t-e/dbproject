package com.dbinterface.entities;

public class OrderLine {
    private int supplyLineID;
    private int supplyOrderID;
    private int productID;
    private int quantity;
    private double unitPrice;

    // Constructors
    public OrderLine() {}

    public OrderLine(int supplyOrderID, int productID, int quantity, double unitPrice) {
        this.supplyOrderID = supplyOrderID;
        this.productID = productID;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    // Getters and Setters
    public int getSupplyLineID() { return supplyLineID; }
    public void setSupplyLineID(int supplyLineID) { this.supplyLineID = supplyLineID; }
    
    public int getSupplyOrderID() { return supplyOrderID; }
    public void setSupplyOrderID(int supplyOrderID) { this.supplyOrderID = supplyOrderID; }
    
    public int getProductID() { return productID; }
    public void setProductID(int productID) { this.productID = productID; }
    
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }

    @Override
    public String toString() {
        return "OrderLine{" +
                "supplyLineID=" + supplyLineID +
                ", supplyOrderID=" + supplyOrderID +
                ", productID=" + productID +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}