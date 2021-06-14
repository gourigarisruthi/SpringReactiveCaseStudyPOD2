//package com.pod2.bank.account.service;
//
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import com.pod2.bank.account.model.LoanAccount;
//import com.pod2.bank.account.repository.AccountRepository;
//
//import reactor.core.publisher.Mono;
//import reactor.test.StepVerifier;
//
//public class AccountServiceImplTest {
//	
//	AccountServiceImpl accountServiceImpl;
//	
//	AccountRepository accountRepo;
//	
//	@BeforeAll
//	public static void setup() {
//		System.out.println("Before All called...");
//	}
//
//	@BeforeEach
//	public void setupTest() {
//		System.out.println("Before Each called...");
//		accountServiceImpl = new AccountServiceImpl();
//	}
//	
//	
//	
//	@Test
//	public void getLoanAccountTest() {
//		LoanAccount loanAccount = new LoanAccount(8, 879, "testUser", 234000.0, 3, 2.5, null, 534.0, "carLoan"); 
//		
//		Mockito.when(accountServiceImpl.getLoanAccount(8)).thenReturn(Mono.just(loanAccount));
//		
//		//accountServiceImpl.applyLoan(new LoanAccount(8, 879, "testUser", 234000.0, 3, 2.5, null, 534.0, "carLoan"));
//		
//		StepVerifier
//		.create(accountServiceImpl.getLoanAccount(8))
//		.expectNextCount(1)
//		.expectComplete()
//		.verify();			
//	}
//	
////	@Test
////	public void givenEmployeeId_whenGetEmployee_thenMatchEmployee() {
////		
////		//Mono<Employee> emp = empService.createEmployee(new Employee(5, "Tennis", 30, "Male", false, "Lead", "IT", "Mumbai", "India"));
////		
////		StepVerifier
////		.create(empService.getEmployee(1))
////		.expectNextCount(1)
////		.expectComplete()
////		.verify();	
////		
////	}
////	
////	@Test
////	public void givenEmployee_whenCreateEmployee_thenReturnCreatedEmployee() {
////		
////		Employee emp = new Employee(5, "Tennis", 30, "Male", false, "Lead", "IT", "Mumbai", "India");
////		
////		StepVerifier
////		.create(empService.createEmployee(emp))
////		.expectNext(emp)
////		.expectComplete()
////		.verify();
////		
//////		empService.getEmployee(5).subscribe(System.out::println);
//////		System.out.println("Employee ### " + emp1);
////		
////		StepVerifier
////		.create(empService.getEmployee(5))
////		.expectNext(emp)
////		.expectComplete()
////		.verify();			
////		
////	}	
////	
////	@AfterEach
////	public void tearDownTest() {
////		empService.deleteAll();
////		System.out.println("After Each called...");
////	}
////	
//	@AfterAll
//	public static void tearDown() {
//		
//		System.out.println("After All called...");
//	}
//
//}
