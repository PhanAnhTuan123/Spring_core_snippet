package com.anhTuan.restaurantApp.anhTuan.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;

import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@NamedQueries(
        value = {
                @NamedQuery(name = "Restaurant.showByType",query = "from Restaurant  r where  r.type like 'non-veg' ")
        }

)
@NamedStoredProcedureQueries(
        value = {
                @NamedStoredProcedureQuery(name = "getRestaurantByType",
                        procedureName = "get_count_of_type",
                        parameters = {
                            @StoredProcedureParameter(mode = ParameterMode.IN,name = "type",type = String.class),
                            @StoredProcedureParameter(mode = ParameterMode.OUT,name = "total",type = Integer.class)
                })
        }
)
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
    // to avoid the intermediate table
    @JoinColumn(name =  "restaurant_id")
    Set<Item>items;

    public Restaurant(String restaurantName, String type, String city) {
        this.restaurantName = restaurantName;
        this.type = type;
        this.city = city;
    }

    public Restaurant(String restaurantName, String type, String city, Set<Item> items) {
        this.restaurantName = restaurantName;
        this.type = type;
        this.city = city;
        this.items = items;
    }
}
