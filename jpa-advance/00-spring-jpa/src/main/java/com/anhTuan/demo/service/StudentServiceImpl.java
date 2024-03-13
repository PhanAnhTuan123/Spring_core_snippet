package com.anhTuan.demo.service;

import com.anhTuan.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import com.anhTuan.demo.repository.IStudentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
    public List<Student> getAll() {
        Sort sort = Sort.by(Sort.Direction.ASC,"name","department");
        return iStudentRepository.findAll(sort);
    }

    @Override
    public List<Student> getByName(String name) {
        Sort sort = Sort.by("name");
        return iStudentRepository.findByName(name,sort);
    }

    @Override
    public List<Student> getByDepartment(String department) {
        // Select * from student by
        Sort.Order order = Sort.Order.asc("name");
        Sort.Order order1 = Sort.Order.desc("department");
        List<Sort.Order>orders = Arrays.asList(order,order1);
        Sort sort = Sort.by(orders);
        return iStudentRepository.findByDepartment(department,sort);
    }
}
