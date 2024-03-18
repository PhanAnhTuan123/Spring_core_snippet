package com.studentapp.springstudentapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.EnableMBeanExport;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(generator = "add_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "add_gen",sequenceName = "address_seq",initialValue = 1,allocationSize = 1)
    private Integer addressId;
    private String city;
    private String state;


    public Address(String city, String state) {
        this.city = city;
        this.state = state;
    }
}
