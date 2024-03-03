package com.anhTuan.cruddemo;

import com.anhTuan.cruddemo.dao.StudentDAO;
import com.anhTuan.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO<Student> studentDAO){
		return runner -> {
//				createStudent(studentDAO);
	createMultipleStudents(studentDAO);

//		readStudent(studentDAO);
//		queryForStudents(studentDAO);
//		queryForStudentsByLastName(studentDAO);


//		updateStudent(studentDAO);
//		deleteStudent(studentDAO);

//		deleteAllStudents( studentDAO);

		};


	}

	private void deleteAllStudents(StudentDAO<Student> studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: "+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO<Student> studentDAO) {
		int id = 3;
		System.out.println("Deleteing student id: "+id);
		studentDAO.delete(id);

	}

	private void updateStudent(StudentDAO<Student> studentDAO) {
		// retrieve student based on the id: primary key
		int id = 1;
		System.out.println("Getting student with id: "+id);
		Student myStudent = studentDAO.findById(id);
		// cahnge first name to "Scooby"
		System.out.println("Updating student ...");
		myStudent.setFirstName("Scooby");


		//update the student
		studentDAO.update(myStudent);
		//display the updated student
		System.out.println("Updated student: "+myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO<Student> studentDAO) {
		//get a list of students
		List<Student>theStudents = studentDAO.findByLastName("Duck");
		//display list of students
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO<Student> studentDAO) {
		//get a list of students
		List<Student>theStudents = studentDAO.findAll();
		//display list of student
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO<Student> studentDAO) {
		//create a student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Daffy","Duck","daffy@gmail.com");
		//save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);
		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: "+ theId);
		//revtrieve student based on the id: primary key
		System.out.println("Retrieving student with id: "+theId);
		Student myStudent = studentDAO.findById(theId);

		//display student
		System.out.println("Found the student: "+myStudent);
	}

	private void createMultipleStudents(StudentDAO<Student> studentDAO) {
		//create multiple students
		System.out.println("Creating 3 student object...");
		Student tempStudent1 = new Student("Pault","Doe","pault@gmail.com");
		Student tempStudent2 = new Student("Mary","Public","mary@gmail.com");
		Student tempStudent3 = new Student("Bonita","Applebum","bonita@gmail.com");


		//save the student objects

		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO<Student> studentDAO) {
		//create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Pault","Doe","pault@gmail.com");
		//save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);
		//display id of the saved student
		System.out.println("Saved student. Generated id "+ tempStudent.getId());
	}

}
