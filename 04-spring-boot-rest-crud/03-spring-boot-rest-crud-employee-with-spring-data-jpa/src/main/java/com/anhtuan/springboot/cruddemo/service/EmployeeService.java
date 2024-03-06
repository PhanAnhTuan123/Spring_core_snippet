package com.anhtuan.springboot.cruddemo.service;

import com.anhtuan.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int theEmployee);
    Employee save(Employee theEmployee);
    void deleteById(int theID);

}
