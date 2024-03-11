package com.anhTuan.spring.security.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anhTuan.spring.security.api.model.Role;
import org.springframework.stereotype.Repository;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
}
