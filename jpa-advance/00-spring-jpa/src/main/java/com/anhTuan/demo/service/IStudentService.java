package com.anhTuan.demo.service;

import com.anhTuan.demo.model.Student;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface IStudentService {
    void addStudent(Student student);
    List<Student>getAll();

    List<Student>getByName(String name);
    List<Student>getByDepartment(String department);

}
