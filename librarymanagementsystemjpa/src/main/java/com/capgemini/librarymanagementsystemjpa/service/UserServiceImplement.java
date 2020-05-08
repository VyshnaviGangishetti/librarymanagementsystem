package com.capgemini.librarymanagementsystemjpa.service;

import java.util.List;

import com.capgemini.librarymanagementsystemjpa.dao.UserDAO;
import com.capgemini.librarymanagementsystemjpa.dto.BookBeans;
import com.capgemini.librarymanagementsystemjpa.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystemjpa.dto.BorrowBook;
import com.capgemini.librarymanagementsystemjpa.dto.RequestDetails;
import com.capgemini.librarymanagementsystemjpa.dto.UserBeans;
import com.capgemini.librarymanagementsystemjpa.factory.LibraryFactory;


public class UserServiceImplement implements UserService{
	private UserDAO dao = LibraryFactory.getUsersDao();

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
	public boolean issueBook(int bId, int uId) {
		return dao.issueBook(bId, uId);
	}

	@Override
	public boolean request(int uId, int bId) {
		return dao.request(uId, bId);
	}

	@Override
	public List<BorrowBook> borrowedBook(int uId) {
		return dao.borrowedBook(uId);
	}

	@Override
	public List<BookBeans> searchBookById(int bId) {
		return dao.searchBookById(bId);
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
	public boolean returnBook(int bId, int uId, String status) {
		return dao.returnBook(bId, uId, status);
	}

	@Override
	public List<Integer> bookHistoryDetails(int uId) {
		return dao.bookHistoryDetails(uId);
	}

	@Override
	public List<RequestDetails> showRequests() {
		return dao.showRequests();
	}

	@Override
	public List<BookIssueDetails> showIssuedBooks() {
		return dao.showIssuedBooks();
	}

	@Override
	public List<UserBeans> showUsers() {
		return dao.showUsers();
	}

	@Override
	public boolean updatePassword(int id, String password, String newPassword, String role) {
		return dao.updatePassword(id, password, newPassword, role);
	}
	


}
