package com.main.bookstore.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.bookstore.converter.BookConverter;
import com.main.bookstore.entity.Book;
import com.main.bookstore.model.BookModel;
import com.main.bookstore.repository.BookRepository;
import com.main.bookstore.service.IBookService;

@Service
public class BookServiceImpl implements IBookService{
	@Autowired 
	BookRepository bookRepository;
	
	@Autowired
	BookConverter bookConverter;
	
	@Override
	public <S extends BookModel> S save(S model) {
		bookRepository.save(bookConverter.toEntity(model));
		return model;
	}
	
	@Override
	public List<BookModel> findAll() {
	    List<Book> entities = bookRepository.findAll();
	    return entities.stream()
	            .map(bookConverter::toModel)
	            .collect(Collectors.toList());
	}
	
	@Override
	public BookModel getBookById(String id) {
		BookModel model = bookConverter.toModel(bookRepository.getReferenceById(id));
		return model;
	}
	
}
