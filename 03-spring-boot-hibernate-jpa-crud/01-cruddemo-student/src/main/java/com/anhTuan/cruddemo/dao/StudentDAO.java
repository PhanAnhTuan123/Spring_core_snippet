package com.anhTuan.cruddemo.dao;

import com.anhTuan.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO<T> {
    void save(T object);
     T findById(Integer id);
     List<T>findAll();

     List<Student>findByLastName(String theLastName);
}
