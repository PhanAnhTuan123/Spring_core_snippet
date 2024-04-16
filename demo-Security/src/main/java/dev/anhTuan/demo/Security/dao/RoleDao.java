package dev.anhTuan.demo.Security.dao;

import dev.anhTuan.demo.Security.entity.Role;

public interface RoleDao {
    public Role findRoleByName(String theRoleName);
}
