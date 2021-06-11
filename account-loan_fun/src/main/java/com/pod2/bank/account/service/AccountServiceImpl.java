package com.pod2.bank.account.service;


import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pod2.bank.account.model.LoanAccount;
import com.pod2.bank.account.repository.AccountRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepo;

	@Override
	public Mono<LoanAccount> applyLoan(LoanAccount loanAccount) {
		System.out.println("rewret");
		//loanAccount.setOpenDate(new Date(124361538611));
		// TODO Auto-generated method stub
		Mono<LoanAccount> mono = accountRepo.save(loanAccount);
		return mono;
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
