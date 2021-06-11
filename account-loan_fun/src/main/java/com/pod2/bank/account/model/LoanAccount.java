package com.pod2.bank.account.model;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class LoanAccount {
	@Id
	private Integer loanAccNo;
	private Integer accountNo;
	private String userId;
	private Double loanAmount;
	private Integer loanTenure;
	private Double intRate;
	private Timestamp openDate;
	private Double monthlyEMI;
	private String loanType;

	public LoanAccount() {
		super();
	}
	public LoanAccount(Integer loanAccNo, Integer accountNo, String userId, Double loanAmount, Integer loanTenure,
			Double intRate, Timestamp openDate, Double monthlyEMI, String loanType) {
		super();
		this.loanAccNo = loanAccNo;
		this.accountNo = accountNo;
		this.userId = userId;
		this.loanAmount = loanAmount;
		this.loanTenure = loanTenure;
		this.intRate = intRate;
		this.openDate = openDate;
		this.monthlyEMI = monthlyEMI;
		this.loanType = loanType;
	}
	public Integer getLoanAccNo() {
		return loanAccNo;
	}
	public void setLoanAccNo(Integer loanAccNo) {
		this.loanAccNo = loanAccNo;
	}
	public Integer getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public Integer getLoanTenre() {
		return loanTenure;
	}
	public void setLoanTenre(Integer loanTenure) {
		this.loanTenure = loanTenure;
	}
	public Double getIntRate() {
		return intRate;
	}
	public void setIntRate(Double intRate) {
		this.intRate = intRate;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Timestamp openDate) {
		this.openDate = openDate;
	}
	public Double getMonthlyEMI() {
		return monthlyEMI;
	}
	public void setMonthlyEMI(Double monthlyEMI) {
		this.monthlyEMI = monthlyEMI;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
}
