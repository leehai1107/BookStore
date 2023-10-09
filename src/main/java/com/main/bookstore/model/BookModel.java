package com.main.bookstore.model;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookModel {	
	private String bookId;
    private String title;
    private String author;
    private String publisher;
    private Date publishDate;
    private float rating;
    private int price;
    private List<Integer> genreIds;
    private List<String> genreNames;
    private String description;
    private String imageUrl;
    private int pageCount;
    private boolean status;
}
