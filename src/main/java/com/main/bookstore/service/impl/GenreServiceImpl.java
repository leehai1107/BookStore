package com.main.bookstore.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.bookstore.converter.GenreConverter;
import com.main.bookstore.entity.Genre;
import com.main.bookstore.model.GenreModel;
import com.main.bookstore.repository.GenreRepository;
import com.main.bookstore.service.IGenreService;

@Service
public class GenreServiceImpl implements IGenreService{
	@Autowired
	GenreRepository genreRepository;
	
	@Autowired
	GenreConverter genreConverter;

	@Override
	public <S extends GenreModel> S save(S model) {
		genreRepository.save(genreConverter.toEntity(model));
		return model;
	}

	@Override
	public List<GenreModel> findAll() {
	    List<Genre> entities = genreRepository.findAll();
	    return entities.stream()
	            .map(genreConverter::toModel)
	            .collect(Collectors.toList());
	}
	
}
