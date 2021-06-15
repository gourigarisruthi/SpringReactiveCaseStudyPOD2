package com.pod2.bank.account.dto;

import java.sql.Timestamp;

public class LoanAccountRequest {

	private Integer loanAccNo;
	private Integer accountNo;
	private String userId;
	private Double loanAmount;
	private Integer loanTenure;
	private Double intRate;
	private Timestamp openDate;
	private Double monthlyEMI;
	private String loanType;
	private String userName;
	private String password;
	
	

	public LoanAccountRequest(Integer loanAccNo, Integer accountNo, String userId, Double loanAmount,
			Integer loanTenure, Double intRate, Timestamp openDate, Double monthlyEMI, String loanType, String userName,
			String password) {
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
		this.userName = userName;
		this.password = password;
	}
	
	
	public LoanAccountRequest() {
		super();
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
	public Integer getLoanTenure() {
		return loanTenure;
	}
	public void setLoanTenure(Integer loanTenure) {
		this.loanTenure = loanTenure;
	}
	public Double getIntRate() {
		return intRate;
	}
	public void setIntRate(Double intRate) {
		this.intRate = intRate;
	}
	public Timestamp getOpenDate() {
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


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
