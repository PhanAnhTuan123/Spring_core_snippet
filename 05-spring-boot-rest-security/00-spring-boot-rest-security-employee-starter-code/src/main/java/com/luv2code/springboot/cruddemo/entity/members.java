package com.luv2code.springboot.cruddemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "members")
public class members {
    @Id
    @Column(name = "user_id")
    private int id;

    @Column(name = "pw")
    private String pw;
    @Column(name = "active")
    private int active;

    public members(int id) {
        this.id = id;
    }

    public members(int id, String pw, int active) {
        this.id = id;
        this.pw = pw;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "members{" +
                "id=" + id +
                ", pw='" + pw + '\'' +
                ", active=" + active +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        members members = (members) o;
        return id == members.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
