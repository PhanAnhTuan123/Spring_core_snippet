package com.anhtuan.springboot.cruddemo.dao;

import com.anhtuan.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee>findAll();

}
