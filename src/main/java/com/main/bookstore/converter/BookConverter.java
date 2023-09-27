package com.main.bookstore.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.main.bookstore.entity.Book;
import com.main.bookstore.entity.Genre;
import com.main.bookstore.model.BookModel;
import com.main.bookstore.repository.GenreRepository;

@Component
public class BookConverter implements Converter<Book, BookModel>{
	@Autowired
	GenreRepository genreRepository;
	
	@Override
	public BookModel toModel(Book entity) {
		BookModel model = new BookModel();
		model.setBookId(entity.getBookId());
		model.setBookTitle(entity.getBookTitle());
		model.setDescription(entity.getDescription());
		model.setAuthor(entity.getAuthor());
		model.setImageUrl(entity.getImageUrl());
		model.setPrice(entity.getPrice());
		model.setPublishDate(entity.getPublishDate());
		model.setPublisher(entity.getPublisher());
		model.setRating(entity.getRating());
		model.setStatus(entity.isStatus());
		model.setPageCount(entity.getPageCount());
		List<Integer> genreIds = entity.getGenres().stream()
	            .map(genre -> genre.getGenreId())
	            .collect(Collectors.toList());
		model.setGenreIds(genreIds);
		List<String> genreNames = entity.getGenres().stream()
	            .map(genre -> genre.getGenreName())
	            .collect(Collectors.toList());
		model.setGenreNames(genreNames);
		return model;
	}

	@Override
	public Book toEntity(BookModel model) {
		Book entity = new Book();
		entity.setPageCount(model.getPageCount());
		entity.setBookId(model.getBookId());
		entity.setBookTitle(model.getBookTitle());
		entity.setDescription(model.getDescription());
		entity.setAuthor(model.getAuthor());
		entity.setImageUrl(model.getImageUrl());
		entity.setPrice(model.getPrice());
		entity.setPublishDate(model.getPublishDate());
		entity.setPublisher(model.getPublisher());
		entity.setRating(model.getRating());
		entity.setStatus(model.isStatus());
		  List<Genre> genres = model.getGenreIds().stream()
		            .map(genreId -> genreRepository.findById(genreId).orElse(null))
		            .collect(Collectors.toList());
		entity.setGenres(genres);
		return entity;
	}
	
}
