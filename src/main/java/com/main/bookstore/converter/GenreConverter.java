package com.main.bookstore.converter;

import org.springframework.stereotype.Component;

import com.main.bookstore.entity.Genre;
import com.main.bookstore.model.GenreModel;

@Component
public class GenreConverter implements Converter<Genre, GenreModel>{

	@Override
	public GenreModel toModel(Genre entity) {
		GenreModel model = new  GenreModel();
		model.setGenreId(entity.getGenreId());
		model.setGenreName(entity.getGenreName());
		return model;
	}

	@Override
	public Genre toEntity(GenreModel model) {
		Genre entity = new Genre();
		entity.setGenreId(model.getGenreId());
		entity.setGenreName(model.getGenreName());
		return entity;
	}

}
