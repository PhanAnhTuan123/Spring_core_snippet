package com.studentapp.springstudentapp.model;

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
public class Student {
    @Id
    @GeneratedValue(generator = "student_seq",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "student_seq",sequenceName = "std_seq",allocationSize = 1,initialValue = 1)
    private Integer studentId;
    private String studentName;
    private String department;
    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "addres_id")
    private Address address;

    public Student(String studentName, String department, Address address) {
        this.studentName = studentName;
        this.department = department;
        this.address = address;
    }
}
