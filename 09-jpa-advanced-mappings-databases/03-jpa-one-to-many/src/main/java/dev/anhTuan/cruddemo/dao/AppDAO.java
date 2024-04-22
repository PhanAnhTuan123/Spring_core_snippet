package dev.anhTuan.cruddemo.dao;

import dev.anhTuan.cruddemo.entity.Course;
import dev.anhTuan.cruddemo.entity.Instructor;
import dev.anhTuan.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    public void save(Instructor theInstructor);
    public Instructor findInstructorById(int id);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course>findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);
}
