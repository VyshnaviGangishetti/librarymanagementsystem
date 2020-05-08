package com.capgemini.librarymanagementsystemjdbc.dao;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.BookBeans;
import com.capgemini.librarymanagementsystemjdbc.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystemjdbc.dto.BorrowBook;
import com.capgemini.librarymanagementsystemjdbc.dto.RequestDetails;
import com.capgemini.librarymanagementsystemjdbc.dto.UserBeans;



public interface UserDAO {
	boolean register(UserBeans user);
	UserBeans login(String email,String password);
	boolean addBook(BookBeans book);
	boolean removeBook(int bId);
	boolean updateBook(BookBeans book);
	boolean issueBook(int bId,int uId);
	boolean request(int uId, int bId);
	List<BorrowBook> borrowedBook(int uId);
	LinkedList<BookBeans> searchBookById(int bId);
	LinkedList<BookBeans> searchBookByTitle(String bookName);
	LinkedList<BookBeans> searchBookByAuthor(String author);
	LinkedList<BookBeans> getBooksInfo();
	boolean returnBook(int bId,int uId,String status);
	LinkedList<BookIssueDetails> bookHistoryDetails(int uId);
	LinkedList<RequestDetails> showRequests();
	LinkedList<BookIssueDetails> showIssuedBooks();
	LinkedList<UserBeans> showUsers();
	boolean updatePassword(String email,String password,String newPassword,String role);
}
