package com.studentapp.springstudentapp.service;

import com.studentapp.springstudentapp.model.Student;
import com.studentapp.springstudentapp.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements  IStudentService{
    private IStudentRepository iStudentRepository;
    @Autowired
    public void setiStudentRepository(IStudentRepository iStudentRepository) {
        this.iStudentRepository = iStudentRepository;
    }

    @Override
    public void addStudent(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public void deleteStudent(int studentId) {
        iStudentRepository.deleteById(studentId);
    }

    @Override
    public Student getById(int studentId) {
        return iStudentRepository.findById(studentId).get();
    }

    @Override
    public List<Student> getAll() {
        return  iStudentRepository.findAll();
    }

    @Override
    public List<Student> getByDepartment(String department) {
        return null;
    }
}
