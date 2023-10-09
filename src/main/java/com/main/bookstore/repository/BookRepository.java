package com.main.bookstore.repository;

import java.util.List;

import com.main.bookstore.entity.Book;

public interface BookRepository extends GenericRepository<Book, String>{
	List<Book> findByTitleContainingIgnoreCase(String bookName);
}
