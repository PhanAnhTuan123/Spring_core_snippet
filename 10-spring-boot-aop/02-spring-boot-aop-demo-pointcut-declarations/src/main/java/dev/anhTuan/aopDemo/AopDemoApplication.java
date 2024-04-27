package dev.anhTuan.aopDemo;

import dev.anhTuan.aopDemo.dao.AccountDAO;
import dev.anhTuan.aopDemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {



	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){

		return runner ->{

			demoTheBeforeAdvice(accountDAO,membershipDAO);



		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {


		Account myAccount = new Account();
		// call the business method
		accountDAO.addAccount(myAccount,true);
		accountDAO.doWork();
		System.out.println("Before");
		// call the accountdao getter/setter methods
		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");
		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();

		System.out.println("After");

		// call the membership business method
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();



//		// do it again!
//		System.out.println("\n let's call it again!\n");
//
//		//call the business method again
//		accountDAO.addAccount();
//
//		//call the membership business method
//		membershipDAO.addAccount();


	}


}
