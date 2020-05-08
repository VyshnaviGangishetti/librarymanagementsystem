package com.capgemini.librarymanagementsystemcollections.dto;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class RequestBeans implements Serializable{
	private BookBeans bookInfo;
	private UserBeans userInfo;
	private boolean isIssued;
	private boolean isReturned;
	private LocalDate issuedDate;
	private LocalDate returnedDate;
	public BookBeans getBookInfo() {
		return bookInfo;
	}
	public void setBookInfo(BookBeans bookInfo) {
		this.bookInfo = bookInfo;
	}
	public UserBeans getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserBeans userInfo) {
		this.userInfo = userInfo;
	}
	public boolean isIssued() {
		return isIssued;
	}
	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}
	public boolean isReturned() {
		return isReturned;
	}
	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}
	public LocalDate getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(LocalDate issuedDate) {
		this.issuedDate = issuedDate;
	}
	public LocalDate getReturnedDate() {
		return returnedDate;
	}
	public void setReturnedDate(LocalDate returnedDate) {
		this.returnedDate = returnedDate;
	}

}//End of class
