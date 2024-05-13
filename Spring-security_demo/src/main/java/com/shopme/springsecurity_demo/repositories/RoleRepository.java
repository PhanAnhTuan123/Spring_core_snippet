package com.shopme.springsecurity_demo.repositories;

import com.shopme.springsecurity_demo.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
