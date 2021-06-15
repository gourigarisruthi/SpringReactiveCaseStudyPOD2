package com.pod2.bank.account.service;

import com.pod2.bank.account.dto.LoanAccountRequest;
import com.pod2.bank.account.model.LoanAccount;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {
//	public Flux<Account> getAllEmployees();
//	public Mono<Account> getEmployee(Integer empId);
//	public Mono<Boolean> updateEmployee(Account employee);
//	public Mono<Boolean> deleteEmployee(Integer empId);
	public Mono<LoanAccount> applyLoan(LoanAccountRequest loanAccount);

	public Mono<LoanAccount> getLoanAccount(Integer id);
}
