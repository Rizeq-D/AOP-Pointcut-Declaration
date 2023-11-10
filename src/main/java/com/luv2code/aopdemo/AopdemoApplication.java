package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO,
											   TrafficFortuneService theTrafficFortuneService) {

		return runner -> {

			// demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
			//findTheAccounts(theAccountDAO);
			// demoTheAfterReturningAdvice(theAccountDAO);
			// demoTheAfterThrowingAdvice(theAccountDAO);
			// demoTheAfterAdvice(theAccountDAO);
			// demoTheAroundAdvice(theTrafficFortuneService);
			// demoTheAroundAdviceHandleExceptions(theTrafficFortuneService);

			demoTheAroundAdviceHandleReThrowExceptions(theTrafficFortuneService);

		};
	}

	private void demoTheAroundAdviceHandleReThrowExceptions(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("the main program is: demoTheAroundAdviceHandleReThrowExceptions.");

		System.out.println("calling fortune...");

		boolean tripWire = true;

		String data = theTrafficFortuneService.fortune(tripWire);

		System.out.println(data);

		System.out.println("--------------------------------");
	}

	private void demoTheAroundAdviceHandleExceptions(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("the main program is: demoTheAroundAdviceHandleExceptionsg.");

		System.out.println("calling fortune...");

		boolean tripWire = true;

		String data = theTrafficFortuneService.fortune(tripWire);

		System.out.println(data);

		System.out.println("--------------------------------");
	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("the main program is: DEMOTHEAROUNDADVICE.");

		System.out.println("calling fortune...");

		String data = theTrafficFortuneService.fortune();

		System.out.println(data);

		System.out.println("--------------------------------");
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {

		// call method to find the account.
		List<Account> theAccounts = null;

		try {
			// add a boolean flag to simulate exceptions.
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}

		catch (Exception exe) {

			System.out.println("\n \n caught exception: " + exe);
		}

		// display the accounts.
		System.out.println("\n the main program: demoTheAfterReturningAdvice");
		System.out.println("-----------------------------");

		System.out.println(theAccounts);

		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {

		// call method to find the account.
		List<Account> theAccounts = null;

		try {
			// add a boolean flag to simulate exceptions.
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}

		catch (Exception exe) {

			System.out.println("\n \n caught exception: " + exe);
		}

		// display the accounts.
		System.out.println("\n the main program: demoTheAfterReturningAdvice");
		System.out.println("-----------------------------");

		System.out.println(theAccounts);

		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {

		// call method to find the account.
		List<Account> theAccounts = theAccountDAO.findAccounts();

		// display the accounts.
		System.out.println("\n the main program: demoTheAfterReturningAdvice");
		System.out.println("-----------------------------");

		System.out.println(theAccounts);

		System.out.println("\n");

	}

	private void findTheAccounts(AccountDAO theAccountDAO) {

		// call the method to find the accounts.
		List<Account> theAccount = theAccountDAO.findAccounts();

		// display the accounts.
		System.out.println("\n Main Program: ");

		System.out.println(theAccount);
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		Account myAccount = new Account();
		myAccount.setName("Luffy");
		myAccount.setLevel("1000000");

		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.dancer();
		theAccountDAO.setServiceCode("multi service");
		theAccountDAO.setName("Mirko");

		String name = theAccountDAO.getName();
		String service = theAccountDAO.getServiceCode();

		theMembershipDAO.addSillyMember();
		theMembershipDAO.goingToSleep();

	}

}
