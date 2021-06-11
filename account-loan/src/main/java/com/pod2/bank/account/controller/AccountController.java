package com.pod2.bank.account.controller;


import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.pod2.bank.account.model.LoanAccount;
import com.pod2.bank.account.model.ResponseMessage;
import com.pod2.bank.account.service.AccountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;

//	Create Employee 	POST	/employees
//	Get All Employees	GET		/employees
//	Update Employee		PUT		/employees/{id}
//	Delete Employee		DELETE	/employees/{id}
//	Get Employee		GET		/employees/{id}	

//	@GetMapping
//	public Flux<Account> getAllEmployees() {
//		return empService.getAllEmployees();
//	}
//
	@GetMapping("/{id}")
	public Mono<LoanAccount> getLoanAccount(@PathVariable Integer id) {
		return accountService.getLoanAccount(id);
	}
//
	@PostMapping("/loan")
	public Mono<ResponseEntity<ResponseMessage>> applyLoan(@RequestBody LoanAccount loanAccount)
			throws URISyntaxException {
		//WebClient webclient = WebClient.create("http://localhost:8080");
		Mono<LoanAccount> acc = accountService.applyLoan(loanAccount);

		StringBuilder locationStr = new StringBuilder();
		acc.subscribe(a -> locationStr.append("http://localhost:8081/account/").append(8));

		// Getting current resource path
		URI location = new URI(locationStr.toString());
		System.out.println(location.toString());

		return Mono.just(ResponseEntity.created(location).body(this.getResponse(loanAccount.getAccountNo(), "loan approved")));
	}
//
//	@PutMapping("/{id}")
//	public Mono<ResponseEntity<ResponseMessage>> updateEmployee(@RequestBody Account employee,
//			@PathVariable Integer id) {
//		employee.setId(id);
//		empService.updateEmployee(employee);
//
//		return Mono.just(ResponseEntity.ok().body(this.getResponse(employee.getId(), "Employee Updated")));
//	}
//
//	@DeleteMapping("/{id}")
//	public Mono<ResponseEntity<ResponseMessage>> deleteEmployee(@PathVariable Integer id) {
//		empService.deleteEmployee(id);
//		ResponseMessage response = getResponse(id, "Employee Deleted");
//
//		return Mono.just(ResponseEntity.accepted().body(response));
//	}

	private ResponseMessage getResponse(Integer id, String message) {
		ResponseMessage response = new ResponseMessage();
		response.setId(id);
		response.setStatus(HttpStatus.OK.name());
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage(message);
		return response;
	}

}
