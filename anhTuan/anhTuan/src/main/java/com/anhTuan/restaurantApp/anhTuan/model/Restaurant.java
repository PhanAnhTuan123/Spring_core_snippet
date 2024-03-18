package com.anhTuan.restaurantApp.anhTuan.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Restaurant {
    @Id
    @GeneratedValue(generator = "res_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "res_gen",sequenceName = "res_id",allocationSize = 1,initialValue = 1)
    private Integer restaurantId;
    @Column(length = 30)
    private String restaurantName;
    @Column(length = 10)
    private String type;
    @Column(length = 30)// veg or non veg
    private String city;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    Set<Item>items;

    public Restaurant(String restaurantName, String type, String city) {
        this.restaurantName = restaurantName;
        this.type = type;
        this.city = city;
    }
}
