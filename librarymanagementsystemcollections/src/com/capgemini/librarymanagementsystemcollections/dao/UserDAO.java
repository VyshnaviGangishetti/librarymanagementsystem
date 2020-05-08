package com.capgemini.librarymanagementsystemcollections.dao;

import java.util.List;

import com.capgemini.librarymanagementsystemcollections.dto.BookBeans;
import com.capgemini.librarymanagementsystemcollections.dto.RequestBeans;
import com.capgemini.librarymanagementsystemcollections.dto.UserBeans;


public interface UserDAO {
	boolean registerUser(UserBeans user);
	UserBeans loginUser(String email,String password);
	public RequestBeans bookRequest(UserBeans user, BookBeans book);
	public RequestBeans bookReturn(UserBeans user, BookBeans book);
	List<BookBeans> searchBookByTitle(String bookName);
	List<BookBeans> searchBookByAuthor(String author);
	List<BookBeans> searchBookByCategory(String category);
	List<BookBeans> getBooksInfo();

}
