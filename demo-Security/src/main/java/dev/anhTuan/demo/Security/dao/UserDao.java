package dev.anhTuan.demo.Security.dao;

import dev.anhTuan.demo.Security.entity.User;

public interface UserDao {
    User findByUserName(String userName);
}
