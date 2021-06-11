package com.pod2.bank.account.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.pod2.bank.account.model.LoanAccount;

import reactor.core.publisher.Flux;

public interface AccountRepository extends ReactiveCrudRepository<LoanAccount, Integer>{
	
	// find by Department
	//
//	// find by Department and Country
//	public Flux<Account> findByDepartmentAndCountry(String department, String country);
//	
//	@Query("SELECT e FROM LOAN_ACCOUNT e WHERE empName= :empName")
//	public Flux<Account> findByEmployeeName(@Param("empName") String empName);
}
