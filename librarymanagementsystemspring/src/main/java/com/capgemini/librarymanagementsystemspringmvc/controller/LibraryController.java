package com.capgemini.librarymanagementsystemspringmvc.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.librarymanagementsystemspringmvc.dto.LibraryBean;
import com.capgemini.librarymanagementsystemspringmvc.exception.LMSException;
@RestControllerAdvice
public class LibraryController extends Thread {
	@ExceptionHandler
	public LibraryBean myExceptionHandler(LMSException lmsException) {
		LibraryBean response = new LibraryBean();
		response.setError(true);
		response.setMessage(lmsException.getMessage());
		return response;
	}

	}
