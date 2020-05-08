package com.capgemini.librarymanagementsystemcollections.service;

import java.util.List;

import com.capgemini.librarymanagementsystemcollections.dao.UserDAO;
import com.capgemini.librarymanagementsystemcollections.dto.BookBeans;
import com.capgemini.librarymanagementsystemcollections.dto.RequestBeans;
import com.capgemini.librarymanagementsystemcollections.dto.UserBeans;
import com.capgemini.librarymanagementsystemcollections.factory.LibraryFactory;


public class UserServiceImplementation implements UserService{

	private UserDAO dao = LibraryFactory.getUserDao();

	@Override
	public boolean registerUser(UserBeans user) {
		return dao.registerUser(user);
	}

	@Override
	public UserBeans loginUser(String email, String password) {
		return dao.loginUser(email, password);
	}

	@Override
	public RequestBeans bookRequest(UserBeans user, BookBeans book) {
		return dao.bookRequest(user, book);
	}

	@Override
	public RequestBeans bookReturn(UserBeans user, BookBeans book) {
		return dao.bookReturn(user, book);
	}

	@Override
	public List<BookBeans> searchBookByTitle(String bookName) {
		return dao.searchBookByTitle(bookName);
	}

	@Override
	public List<BookBeans> searchBookByAuthor(String author) {
		return dao.searchBookByAuthor(author);
	}

	@Override
	public List<BookBeans> searchBookByCategory(String category) {
		return dao.searchBookByCategory(category);
	}

	@Override
	public List<BookBeans> getBooksInfo() {
		return dao.getBooksInfo();
	}	

}//End of class
