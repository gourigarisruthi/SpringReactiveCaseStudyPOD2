package com.bfs.lmt.controller;

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

import com.bfs.lmt.entities.User;
import com.bfs.lmt.reqres.ResponseMessage;
import com.bfs.lmt.service.BankService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bank")
public class BankController {

	@Autowired
	BankService bankService;

//	Create User 	POST	/user
//	Get All User	GET		/user
//	Update User		PUT		/user/{userName}
//	Delete User		DELETE	/user/{userName}
//	Get User		GET		/user/{userName}	

	/*
	private final RestTemplate restTemplate;
	
	public BankServiceImpl(RestTemplate rest) {
	  this.restTemplate = rest;
	}
	public String reliable() {
		  return "Cloud Native Java (O'Reilly)";
	}
	@HystrixCommand(fallbackMethod = "reliable")
	*/
	@GetMapping("/{userName}")
	public Mono<User> getEmployee(@PathVariable Integer userName) {
		return bankService.getUser(userName);
	}
	
	@PostMapping("/user")
	public Mono<ResponseEntity<ResponseMessage>> createUser(@RequestBody User user)
			throws URISyntaxException {
		Mono<User> usr = bankService.createUser(user);

		StringBuilder locationStr = new StringBuilder();
		usr.subscribe(e -> locationStr.append("http://localhost:8085/bank/user/").append(e.getUsername()));

		// Getting current resource path
		URI location = new URI(locationStr.toString());

		return Mono.just(ResponseEntity.created(location).body(this.getResponse(user.getUsername(), "User Created")));
	}

	@GetMapping
	public Flux<User> getAllUsers() {
		return bankService.getAllUsers();
	}
	
/*
	@PutMapping("/{id}")
	public Mono<ResponseEntity<ResponseMessage>> updateEmployee(@RequestBody User employee,
			@PathVariable Integer id) {
		employee.setId(id);
		bankService.updateEmployee(employee);

		return Mono.just(ResponseEntity.ok().body(this.getResponse(employee.getId(), "Employee Updated")));
	}

	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<ResponseMessage>> deleteEmployee(@PathVariable Integer id) {
		bankService.deleteEmployee(id);
		ResponseMessage response = getResponse(id, "Employee Deleted");

		return Mono.just(ResponseEntity.accepted().body(response));
	}
*/
/*
	@GetMapping("/test")
	public Mono<String> getEmployee() {
		return (Mono<String>) Mono.just("SUCSESS").log().subscribe(System.out::println); 
	}
*/	
	private ResponseMessage getResponse(Integer userName, String message) {
		ResponseMessage response = new ResponseMessage();
		response.setUserName(userName);
		response.setStatus(HttpStatus.OK.name());
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage(message);
		return response;
	}

}
