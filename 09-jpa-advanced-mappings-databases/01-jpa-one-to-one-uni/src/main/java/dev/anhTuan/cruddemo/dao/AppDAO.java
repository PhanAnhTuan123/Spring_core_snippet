package dev.anhTuan.cruddemo.dao;

import dev.anhTuan.cruddemo.entity.Instructor;

public interface AppDAO {
    public void save(Instructor theInstructor);
    public Instructor findInstructorById(int id);

    void deleteInstructorById(int theId);
}
