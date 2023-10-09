package com.main.bookstore.service;

import java.util.List;

import com.main.bookstore.model.BookModel;

public interface IBookService {

	List<BookModel> findAll();


	<S extends BookModel> S save(S entity);


	BookModel getBookById(String id);


	List<BookModel> findAllBooksByName(String bookName);


}
