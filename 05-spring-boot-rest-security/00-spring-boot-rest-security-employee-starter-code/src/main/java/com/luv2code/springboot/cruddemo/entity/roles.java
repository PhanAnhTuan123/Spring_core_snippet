package com.luv2code.springboot.cruddemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class roles {

    @Id
    @Column(name = "user_id")
    private String user_id;

    @Column(name = "role")
    private String role;

    public roles(String user_id) {
        this.user_id = user_id;
    }

    public roles(String user_id, String role) {
        this.user_id = user_id;
        this.role = role;
    }

    public roles() {

    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "roles{" +
                "user_id='" + user_id + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
