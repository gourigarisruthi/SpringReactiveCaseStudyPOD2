package com.bfs.lmt.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

//@Table("bank.user")
public class User {
	
	@Id
	private Integer username;	
	private String password;
	private String name;
	private String address;
	private String state;
	private String country;
	private String emailaddress;
	private String pan;
	private String contactno;
	private String dob;
	private String accounttype;
		
	public User() {
		
	}

	public User(Integer username, String password, String name, String address, String state, String country,
			String emailaddress, String pan, String contactno, String dob, String accounttype) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.address = address;
		this.state = state;
		this.country = country;
		this.emailaddress = emailaddress;
		this.pan = pan;
		this.contactno = contactno;
		this.dob = dob;
		this.accounttype = accounttype;
	}

	public Integer getUsername() {
		return username;
	}
	public void setUsername(Integer username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}
			
}
