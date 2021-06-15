package com.bfs.lmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@RestController
@SpringBootApplication
@EnableEurekaClient
public class BankApplication {
	/*
	@RequestMapping(value = "/{userName}")
	public String readingList(){
	  return "Spring in Action (Manning), Cloud Native Java (O'Reilly), Learning Spring Boot (Packt)";
	}
	*/
	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

}
