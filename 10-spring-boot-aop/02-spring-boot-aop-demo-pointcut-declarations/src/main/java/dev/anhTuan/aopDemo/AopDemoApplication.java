package dev.anhTuan.aopDemo;

import dev.anhTuan.aopDemo.dao.AccountDAO;
import dev.anhTuan.aopDemo.dao.MembershipDAO;
import dev.anhTuan.aopDemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopDemoApplication {



	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO
																	, TrafficFortuneService theTrafficFortuneService){

		return runner ->{

//			demoTheBeforeAdvice(accountDAO,membershipDAO);
//			demoTheAfterReturningAdvice(accountDAO);
//			demoTheAfterThrowingAdvice(accountDAO);
//			demoTheAfterAdvice(accountDAO);
//			demoTheAroundAdvice(theTrafficFortuneService);
//			demoTheAroundADviceHandleException(theTrafficFortuneService);

			demoTheAroundAdviceRethrowException(theTrafficFortuneService);


		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdviceRethrowException");

		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: "+data);

		System.out.println("Finished");


	}

	private void demoTheAroundADviceHandleException(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdvice");

		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: "+data);

		System.out.println("Finished");



	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdvice");

		System.out.println("Calling getFortune()");

		String data = theTrafficFortuneService.getFortune();

		System.out.println("\nMy fortune is: "+data);

		System.out.println("Finished");

	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {
		List<Account>theAccounts = null;
		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = false;
			theAccounts =  accountDAO.findAccounts(tripWire);

		}catch (Exception exc){
			System.out.println("\n\nMain Program: .... caught excepton: "+exc);
		}

		// display the accounts
		System.out.println("\n\nMain program: demoTheAfterThrowingAdvice");
		System.out.println("-----");
		System.out.println(theAccounts);
		System.out.println("\n");

	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		List<Account>theAccounts = null;
		try {
			// add a boolean flag to simulate exceptions
			boolean tripWire = true;
			theAccounts =  accountDAO.findAccounts(tripWire);

		}catch (Exception exc){
			System.out.println("\n\nMain Program: .... caught excepton: "+exc);
		}

		// display the accounts
		System.out.println("\n\nMain program: demoTheAfterThrowingAdvice");
		System.out.println("-----");
		System.out.println(theAccounts);
		System.out.println("\n");


	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
		// call method to find the accounts
		List<Account>theAccounts = accountDAO.findAccounts();

		// display the accounts
		System.out.println("\n\nMain program: demoTheAfterReturingAdvice");
		System.out.println("-----");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {


		Account myAccount = new Account();
		myAccount.setName("Madhu");
		myAccount.setLevel("Platinum");
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
