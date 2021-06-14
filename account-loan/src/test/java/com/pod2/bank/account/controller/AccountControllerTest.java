package com.pod2.bank.account.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import com.google.gson.Gson;
import com.pod2.bank.account.model.LoanAccount;
import com.pod2.bank.account.service.AccountService;

import reactor.core.publisher.Mono;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerTest {
	
	@Autowired
	WebTestClient webTestClient;
	
	@MockBean
	AccountService accountService;
	
	@Autowired
	Gson gson;
	
	@Test
	public void applyLoanTest( ) {	
		
		LoanAccount loanAccount = new LoanAccount(8, 879, "testUser", 234000.0, 3, 2.5, null, 534.0, "carLoan");
		
		Mockito.when(accountService.applyLoan(Mockito.any())).thenReturn(Mono.just(loanAccount));
		
		webTestClient
			.post()
			.uri("/account/loan").bodyValue(loanAccount)
			.exchange()
			.expectStatus().isCreated()
            .expectBody().jsonPath("$.id", 8);         
			
	}
	
	@Test
	public void getLoanAccountTest( ) {
		LoanAccount loanAccount = new LoanAccount(8, 879, "testUser", 234000.0, 3, 2.5, null, 534.0, "carLoan"); 
		
		Mockito.when(accountService.getLoanAccount(1)).thenReturn(Mono.just(loanAccount));
		
		webTestClient
			.get()
			.uri("/account/8")
			.exchange()
			.expectStatus().isOk()			
			.expectBody().jsonPath("$.loanAccNo", 8);
			//.isEqualTo(loanAccount);
			//.jsonPath("$.id").isEqualTo(8);
		
			//.consumeWith(response -> Assertions.assertThat(response.getResponseBody().);
//			.value(emp -> System.out.println("Emp ID: " + emp.getId()));
	}	

}
