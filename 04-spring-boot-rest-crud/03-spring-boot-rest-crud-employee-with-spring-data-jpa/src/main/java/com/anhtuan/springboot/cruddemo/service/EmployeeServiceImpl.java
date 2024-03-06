package com.anhtuan.springboot.cruddemo.service;

import com.anhtuan.springboot.cruddemo.dao.EmployeeRepository;
import com.anhtuan.springboot.cruddemo.entity.Employee;
import com.anhtuan.springboot.cruddemo.error.EmployeeNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theEmployee) {
        Optional<Employee> result = employeeRepository.findById(theEmployee);
        Employee theEmployeee = null;
        if (result.isPresent()) {
             theEmployeee = result.get();
        }else {
            throw new EmployeeNotFoundException("Not found for employee");
        }
        return theEmployeee;
    }

    @Override
    
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override

    public void deleteById(int theID) {
        employeeRepository.deleteById(theID);
    }
}
