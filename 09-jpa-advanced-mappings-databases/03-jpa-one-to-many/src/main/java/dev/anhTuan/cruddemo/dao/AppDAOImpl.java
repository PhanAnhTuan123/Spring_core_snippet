package dev.anhTuan.cruddemo.dao;

import dev.anhTuan.cruddemo.entity.Course;
import dev.anhTuan.cruddemo.entity.Instructor;
import dev.anhTuan.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{


    // define field for entity manager
    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // inject entity manager using constructor injection
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class,id);

    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {

        // retrieve the instructor
        Instructor tempInstructor = entityManager.find(Instructor.class,theId);
        // delete the instructor
        entityManager.remove(tempInstructor);

    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class,theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {

        // retrive instructor detail
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class,theId);

        // remove the associated object reference
        // break bi-directional link
        //
        tempInstructorDetail.getInstructor().setInstructorDetail(null);

        //delete the instructor detail
        entityManager.remove(tempInstructorDetail);


    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {

        TypedQuery<Course>query = entityManager.createQuery(
                "from Course where instructor.id = :data",Course.class);
        query.setParameter("data",theId);

        // execute query
        List<Course>courses = query.getResultList();

        return courses;

    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor>query = entityManager.createQuery(
                "select i from Instructor i  JOIN fetch i.courses" +
                        " join fetch i.instructorDetail" +
                        " where i.id = :data", Instructor.class
        );
        query.setParameter("data",theId);

        // execute query
        Instructor instructor = query.getSingleResult();
        return instructor;
    }
}
