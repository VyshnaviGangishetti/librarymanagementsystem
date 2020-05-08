package com.capgemini.librarymanagementsystemspringmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagementsystemspringmvc.dto.BookBeans;
import com.capgemini.librarymanagementsystemspringmvc.dto.BorrowBook;
import com.capgemini.librarymanagementsystemspringmvc.dto.LibraryBean;
import com.capgemini.librarymanagementsystemspringmvc.dto.UserBeans;
import com.capgemini.librarymanagementsystemspringmvc.service.UserService;

@RestController
public class Library {
	
		@Autowired
		private UserService sevice;

		@PostMapping(path = "/addUser", consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
						MediaType.APPLICATION_ATOM_XML_VALUE })
		@ResponseBody
		public LibraryBean addUser(@RequestBody UserBeans userBean) {
			boolean isAdded = sevice.register(userBean);
			LibraryBean responce = new LibraryBean();
			if (isAdded) {

				responce.setMessage("User is added");
			} else {
				responce.setError(true);
				responce.setMessage("Unable to Add User");
			}
			return responce;
		}

		@PostMapping(path = "/addBook", 
				consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
				produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE })
		@ResponseBody
		public LibraryBean addBook(@RequestBody BookBeans bookBean) {
			boolean isAdded = sevice.addBook(bookBean);
			LibraryBean responce = new LibraryBean();
			if (isAdded) {

				responce.setMessage("Book is added");
			} else {
				responce.setError(true);
				responce.setMessage("Unable to Add Book");
			}
			return responce;
		}
		
		@DeleteMapping(path = "/deleteBook/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public LibraryBean deleteEmployee(@PathVariable(name = "id") int id) {
			boolean isDeleted = sevice.removeBook(id);
			LibraryBean response = new LibraryBean();
			if (isDeleted) {
				response.setMessage("Record is  Deleted");
			} else {
				response.setError(true);
				response.setMessage("Record is not Deleted");
			}
			return response;
		}
		
		@PutMapping(path = "/updateBook", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public LibraryBean updateBook(BookBeans bookBean) {
			boolean isUpdated = sevice.updateBook(bookBean);
			LibraryBean response = new LibraryBean();
			if (isUpdated) {
				response.setMessage("Book is  Updated");
			} else {
				response.setError(true);
				response.setMessage("Record is not Updated");
			}
			return response;
		}
		
		@GetMapping(path = "/getAllBooks", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public LibraryBean getAllBooks() {
			List<BookBeans> bookList = sevice.getBooksInfo();
			LibraryBean response = new LibraryBean();
			if (bookList != null && bookList.isEmpty() ) {
				response.setBookList(bookList); 
			} else {
				response.setError(true);
				response.setMessage("No data present");
			}
			return response;
		}
		
		@GetMapping(path="/getBookByName", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public List<BookBeans> getBookByName(String bookName) {
			List<BookBeans> bookBean = sevice.searchBookByTitle(bookName);
			return bookBean;
		}
		
		@GetMapping(path="/getBookById", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public List<BookBeans> getBook(int id) {
			List<BookBeans> bookBean = sevice.searchBookById(id);
			return bookBean;
		}
		
		@GetMapping(path="/getBookByAuthor", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public List<BookBeans> getBook(String author) {
			List<BookBeans> bookBean = sevice.searchBookByAuthor(author);
			return bookBean;
		}
		
		
		@GetMapping(path = "/borrowedBooks", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public LibraryBean borrowedBoooks(int uId) {
			List<BorrowBook> borrowedBooksList = sevice.borrowedBook(uId);
			LibraryBean response = new LibraryBean();
			if (borrowedBooksList != null && borrowedBooksList.isEmpty() ) {
				response.setBorrowedBooksList(borrowedBooksList); 
			} else {
				response.setError(true);
				response.setMessage("No data present");
			}
			return response;
		}
		
		@GetMapping(path = "/getBookIssueDetails", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public List<Integer> getBookIssueDetails(int uId) {
			List<Integer> booksHistory = sevice.bookHistoryDetails(uId);
			return booksHistory;

		}
		@PostMapping(path = "/requestBook", 
				consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
				produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE })
		@ResponseBody
		public LibraryBean requestBook(int bId, int uId) {
			boolean isRequested = sevice.request(uId, bId);
			LibraryBean response = new LibraryBean();
			if (isRequested) {
				response.setMessage("Book is  Requested");
			} else {
				response.setError(true);
				response.setMessage("Book is not Requested");
			}
			return response;
		}
		
		@PostMapping(path = "/issueBook", 
				consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
				produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE })
		@ResponseBody
		public LibraryBean issueBook(int bId, int uId) {
			boolean isIssued = sevice.issueBook(bId, uId);
			LibraryBean response = new LibraryBean();
			if (isIssued) {
				response.setMessage("Book is  Issued");
			} else {
				response.setError(true);
				response.setMessage("Book is not issued");
			}
			return response;
		}
		

		@PostMapping(path = "/returnBook", 
				consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE },
				produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE })
		@ResponseBody
		public LibraryBean returnBook(int bId, int uId,String status) {
			boolean isReturned = sevice.returnBook(bId, uId);
			LibraryBean response = new LibraryBean();
			if (isReturned) {
				response.setMessage("Book is  Returned");
			} else {
				response.setError(true);
				response.setMessage("Book is not Returned");
			}
			return response;
		}
	
	}
