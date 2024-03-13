package com.anhTuan.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(generator = "student_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "student_gen",sequenceName = "student_seq",initialValue = 50,allocationSize = 1)
    private Integer studentId;
    private String name;
    private String department;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "student_email",joinColumns = @JoinColumn(name = "student_id"))
    private Set<String>emails;

    public Student(String name, String department, Set<String> emails) {
        this.name = name;
        this.department = department;
        this.emails = emails;
    }
}
