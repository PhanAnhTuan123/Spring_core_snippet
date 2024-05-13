package com.shopme.springsecurity_demo.repositories;

import com.shopme.springsecurity_demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{

    User findByEmail(String email);
}
