package com.capgemini.librarymanagementsystemcollections.factory;

import com.capgemini.librarymanagementsystemcollections.dao.AdminDAO;
import com.capgemini.librarymanagementsystemcollections.dao.AdminDAOImplementation;
import com.capgemini.librarymanagementsystemcollections.dao.UserDAO;
import com.capgemini.librarymanagementsystemcollections.dao.UserDAOImplementation;
import com.capgemini.librarymanagementsystemcollections.service.AdminService;
import com.capgemini.librarymanagementsystemcollections.service.AdminServiceImplementation;
import com.capgemini.librarymanagementsystemcollections.service.UserService;
import com.capgemini.librarymanagementsystemcollections.service.UserServiceImplementation;

public class LibraryFactory {
	public static AdminDAO getAdminDao() {
		return new AdminDAOImplementation();
	}
	public static AdminService getAdminService() {
		return new AdminServiceImplementation();
	}
	public static UserDAO getUserDao() {
		return new UserDAOImplementation();
	}
	public static UserService getUserService() {
		return new UserServiceImplementation();
	}

}//End of class
