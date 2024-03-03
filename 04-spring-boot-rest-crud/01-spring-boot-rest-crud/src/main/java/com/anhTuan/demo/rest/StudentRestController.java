package com.anhTuan.demo.rest;

import com.anhTuan.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student>theStudents;
    //define @PostConstruc to load the student data ... only once!
    @PostConstruct
    public void loadData(){
        this.theStudents = new ArrayList<Student>();
        this.theStudents.add(new Student("Poornima","Patel"));
        this.theStudents.add(new Student("Kati","Numpy"));
        this.theStudents.add(new Student("Romano","Smith"));
    }

    // define endpint for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student>getStudents(){

        return theStudents;
    }
    //  define endpoint or "/students/{studentId} - return student at index"

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        // just index into the list ... keep it simple for now
        // check the studentId again list size
        if((studentId >=this.theStudents.size()) || (studentId < 0)){
            System.out.println("Bi looi");
            throw new StudentNotFoundException("Student id not found - "+ studentId);

        }
        return theStudents.get(studentId);
    }
    // Add an exception handler using @ExceptionHandler


}
