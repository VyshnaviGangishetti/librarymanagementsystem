package com.capgemini.librarymanagementsystemjdbc.dto;


import com.capgemini.librarymanagementsystemjdbc.dto.BookBeans;

public class BookBeans {
	private int bId;
	private String bookName;
	private String author;
	private String category;
	private String publisher;

	public int getBId() {
		return bId;
	}
	public void setBId(int bId) {
		this.bId = bId;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/*
	 * public int getCopies() { return copies; } public void setCopies(int copies) {
	 * this.copies = copies; }
	 */


}//End of class