package com.capgemini.librarymanagementsystemspringmvc.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "request_details")
@SequenceGenerator(name = "sequence", initialValue = 1, allocationSize = 100)

public class RequestDetails implements Serializable{
	private int uId;
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")

	private String fullName;
	@Column
	private int bId;
	@Column
	private String bookName;
	
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


}
