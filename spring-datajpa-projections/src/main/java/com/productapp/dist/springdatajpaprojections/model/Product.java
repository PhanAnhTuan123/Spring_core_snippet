package com.productapp.dist.springdatajpaprojections.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Product {

    private String productName;
    @Id
    @GeneratedValue(generator = "product_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "product_gen",sequenceName = "product_seq",initialValue = 1,allocationSize = 1)
    private Integer productId;
    private double price;
    @Column(length = 255)
    private String brand;
    @Column(length = 255)
    private String category;

    public Product(String productName, double price, String brand, String category) {
        this.productName = productName;
        this.price = price;
        this.brand = brand;
        this.category = category;
    }
}
