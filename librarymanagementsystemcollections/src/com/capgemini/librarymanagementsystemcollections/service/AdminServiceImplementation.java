package com.capgemini.librarymanagementsystemcollections.service;

import java.util.List;

import com.capgemini.librarymanagementsystemcollections.dao.AdminDAO;
import com.capgemini.librarymanagementsystemcollections.dto.AdminBeans;
import com.capgemini.librarymanagementsystemcollections.dto.BookBeans;
import com.capgemini.librarymanagementsystemcollections.dto.RequestBeans;
import com.capgemini.librarymanagementsystemcollections.dto.UserBeans;
import com.capgemini.librarymanagementsystemcollections.factory.LibraryFactory;



public class AdminServiceImplementation implements AdminService{
	private AdminDAO dao = LibraryFactory.getAdminDao();

	@Override
	public boolean registerAdmin(AdminBeans admin) {
		return dao.registerAdmin(admin);
	}

	@Override
	public AdminBeans loginAdmin(String email, String password) {
		return dao.loginAdmin(email, password);
	}

	@Override
	public boolean addBook(BookBeans book) {
		return dao.addBook(book);
	}

	@Override
	public boolean removeBook(int id) {
		return dao.removeBook(id);
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

	@Override
	public List<UserBeans> showUsers() {
		return dao.showUsers();
	}

	@Override
	public List<RequestBeans> showRequests() {
		return dao.showRequests();
	}

	@Override
	public boolean bookIssue(UserBeans user, BookBeans book) {
		return dao.bookIssue(user, book);
	}

	@Override
	public boolean isBookReceived(UserBeans user, BookBeans book) {
		return dao.isBookReceived(user, book);
	}

	

}//End of class
