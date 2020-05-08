package com.capgemini.librarymanagementsystemspringmvc.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_DEFAULT)

public class LibraryBean {
	private boolean error;
	private String message;
	private UserBeans usersBean;
	private List<UserBeans> userList;
	private BookBeans bookBean;
	private List<BookBeans> bookList;
	private List<Integer> bookIdList;
	private RequestDetails requestBean;
	private List<RequestDetails> requestList;
	private BookIssueDetails bookIssueDetailsBean;
	private List<BookIssueDetails> bookIssueDetailsList;
	private BorrowBook borrowedBooksBean;
	private List<BorrowBook> borrowedBooksList;
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UserBeans getUsersBean() {
		return usersBean;
	}
	public void setUsersBean(UserBeans usersBean) {
		this.usersBean = usersBean;
	}
	public List<UserBeans> getUserList() {
		return userList;
	}
	public void setUserList(List<UserBeans> userList) {
		this.userList = userList;
	}
	public BookBeans getBookBean() {
		return bookBean;
	}
	public void setBookBean(BookBeans bookBean) {
		this.bookBean = bookBean;
	}
	public List<BookBeans> getBookList() {
		return bookList;
	}
	public void setBookList(List<BookBeans> bookList) {
		this.bookList = bookList;
	}
	public List<Integer> getBookIdList() {
		return bookIdList;
	}
	public void setBookIdList(List<Integer> bookIdList) {
		this.bookIdList = bookIdList;
	}
	public RequestDetails getRequestBean() {
		return requestBean;
	}
	public void setRequestBean(RequestDetails requestBean) {
		this.requestBean = requestBean;
	}
	public List<RequestDetails> getRequestList() {
		return requestList;
	}
	public void setRequestList(List<RequestDetails> requestList) {
		this.requestList = requestList;
	}
	public BookIssueDetails getBookIssueDetailsBean() {
		return bookIssueDetailsBean;
	}
	public void setBookIssueDetailsBean(BookIssueDetails bookIssueDetailsBean) {
		this.bookIssueDetailsBean = bookIssueDetailsBean;
	}
	public List<BookIssueDetails> getBookIssueDetailsList() {
		return bookIssueDetailsList;
	}
	public void setBookIssueDetailsList(List<BookIssueDetails> bookIssueDetailsList) {
		this.bookIssueDetailsList = bookIssueDetailsList;
	}
	public BorrowBook getBorrowedBooksBean() {
		return borrowedBooksBean;
	}
	public void setBorrowedBooksBean(BorrowBook borrowedBooksBean) {
		this.borrowedBooksBean = borrowedBooksBean;
	}
	public List<BorrowBook> getBorrowedBooksList() {
		return borrowedBooksList;
	}
	public void setBorrowedBooksList(List<BorrowBook> borrowedBooksList) {
		this.borrowedBooksList = borrowedBooksList;
	}
	
}
