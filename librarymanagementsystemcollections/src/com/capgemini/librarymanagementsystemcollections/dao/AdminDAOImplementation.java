package com.capgemini.librarymanagementsystemcollections.dao;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystemcollections.db.LibraryDB;
import com.capgemini.librarymanagementsystemcollections.dto.AdminBeans;
import com.capgemini.librarymanagementsystemcollections.dto.BookBeans;
import com.capgemini.librarymanagementsystemcollections.dto.RequestBeans;
import com.capgemini.librarymanagementsystemcollections.dto.UserBeans;
import com.capgemini.librarymanagementsystemcollections.exception.LMSException;

public class AdminDAOImplementation implements AdminDAO{
	@Override
	public boolean registerAdmin(AdminBeans admin) {
		for(AdminBeans ad : LibraryDB.ADMIN) {
			if(ad.getEmail().equals(admin.getEmail())) {
				return false;
			}
		}
		LibraryDB.ADMIN.add(admin);
		return true;
	}

	@Override
	public AdminBeans loginAdmin(String email, String password) {
		for(AdminBeans admin : LibraryDB.ADMIN) {
			if(admin.getEmail().equals(email) ) {
				if(admin.getPassword().equals(password)) {
					return admin;
				}else {
					throw new LMSException("Password is invalid");
				}

			}else {
				throw new LMSException("Email doesn't Exist");
			}
		}
		throw new LMSException("Invalid credentials");

	}

	@Override
	public boolean addBook(BookBeans book) {
		for(BookBeans b : LibraryDB.BOOKS) {
			if(b.getId()==book.getId()) {
				return false;
			}
		}
		LibraryDB.BOOKS.add(book);
		return true;
	}

	@Override
	public boolean removeBook(int id) {
		boolean removeStatus=false;
		for(int i=0;i<=LibraryDB.BOOKS.size()-1;i++)
		{
			BookBeans retrievedBook=LibraryDB.BOOKS.get(i);
			int retrievedId=retrievedBook.getId();
			if(id==retrievedId)
			{
				removeStatus=true;
				LibraryDB.BOOKS.remove(i);
				break;
			}
		}
		return removeStatus;
	}


	@Override
	public List<BookBeans> searchBookByTitle(String bookName) {
		List<BookBeans> searchList=new LinkedList<BookBeans>();
		for(int i=0;i<=LibraryDB.BOOKS.size()-1;i++)
		{
			BookBeans retrievedBook=LibraryDB.BOOKS.get(i);
			String retrievedBookName=retrievedBook.getBookName();
			if(bookName.equals(retrievedBookName))
			{
				searchList.add(retrievedBook);	
				//return searchList;
			}
		}
		if(searchList.size()==0)
		{
			throw new LMSException("Book not found");
		}
		else
		{
			return searchList;
		}

	}

	@Override
	public List<BookBeans> searchBookByAuthor(String author) {
		List<BookBeans> searchList=new LinkedList<BookBeans>();
		for(int i=0;i<=LibraryDB.BOOKS.size()-1;i++)
		{
			BookBeans retrievedBook=LibraryDB.BOOKS.get(i);
			String retrievedBookAuthor=retrievedBook.getAuthor();
			if(author.equals(retrievedBookAuthor))
			{
				searchList.add(retrievedBook);	
			}
		}
		if(searchList.size()==0)
		{
			throw new LMSException("Book not found");
		}
		else
		{
			return searchList;
		}		

	}

	@Override
	public List<BookBeans> getBooksInfo() {
		return LibraryDB.BOOKS;
	}

	@Override
	public List<BookBeans> searchBookByCategory(String category) {
		List<BookBeans> searchList=new LinkedList<BookBeans>();
		for(int i=0;i<=LibraryDB.BOOKS.size()-1;i++)
		{
			BookBeans retrievedBook=LibraryDB.BOOKS.get(i);
			String retrievedCategory=retrievedBook.getCategory();
			if(category.equals(retrievedCategory))
			{
				searchList.add(retrievedBook);	
			}
		}
		if(searchList.size()==0)
		{
			throw new LMSException("Book not found");
		}
		else
		{
			return searchList;
		}	
	}

	@Override
	public List<UserBeans> showUsers() {
		List<UserBeans> usersList = new LinkedList<UserBeans>();
		for (UserBeans userBean : LibraryDB.USER) {

			userBean.getId();
			userBean.getName();
			userBean.getEmail();
			userBean.getBooksBorrowed();
			usersList.add(userBean);

		}
		return usersList;
	}

	@Override
	public List<RequestBeans> showRequests() {
		List<RequestBeans> info = new LinkedList<RequestBeans>();
		for (RequestBeans requestInfo : LibraryDB.REQUEST) {
			requestInfo.getBookInfo();
			requestInfo.getUserInfo();
			requestInfo.isIssued();
			requestInfo.isReturned();
			info.add(requestInfo);
		}
		return info;
	}

	@Override
	public boolean bookIssue(UserBeans user, BookBeans book) {
		boolean isValid = false;

		RequestBeans requestInfo = new RequestBeans();

		int noOfBooksBorrowed = user.getBooksBorrowed();
		for (RequestBeans info : LibraryDB.REQUEST) {
			if (info.getUserInfo().getId() == user.getId()) {
				if (info.getBookInfo().getId() == book.getId()) {
					requestInfo = info;

					isValid = true;

				}
			}
		}

		if (isValid)
		{
			for (BookBeans info2 : LibraryDB.BOOKS) {
				if (info2.getId() == book.getId()) {
					book = info2;
				}
			}

			for (UserBeans userInfo : LibraryDB.USER) {
				if (userInfo.getId() == user.getId()) {
					user = userInfo;
					noOfBooksBorrowed = user.getBooksBorrowed();

				}
			}

			if (noOfBooksBorrowed < 3) {

				boolean isRemoved = LibraryDB.BOOKS.remove(book);
				if (isRemoved) {

					noOfBooksBorrowed++;
					System.out.println(noOfBooksBorrowed);
					user.setBooksBorrowed(noOfBooksBorrowed);
					// DataBase.REQUESTDB.remove(requestInfo);
					requestInfo.setIssued(true);
					return true;
				} else {
					throw new LMSException("Book can't be borrowed");
				}

			} else {
				throw new LMSException("Student Exceeds maximum limit");
			}

		} else {
			throw new LMSException("Book data or Student data is incorrect");
		}
	}

	@Override
	public boolean isBookReceived(UserBeans user, BookBeans book) {
		boolean isValid = false;
		RequestBeans requestInfo1 = new RequestBeans();
		for (RequestBeans requestInfo : LibraryDB.REQUEST) {

			if (requestInfo.getBookInfo().getId() == book.getId()
					&& requestInfo.getUserInfo().getId() == user.getId() 
					&& requestInfo.isReturned() == true) {
				isValid = true;
				requestInfo1 = requestInfo;
			}
		}
		if (isValid) {

			book.setAuthor(requestInfo1.getBookInfo().getAuthor());
			book.setBookName(requestInfo1.getBookInfo().getBookName());
			LibraryDB.BOOKS.add(book);
			LibraryDB.REQUEST.remove(requestInfo1);


			for (UserBeans userInfo2 : LibraryDB.USER) {
				if (userInfo2.getId() == user.getId()) {
					user = userInfo2;
				}
			}
			int noOfBooksBorrowed = user.getBooksBorrowed();
			noOfBooksBorrowed--;
			user.setBooksBorrowed(noOfBooksBorrowed);
			return true;
		}
		return false;
	}


}//End of class


