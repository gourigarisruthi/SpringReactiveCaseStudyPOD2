package com.pod2.bank.account.controller;


import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.pod2.bank.account.dto.LoanAccountRequest;
import com.pod2.bank.account.model.LoanAccount;
import com.pod2.bank.account.service.AccountService;

@Component
public class AccountRoute {

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
	@Bean
	RouterFunction<ServerResponse> getLoanAccount() {
		return route(GET("/account_func/{id}"), 
				  req -> ok().body(accountService.getLoanAccount(Integer.valueOf(req.pathVariable("id"))),LoanAccount.class));
	}
//
	@Bean
	RouterFunction<ServerResponse> applyLoan()
			throws URISyntaxException {
		//WebClient webclient = WebClient.create("http://localhost:8080");
//		Mono<LoanAccount> acc = accountService.applyLoan(loanAccount);
//
//		StringBuilder locationStr = new StringBuilder();
//		acc.subscribe(a -> locationStr.append("http://localhost:8081/account/").append(8));
//
//		// Getting current resource path
//		URI location = new URI(locationStr.toString());
//		System.out.println(location.toString());

		return route(POST("/account_func/loan"), 
				 req ->  ok().body(
						 req.bodyToMono(LoanAccountRequest.class).flatMap(obj ->
						 accountService.applyLoan(obj)),LoanAccount.class));
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

//	private ResponseMessage getResponse(Integer id, String message) {
//		ResponseMessage response = new ResponseMessage();
//		response.setId(id);
//		response.setStatus(HttpStatus.OK.name());
//		response.setStatusCode(HttpStatus.OK.value());
//		response.setMessage(message);
//		return response;
//	}

}
