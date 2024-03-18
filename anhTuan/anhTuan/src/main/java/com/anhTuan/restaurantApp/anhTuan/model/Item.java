package com.anhTuan.restaurantApp.anhTuan.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(generator = "item_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "item_gen",sequenceName = "item_sequence",initialValue = 1,allocationSize = 1)
    private Integer itemId;
    @Column(name = "itemname",length = 20)
    private String itemName;
    @Column(length = 20)
    private String category;
    @Column(length = 20)
    private String cuisine;
    private double price;

    public Item(String itemName, String category, String cuisine, double price) {
        this.itemName = itemName;
        this.category = category;
        this.cuisine = cuisine;
        this.price = price;
    }
}
