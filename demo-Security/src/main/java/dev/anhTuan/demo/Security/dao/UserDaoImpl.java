package dev.anhTuan.demo.Security.dao;

import dev.anhTuan.demo.Security.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class UserDaoImpl implements UserDao{
    private EntityManager entityManager;

    public UserDaoImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }
    @Override
    public User findByUserName(String userName) {
        TypedQuery<User>theQuery = entityManager.createQuery("from User where username=:uName and enabled = true",User.class);
        theQuery.setParameter("uName",userName);

        User theUser = null;

        theUser = theQuery.getSingleResult();

        return theUser;
    }
}
