package com.main.bookstore.entity;

import java.util.Collection;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	@Id
	@Column(name = "BookID")
	private String bookId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "Author")
	private String author;
	
	@Column(name = "Publisher")
	private String publisher;
	 
	@Column(name = "PublishDate")
	private Date publishDate;
	
	@Column(name = "Rating")
	private float rating;
	
	@Column(name = "Price")
	private int price;
		
	@Column(name = "Description")
	private String description;
	
	@Column(name = "ImageUrl")
	private String imageUrl;
	
	@Column(name = "PageCount")
	private int pageCount;
	
	@Column(name = "Status")
	private boolean status;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Book_Genre",
	joinColumns = @JoinColumn(name="BookId"),
	inverseJoinColumns = @JoinColumn(name="GenreId"))
	private Collection<Genre> genres;
	
	
}
