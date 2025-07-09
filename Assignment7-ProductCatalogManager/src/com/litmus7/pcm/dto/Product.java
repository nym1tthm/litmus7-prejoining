package com.litmus7.pcm.dto;


public class Product {
    private Integer productId;
    private String name;
    private String category;
    private double price;
    private int stockQuantity;


    public Product() {
    }

    public Product(int productId, String name, String category, double price, int stockQuantity) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return String.format(
            "ID: %d | Name: %s | Category: %s | Price: ₹%.2f | Stock: %d",
            productId,
            name,
            category,
            price,
            stockQuantity
        );
    }

}
