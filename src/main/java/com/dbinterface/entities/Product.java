package com.dbinterface.entities;

public class Product {
    private int productID;
    private String productName;
    private String description;
    private String category;
    private double unitPrice;
    private int lowStockThreshold;
    private String unit;

    // Constructors
    public Product() {}

    public Product(String productName, String category, double unitPrice) {
        this.productName = productName;
        this.category = category;
        this.unitPrice = unitPrice;
    }

    // Getters and Setters
    public int getProductID() { return productID; }
    public void setProductID(int productID) { this.productID = productID; }
    
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    
    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }
    
    public int getLowStockThreshold() { return lowStockThreshold; }
    public void setLowStockThreshold(int lowStockThreshold) { 
        this.lowStockThreshold = lowStockThreshold; 
    }
    
    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                ", unitPrice=" + unitPrice +
                ", lowStockThreshold=" + lowStockThreshold +
                ", unit='" + unit + '\'' +
                '}';
    }
}