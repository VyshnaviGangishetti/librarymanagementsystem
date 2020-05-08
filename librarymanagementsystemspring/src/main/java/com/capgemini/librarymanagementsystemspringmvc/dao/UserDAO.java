package com.capgemini.librarymanagementsystemspringmvc.dao;

import java.util.List;

import com.capgemini.librarymanagementsystemspringmvc.dto.BookBeans;
import com.capgemini.librarymanagementsystemspringmvc.dto.BorrowBook;
import com.capgemini.librarymanagementsystemspringmvc.dto.UserBeans;



public interface UserDAO {
	boolean register(UserBeans user);
	UserBeans login(String email,String password);
	boolean addBook(BookBeans book);
	boolean removeBook(int bId);
	boolean updateBook(BookBeans book);
	List<BorrowBook> borrowedBook(int uId);
	List<BookBeans> searchBookById(int bId);
	List<BookBeans> searchBookByTitle(String bookName);
	List<BookBeans> searchBookByAuthor(String author);
	List<BookBeans> getBooksInfo();
	boolean returnBook(int bId,int uId);
	List<Integer> bookHistoryDetails(int uId);
	boolean issueBook(int bId,int uId);
	boolean request(int uId, int bId);
}
