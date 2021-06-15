package com.pod2.bank.account.service;


import java.util.concurrent.ExecutionException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.pod2.bank.account.dto.LoanAccountRequest;
import com.pod2.bank.account.model.LoanAccount;
import com.pod2.bank.account.repository.AccountRepository;

import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepo;
	
//	@Autowired
//	PasswordEncoder encoder;

	@Override
	public Mono<LoanAccount> applyLoan(LoanAccountRequest loanAccountRequest) {
		Mono<LoanAccount> savedLoanAccount = null;
		WebClient webclient = WebClient.create("http://localhost:9191");
		Mono<User> customer = 
				  webclient.get()		// GET request
				 .uri("/bank/"+1)		// URI				 
				 .retrieve()
				 .bodyToMono(User.class);
		//if(encoder.encode(loanAccountRequest.getPassword()).equals(customer.map(user -> user.getPassword()))) {
			try {
				if(loanAccountRequest.getPassword().equals(customer.toFuture().get().getPassword())) {
				LoanAccount loanAccount = new LoanAccount();
				BeanUtils.copyProperties(loanAccountRequest, loanAccount);
				savedLoanAccount = accountRepo.save(loanAccount);
}
			} catch (Exception e) {
			  e.printStackTrace();
			}
			
//			customer.flatMap( user -> return if(loanAccountRequest.getPassword().equals(customer.toFuture().get().getPassword())) {
//				LoanAccount loanAccount = new LoanAccount();
//				BeanUtils.copyProperties(loanAccountRequest, loanAccount);
//				savedLoanAccount = accountRepo.save(loanAccount);
//})
		return savedLoanAccount;
	}

	@Override
	public Mono<LoanAccount> getLoanAccount(Integer id) {
		// TODO Auto-generated method stub
		return accountRepo.findById(id);
	}

//	@Override
//	public Flux<LoanAccount> getAllEmployees() {
//		return empRepo.findAll();
//	}
//
//	@Override
//	public Mono<LoanAccount> getEmployee(Integer empId) {
//		return empRepo.findById(empId);
//	}
//
//	@Override
//	public Mono<LoanAccount> createEmployee(LoanAccount employee) {
//		return empRepo.save(employee);
//	}
//
//	@Override
//	public Mono<Boolean> updateEmployee(LoanAccount employee) {
//		try {		
//
//			empRepo.save(employee).block();
//		}catch(Exception e) {
//			return Mono.just(Boolean.FALSE);
//		}
//		return Mono.just(Boolean.TRUE);
//	}
//
//	@Override
//	public Mono<Boolean> deleteEmployee(Integer empId) {
//		try {
//			empRepo.deleteById(empId).block();
//		}catch(Exception e) {
//			return Mono.just(Boolean.FALSE);
//		}
//		return Mono.just(Boolean.TRUE);
//	}

}
