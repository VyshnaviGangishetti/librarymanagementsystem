package com.capgemini.librarymanagementsystemspringmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.librarymanagementsystemspringmvc.dao.UserDAO;
import com.capgemini.librarymanagementsystemspringmvc.dto.BookBeans;
import com.capgemini.librarymanagementsystemspringmvc.dto.BorrowBook;
import com.capgemini.librarymanagementsystemspringmvc.dto.UserBeans;


public class UserServiceImplement implements UserService{
	@Autowired
	private UserDAO dao ;

	@Override
	public boolean register(UserBeans user) {
		return dao.register(user);
	}

	@Override
	public UserBeans login(String email, String password) {
		return dao.login(email, password);
	}

	@Override
	public boolean addBook(BookBeans book) {
		return dao.addBook(book);
	}

	@Override
	public boolean removeBook(int bId) {
		return dao.removeBook(bId);
	}

	@Override
	public boolean updateBook(BookBeans book) {
		return dao.updateBook(book);
	}

	@Override
	public boolean issueBook(int bId,int uId) {
		return dao.issueBook(bId,uId);
	}

	@Override
	public boolean request(int uId, int bId) {
		return dao.request(uId, bId);
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
	public List<BookBeans> getBooksInfo() {
		return dao.getBooksInfo();
	}

	@Override
	public boolean returnBook(int bId,int uId) {
		return dao.returnBook(bId,uId);
	}

	@Override
	public List<Integer> bookHistoryDetails(int uId) {
		return dao.bookHistoryDetails(uId);
	}

	@Override
	public List<BorrowBook> borrowedBook(int uId) {
		return dao.borrowedBook(uId);
	}

	@Override
	public List<BookBeans> searchBookById(int bId) {
		return dao.searchBookById(bId);
	}




}
