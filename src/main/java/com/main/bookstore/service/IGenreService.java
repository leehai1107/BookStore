package com.main.bookstore.service;

import java.util.List;

import com.main.bookstore.model.GenreModel;

public interface IGenreService {

	List<GenreModel> findAll();

	<S extends GenreModel> S save(S model);

}
