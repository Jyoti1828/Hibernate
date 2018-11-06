package com.example.tablePerSubclass;

import javax.persistence.Entity;

@Entity(name="book3")
public class Book extends Product {

	private String publisher;
	private String author;
	
	

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int pid, String pname, int price, String publisher,
			String author) {
		super(pid, pname, price);
		this.publisher = publisher;
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [publisher=" + publisher + ", author=" + author + "]";
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
}
