package com.capgemini.librarymanagementsystemcollections.dao;

import java.util.List;

import com.capgemini.librarymanagementsystemcollections.dto.AdminBeans;
import com.capgemini.librarymanagementsystemcollections.dto.BookBeans;
import com.capgemini.librarymanagementsystemcollections.dto.RequestBeans;
import com.capgemini.librarymanagementsystemcollections.dto.UserBeans;


public interface AdminDAO {
	boolean registerAdmin(AdminBeans admin);
	AdminBeans loginAdmin(String email,String password);
	boolean addBook(BookBeans book);
	boolean removeBook(int id);
	List<BookBeans> searchBookByTitle(String bookName);
	List<BookBeans> searchBookByAuthor(String author);
	List<BookBeans> searchBookByCategory(String category);
	List<BookBeans> getBooksInfo();

	List<UserBeans> showUsers();
	List<RequestBeans> showRequests();
	boolean bookIssue(UserBeans user,BookBeans book);
	boolean isBookReceived(UserBeans user,BookBeans book);

}

