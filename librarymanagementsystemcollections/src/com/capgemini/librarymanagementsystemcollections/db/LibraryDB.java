package com.capgemini.librarymanagementsystemcollections.db;

import java.util.LinkedList;

import com.capgemini.librarymanagementsystemcollections.dto.AdminBeans;
import com.capgemini.librarymanagementsystemcollections.dto.BookBeans;
import com.capgemini.librarymanagementsystemcollections.dto.RequestBeans;
import com.capgemini.librarymanagementsystemcollections.dto.UserBeans;


public class LibraryDB {
	public static final LinkedList<BookBeans> BOOKS = new LinkedList<BookBeans>(); 
	public static final LinkedList<AdminBeans> ADMIN = new LinkedList<AdminBeans>();
	public static final LinkedList<UserBeans> USER = new LinkedList<UserBeans>();
	public static final LinkedList<RequestBeans> REQUEST = new LinkedList<RequestBeans>();

	public static void addToDB() {

		ADMIN.add(new AdminBeans(123456,"Vyshnavi","Vyshnavi@199","Vyshnavi@gmail.com",7659939065l));

		
		BOOKS.add(new BookBeans(101010,"java","james","gosling","coding"));
		BOOKS.add(new BookBeans(101011,"history","tom","henry feild","world"));
		BOOKS.add(new BookBeans(101012,"angular","misko","adam","js"));
		BOOKS.add(new BookBeans(101013,"computers","charles","aborns","programing"));

	}


}