package com.anhtuan.springboot.cruddemo.dao;

import com.anhtuan.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJpaIMpl implements  EmployeeDAO{

    // define field for entitymanager
    private EntityManager entityManager;

    //set up contructor injection
    @Autowired
    public EmployeeDAOJpaIMpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {

        //create a query
        TypedQuery<Employee>theQuery = entityManager.createQuery("from Employee",Employee.class);
        // execute query and get result list

        //return the results
    return theQuery.getResultList();

    }
}
