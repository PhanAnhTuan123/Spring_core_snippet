package dev.anhTuan.DemoMongoDB.controller;

import dev.anhTuan.DemoMongoDB.Model.Student;
import dev.anhTuan.DemoMongoDB.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    StudentRepo studentRepo;

    @PostMapping
            (path = "/addStudent")
    public void addStudent(@RequestBody Student student){
        studentRepo.save(student);
    }

}
