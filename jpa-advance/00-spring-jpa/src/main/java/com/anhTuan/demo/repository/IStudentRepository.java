package com.anhTuan.demo.repository;

import com.anhTuan.demo.model.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student,Integer> {

    //derived queries
    List<Student> findByName(String name, Sort sort);
    List<Student>findByDepartment(String department,Sort sort);

}
