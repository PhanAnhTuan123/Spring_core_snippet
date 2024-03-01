package com.anhTuan.cruddemo.dao;

import com.anhTuan.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements  StudentDAO<Student>{

    // define field for entity manager
   @Autowired
    private EntityManager entityManager;
    //inject entity manager using constructor injection

    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional
    public void save(Student object) {
        entityManager.persist(object);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        //create query
        TypedQuery<Student>theQuery = entityManager.createQuery("FROM Student order by lastName asc",Student.class);

        return theQuery.getResultList();
        //return query results



    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // create query
        TypedQuery<Student>theQuery = entityManager.createQuery("from Student Where lastName=:theData",Student.class);
        //set query parameters
        theQuery.setParameter("theData",theLastName);
        //return query results

        return theQuery.getResultList();
    }
}
