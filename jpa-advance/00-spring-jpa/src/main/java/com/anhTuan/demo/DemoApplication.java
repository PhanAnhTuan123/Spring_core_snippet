package com.anhTuan.demo;

import com.anhTuan.demo.model.Student;
import com.anhTuan.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	private IStudentService studentService;
	@Autowired
	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	@Override
	public void run(String... args) throws Exception {
//		Set<String>emails = new HashSet<>(Arrays.asList("Pit@gmail.com","Hola@gmail.com"));
//		Student student = new Student("Jin","Contai",emails);
//		studentService.addStudent(student);

		List<Student>listSTD = studentService.getByName("Jo");
		listSTD.forEach(System.out::println);

	}
}
