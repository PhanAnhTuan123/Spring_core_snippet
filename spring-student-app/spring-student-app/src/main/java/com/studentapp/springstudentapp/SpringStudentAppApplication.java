package com.studentapp.springstudentapp;

import com.studentapp.springstudentapp.model.Address;
import com.studentapp.springstudentapp.model.Student;
import com.studentapp.springstudentapp.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringStudentAppApplication implements CommandLineRunner {

	private IStudentService studentService;
	@Autowired
	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringStudentAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Address address = new Address("Bangalore","KAR");
		Student std = new Student("Raju","Mech",address);
		studentService.addStudent(std);
	}
}
