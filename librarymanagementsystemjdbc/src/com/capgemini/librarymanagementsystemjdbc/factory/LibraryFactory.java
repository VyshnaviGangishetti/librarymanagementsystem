package com.capgemini.librarymanagementsystemjdbc.factory;

import com.capgemini.librarymanagementsystemjdbc.dao.UserDAO;
import com.capgemini.librarymanagementsystemjdbc.dao.UserDAOImplement;
import com.capgemini.librarymanagementsystemjdbc.service.UserService;
import com.capgemini.librarymanagementsystemjdbc.service.UserServiceImplement;
	
	public class LibraryFactory {
		public static UserDAO getUsersDao() {
			return new UserDAOImplement();
		}
		public static UserService getUsersService() {
			return new UserServiceImplement();
		}
	}