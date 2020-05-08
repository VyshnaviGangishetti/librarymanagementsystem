package com.capgemini.librarymanagementsystemjpa.dao;

import java.util.List;

import com.capgemini.librarymanagementsystemjpa.dto.BookBeans;
import com.capgemini.librarymanagementsystemjpa.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystemjpa.dto.BorrowBook;
import com.capgemini.librarymanagementsystemjpa.dto.RequestDetails;
import com.capgemini.librarymanagementsystemjpa.dto.UserBeans;



public interface UserDAO {
	boolean register(UserBeans user);
	UserBeans login(String email,String password);
	boolean addBook(BookBeans book);
	boolean removeBook(int bId);
	boolean updateBook(BookBeans book);
	boolean issueBook(int bId,int uId);
	boolean request(int uId, int bId);
	List<BorrowBook> borrowedBook(int uId);
	List<BookBeans> searchBookById(int bId);
	List<BookBeans> searchBookByTitle(String bookName);
	List<BookBeans> searchBookByAuthor(String author);
	List<BookBeans> getBooksInfo();
	boolean returnBook(int bId,int uId,String status);
	List<Integer> bookHistoryDetails(int uId);
	List<RequestDetails> showRequests();
	List<BookIssueDetails> showIssuedBooks();
	List<UserBeans> showUsers();
	boolean updatePassword(int id,String password,String newPassword,String role);


}
