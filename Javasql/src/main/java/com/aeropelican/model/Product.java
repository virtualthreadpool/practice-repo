package com.aeropelican.model;

import java.sql.Timestamp;

public class Product {
    private int productId;
    private String productName;
    private int categoryId;
    private double price;
    private int stockQuantity;
    private String sku;
    private Timestamp createdAt;

    // Empty Constructor
    public Product() {}

    // Parameterized Constructor
    public Product(int productId, String productName, int categoryId, double price, int stockQuantity, String sku, Timestamp createdAt) {
        this.productId = productId;
        this.productName = productName;
        this.categoryId = categoryId;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.sku = sku;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
}