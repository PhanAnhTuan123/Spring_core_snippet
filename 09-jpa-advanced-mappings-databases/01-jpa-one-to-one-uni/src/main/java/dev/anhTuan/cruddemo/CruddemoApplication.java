package dev.anhTuan.cruddemo;

import dev.anhTuan.cruddemo.dao.AppDAO;
import dev.anhTuan.cruddemo.entity.Instructor;
import dev.anhTuan.cruddemo.entity.InstructorDetail;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Log
public class CruddemoApplication   {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{
//			createInstructor(appDAO);
			findInstructor(appDAO);
            deleteInstructor(appDAO);
		};
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

	private void createInstructor(AppDAO appDAO) {

//		// create the instructor
//		Instructor tempInstructor = Instructor
//				.builder()
//				.firstName("Chad")
//				.lastname("Darby")
//				.email("darby@luv2code.com")
//				.build();

		// create the instructor
		Instructor tempInstructor = Instructor
				.builder()
				.firstName("Madhu")
				.lastname("Patel")
				.email("madhu@luv2code.com")
				.build();
// create the instructor detail
		InstructorDetail tempInstructorDetail = InstructorDetail
				.builder()
				.youtubeChannel("http://www.luv2code.com/youtube")
				.hobby("GUITAR")
				.build();

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		System.out.println("Saving instructor: " +tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done !!");

	}


}
