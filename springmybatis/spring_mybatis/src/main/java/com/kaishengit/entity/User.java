package com.kaishengit.entity;

public class User {

	private Integer id;
	private String userName;
	private String password;
	private String address;
	private Integer accountId;

	
	public User() {
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Integer getAccountId() {
		return accountId;
	}


	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}


	public User(String userName, String password, String address, Integer accountId) {
		super();
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.accountId = accountId;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", address=" + address
				+ ", accountId=" + accountId + "]";
	}

	
	
}
