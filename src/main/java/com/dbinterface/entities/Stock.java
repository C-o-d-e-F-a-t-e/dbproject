package com.dbinterface.entities;

import java.sql.Timestamp;

public class Stock {
    private int stockID;
    private int productID;
    private int currentQuantity;
    private Timestamp lastUpdated;

    // Constructors
    public Stock() {}

    public Stock(int productID, int currentQuantity) {
        this.productID = productID;
        this.currentQuantity = currentQuantity;
    }

    // Getters and Setters
    public int getStockID() { return stockID; }
    public void setStockID(int stockID) { this.stockID = stockID; }
    
    public int getProductID() { return productID; }
    public void setProductID(int productID) { this.productID = productID; }
    
    public int getCurrentQuantity() { return currentQuantity; }
    public void setCurrentQuantity(int currentQuantity) { 
        this.currentQuantity = currentQuantity; 
    }
    
    public Timestamp getLastUpdated() { return lastUpdated; }
    public void setLastUpdated(Timestamp lastUpdated) { this.lastUpdated = lastUpdated; }

    @Override
    public String toString() {
        return "Stock{" +
                "stockID=" + stockID +
                ", productID=" + productID +
                ", currentQuantity=" + currentQuantity +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}