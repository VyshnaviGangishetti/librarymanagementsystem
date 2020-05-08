package com.capgemini.librarymanagementsystemcollections.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AdminBeans implements Serializable{
	private int id = (int)Math.random();
	private String name;
	private String password;
	private String email;
	private long mobile;
	
	public AdminBeans() {
		// TODO Auto-generated constructor stub
	}
	
	public AdminBeans(int id,String name,String password,String email,long mobile) {
		super();
		this.id = id;
		this.name=name;
		this.password=password;
		this.email=email;
		this.mobile=mobile;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	


}//End of class

