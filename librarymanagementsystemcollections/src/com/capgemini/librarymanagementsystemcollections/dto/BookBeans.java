package com.capgemini.librarymanagementsystemcollections.dto;

import java.io.Serializable;


@SuppressWarnings("serial")
public class BookBeans implements Serializable{
	private int id = (int)Math.random();
	private String bookName;
	private String author;
	private String publication;
	private String category;
	
	public BookBeans() {
		// TODO Auto-generated constructor stub
	}
	
	public BookBeans(int id,String bookName,String author,
			String publication,String category) {
		this.id=id;
		this.bookName=bookName;
		this.author=author;
		this.publication=publication;
		this.category=category;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


}//End of class
