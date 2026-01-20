package com.dbinterface.entities;

public class SaleLine {
    private int saleLineID;
    private int saleID;
    private int productID;
    private int quantity;
    private double unitPrice;

    // Constructors
    public SaleLine() {}

    public SaleLine(int saleID, int productID, int quantity, double unitPrice) {
        this.saleID = saleID;
        this.productID = productID;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    // Getters and Setters
    public int getSaleLineID() { return saleLineID; }
    public void setSaleLineID(int saleLineID) { this.saleLineID = saleLineID; }
    
    public int getSaleID() { return saleID; }
    public void setSaleID(int saleID) { this.saleID = saleID; }
    
    public int getProductID() { return productID; }
    public void setProductID(int productID) { this.productID = productID; }
    
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }

    @Override
    public String toString() {
        return "SaleLine{" +
                "saleLineID=" + saleLineID +
                ", saleID=" + saleID +
                ", productID=" + productID +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}