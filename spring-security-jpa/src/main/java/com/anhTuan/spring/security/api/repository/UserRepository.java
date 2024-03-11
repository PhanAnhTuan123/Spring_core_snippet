package com.anhTuan.spring.security.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;

import com.anhTuan.spring.security.api.model.User;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User,Integer>{

}
