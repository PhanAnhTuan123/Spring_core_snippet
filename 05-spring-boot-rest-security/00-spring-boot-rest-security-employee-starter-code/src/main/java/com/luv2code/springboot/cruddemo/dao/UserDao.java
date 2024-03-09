package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface UserDao {
    Employee findByUserName(String username);
}
