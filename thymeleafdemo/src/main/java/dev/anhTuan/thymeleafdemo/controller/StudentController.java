package dev.anhTuan.thymeleafdemo.controller;

import dev.anhTuan.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller

public class StudentController {
    @Value("${countries}")
    private List<String>countries;

    @GetMapping(path = "/showStudentForm")
    public String showForm(Model theModel){

        // create a student object
        Student theStudent = new Student();
        // add student object to the model
        theModel.addAttribute("student",theStudent);

        theModel.addAttribute("countries",countries);
        return "student-form";
    }
    @PostMapping(path = "processStudentForm")
    public String processForm(@ModelAttribute("student") Student student){

        // log the input data
        System.out.println("theStudent: "+student.getFirstName() + " " + student.getLastName());

        return "student-confirmation";
    }
}
