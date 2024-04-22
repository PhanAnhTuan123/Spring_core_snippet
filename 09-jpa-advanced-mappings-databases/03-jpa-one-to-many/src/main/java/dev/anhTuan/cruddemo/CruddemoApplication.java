package dev.anhTuan.cruddemo;

import dev.anhTuan.cruddemo.dao.AppDAO;
import dev.anhTuan.cruddemo.entity.Course;
import dev.anhTuan.cruddemo.entity.Instructor;
import dev.anhTuan.cruddemo.entity.InstructorDetail;
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
//			System.out.println("ajojo");
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//            deleteInstructor(appDAO);
//			findInstructorDetail(appDAO);
//			deleteInstructorDetail(appDAO);
//			createInstructorWithCourses(appDAO);
//			findInstructorWithCourse(appDAO);
//			findCourseForInstructor(appDAO);
			findInstructorWithCoursejoinFetch(appDAO);

		};


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
