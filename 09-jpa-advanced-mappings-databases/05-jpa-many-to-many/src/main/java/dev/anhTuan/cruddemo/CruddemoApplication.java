package dev.anhTuan.cruddemo;

import dev.anhTuan.cruddemo.dao.AppDAO;
import dev.anhTuan.cruddemo.entity.*;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@Log
public class CruddemoApplication   {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{

//			createCourseAndStudents(appDAO);

//			findCourseAndStudent(appDAO);

//            addMoreCourseForStudent(appDAO);

            deleteCourse(appDAO);
		};


	}

    private void addMoreCourseForStudent(AppDAO appDAO) {
        int theId = 2;
        Student tempStudent = appDAO.findStudentAndCourseByStudentId(theId);

        // create more courses
        Course tempCourse1 = new Course("Rubik's Cube - How to Speed Cube");
        Course tempCourse2 = new Course("Atatri - Game Development");

        // add course to student
        tempStudent.addCourse(tempCourse1);
        tempStudent.addCourse(tempCourse2);

        System.out.println("SAving student: "+tempStudent);
        System.out.println("Associated courses: "+tempStudent.getCourses());

        appDAO.update(tempStudent);
        System.out.println("DOne!!");
    }

    private void findCourseAndStudent(AppDAO appDAO) {

		int theId = 10;
		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);

		System.out.println("Load course: "+ tempCourse);
		System.out.println("Students: "+tempCourse.getStudents());

		System.out.println("Done!!");
	}

	private void createCourseAndStudents(AppDAO appDAO) {

		// create a course
		Course tempCourse = new Course("Pacman - How To Score One Million Points");
		// create the students
		Student tempStudent1 = new Student("John","Doe","john@luv2code.com");
		Student tempStudent2 = new Student("Mary","Jane","mary@luv2code.com");

		// add students to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		// save the course and associated students
		System.out.println("Saving the course: "+tempCourse);
		System.out.println("associated students: "+tempCourse.getStudents());

		appDAO.save(tempCourse);

		System.out.println("Done!");


	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Deleting course id: "+theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Done!!!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		// get the course and reviews
		int theId =10;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);


		// print the course
		System.out.println(tempCourse);
		// print the reviews
		System.out.println(tempCourse.getReviews());
		System.out.println("Done!!");
		//
	}

	private void createCourseAndReview(AppDAO appDAO) {

		// create a course
		Course tempCourse = new Course("Pacman - How To Score One Million Points");

		// add some reviews
		tempCourse.addReview(new Review("Gred course ... loved it!"));
		tempCourse.addReview(new Review("Cool course, job well done."));
		tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));

		// save the course ... and leverage the cascade all
		System.out.println("Saving the course");
		System.out.println(tempCourse.toString());
		System.out.println(tempCourse.getReviews());
		appDAO.save(tempCourse);

		System.out.println("Done !!!");


	}

	private void deleteCourse(AppDAO appDAO) {

		int theId = 10;
		System.out.println("Deleting course id: "+theId);

		appDAO.deleteCourseById(theId);
		System.out.println("Done!");

	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 10;
		// find the course
		System.out.println("Finding course id: "+theId);
		Course tempCourse = appDAO.findCourseById(theId);
		tempCourse.setTitle("Enjoy the Simple Things");
		// update the course
		System.out.println("Updating course id: "+theId);
		appDAO.update(tempCourse);

		System.out.println("Done!");

	}

	private void updateInstructor(AppDAO appDAO) {

		int theId = 1;

		// find the instructor
		System.out.println("Finding instructor id:" + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		// update the instructor
		System.out.println("Updating instructor id: "+theId);
		tempInstructor.setLastname("TESTER");

		appDAO.update(tempInstructor);

		System.out.println("Done!");

	}

	private void findInstructorWithCoursejoinFetch(AppDAO appDAO) {
		int theId = 1;

		// find the instructor
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("The associated courses: "+tempInstructor.getCourses());
		System.out.println("Done!!");

	}

	private void findCourseForInstructor(AppDAO appDAO) {
		int theId = 1;
		// find instructor
		System.out.println("Finding instructor id:" + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+tempInstructor);

		// find courses for instructor
		System.out.println("Finding courses for instructor id: "+theId);
		List<Course>courses = appDAO.findCoursesByInstructorId(theId);

		// associate the objects
		tempInstructor.setCourses(courses);

		System.out.println("the associated courses: "+ tempInstructor.getCourses());
		System.out.println("Done!");



	}

	private void findInstructorWithCourse(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the  asscociated courses: "+tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
//		Instructor tempInstructor = Instructor
//				.builder()
//				.firstName("Susan")
//				.lastname("Public")
//				.email("susan.public@luv2code.com")
//				.build();
// create the instructor detail
//		InstructorDetail tempInstructorDetail = InstructorDetail
//				.builder()
//				.youtubeChannel("http://www.youtube.com")
//				.hobby("VIDEO GAMES")
//				.build();
		Instructor tempInstructor = new Instructor("Susan","Public","susan.public@luv2code.com");
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com","VIDEO GAMES");
		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);
//		System.out.println("Saving instructor: " +tempInstructor);

		// create some courses
		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball Masterclass");

		//add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save the instructor
		//
		// NOTE: this will ALSO save the courses
		// because of CascadeType.PERSIST
		System.out.println("Saving instructor: "+tempInstructor);
		System.out.println("The courses: "+tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done!");

	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Deleting instructor detail id: "+theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!");

	}

	private void findInstructorDetail(AppDAO appDAO) {

		// get the instructor detail object
		int theId = 3;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		// print the instructor detail
		System.out.println("tempInstructorDetail: "+ tempInstructorDetail);
		// print the associated instructor
//		System.out.println("The associated instructor: "+tempInstructorDetail.getInstructor());

		System.out.println("Done!");
	}

	private void deleteInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Deleting instructor id: "+theId);

		appDAO.deleteInstructorById(theId);

        System.out.println("Done!");

    }

    private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("The associate instructorDetail only: "+tempInstructor.getInstructorDetail());
	}

//	private void createInstructor(AppDAO appDAO) {
//
////		// create the instructor
////		Instructor tempInstructor = Instructor
////				.builder()
////				.firstName("Chad")
////				.lastname("Darby")
////				.email("darby@luv2code.com")
////				.build();
//
//		// create the instructor
//		Instructor tempInstructor = Instructor
//				.builder()
//				.firstName("Madhu")
//				.lastname("Patel")
//				.email("madhu@luv2")
//				.build();
//// create the instructor detail
//		InstructorDetail tempInstructorDetail = InstructorDetail
//				.builder()
//				.youtubeChannel("http://www.luv2code.com")
//				.build();
//
//		// associate the objects
//		tempInstructor.setInstructorDetail(tempInstructorDetail);
//		System.out.println("Saving instructor: " +tempInstructor);
//		appDAO.save(tempInstructor);
//		System.out.println("Done !!");
//
//	}


}
