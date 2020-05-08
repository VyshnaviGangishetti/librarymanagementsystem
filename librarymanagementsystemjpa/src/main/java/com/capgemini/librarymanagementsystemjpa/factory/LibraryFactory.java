package com.capgemini.librarymanagementsystemjpa.factory;

import com.capgemini.librarymanagementsystemjpa.dao.UserDAO;
import com.capgemini.librarymanagementsystemjpa.dao.UserDAOImplementation;
import com.capgemini.librarymanagementsystemjpa.service.UserService;
import com.capgemini.librarymanagementsystemjpa.service.UserServiceImplement;
	
	public class LibraryFactory {
		public static UserDAO getUsersDao() {
			return new UserDAOImplementation();
		}
		public static UserService getUsersService() {
			return new UserServiceImplement();
		}
	}