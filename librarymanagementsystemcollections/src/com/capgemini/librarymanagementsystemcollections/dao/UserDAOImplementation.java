package com.capgemini.librarymanagementsystemcollections.dao;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagementsystemcollections.db.LibraryDB;
import com.capgemini.librarymanagementsystemcollections.dto.BookBeans;
import com.capgemini.librarymanagementsystemcollections.dto.RequestBeans;
import com.capgemini.librarymanagementsystemcollections.dto.UserBeans;
import com.capgemini.librarymanagementsystemcollections.exception.LMSException;



public class UserDAOImplementation implements UserDAO {

	@Override
	public boolean registerUser(UserBeans user) {
		for(UserBeans u : LibraryDB.USER) {
			if(u.getEmail().equals(user.getEmail())) {
				return false;
			}
		}
		LibraryDB.USER.add(user);
		return true;
	}

	@Override
	public UserBeans loginUser(String email, String password){
		for(UserBeans user : LibraryDB.USER) {
			if(user.getEmail().equals(email) ) {
				if(user.getPassword().equals(password)) {
					return user;
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
	public List<BookBeans> searchBookByTitle(String bookName) {
		List<BookBeans> searchList=new LinkedList<BookBeans>();
		for(int i=0;i<=LibraryDB.BOOKS.size()-1;i++)
		{
			BookBeans retrievedBook=LibraryDB.BOOKS.get(i);
			String retrievedBookName=retrievedBook.getBookName();
			if(bookName.equals(retrievedBookName))
			{
				searchList.add(retrievedBook);	
				return searchList;
			}
		}
		if(searchList.size()==0)
		{
			throw new LMSException ("Book is not found");
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
			throw new LMSException ("Book is not found");
		}
		else
		{
			return searchList;
		}	
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
	public List<BookBeans> getBooksInfo() {
		return LibraryDB.BOOKS;
	}

	@Override
	public RequestBeans bookRequest(UserBeans user, BookBeans book) {
		boolean flag = false; 
		boolean	isRequestExists = false;
		RequestBeans requestInfo = new RequestBeans();
		UserBeans userInfo2 = new UserBeans();
		BookBeans bookInfo2 = new BookBeans();

		for (RequestBeans requestInfo2 : LibraryDB.REQUEST) {
			if (book.getId() == requestInfo2.getBookInfo().getId()) {
				isRequestExists = true;

			}
		}

		if (!isRequestExists) {
			for (UserBeans userBean : LibraryDB.USER) {
				if (user.getId() == userBean.getId()) {
					for (BookBeans book1 : LibraryDB.BOOKS) {
						if (book1.getId() == book1.getId()) {
							userInfo2 = userBean;
							bookInfo2 = book1;
							flag = true;
						}
					}
				}
			}
			if (flag == true) {
				requestInfo.setBookInfo(bookInfo2);
				requestInfo.setUserInfo(userInfo2);;
				LibraryDB.REQUEST.add(requestInfo);
				return requestInfo;
			}

		}

		throw new LMSException("Invalid request or you cannot request that book");

	}

	@Override
	public RequestBeans bookReturn(UserBeans user, BookBeans book) {
		for (RequestBeans requestInfo : LibraryDB.REQUEST) {

			if (requestInfo.getBookInfo().getId() == book.getId() &&
					requestInfo.getUserInfo().getId() == user.getId() &&
					requestInfo.isIssued() == true) {


				System.out.println("Returning Issued book only");
				requestInfo.setReturned(true);


				return requestInfo;
			}

		}

		throw new  LMSException("Invalid return ");
	}

	
}//End of class