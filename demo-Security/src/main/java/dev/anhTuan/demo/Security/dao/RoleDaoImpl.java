package dev.anhTuan.demo.Security.dao;

import dev.anhTuan.demo.Security.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class RoleDaoImpl implements RoleDao {

    private EntityManager entityManager;

    public RoleDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Role findRoleByName(String theRoleName) {
        TypedQuery<Role>theQuery = entityManager.createQuery("from Role where name=:roleName", Role.class);
        theQuery.setParameter("roleName",theRoleName);
        Role theRole = null;

        theRole = theQuery.getSingleResult();

        return theRole;
    }
}
