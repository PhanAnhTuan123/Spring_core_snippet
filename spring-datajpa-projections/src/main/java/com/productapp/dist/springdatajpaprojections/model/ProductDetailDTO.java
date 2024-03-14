package com.productapp.dist.springdatajpaprojections.model;

public class ProductDetailDTO {
    String productName;
    String price;

    public ProductDetailDTO(String productName, String price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ProductDetailDTO{" +
                "productName='" + productName + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
