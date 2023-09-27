package com.main.bookstore.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.bookstore.model.GenreModel;
import com.main.bookstore.service.IGenreService;

@RestController
public class GenreAPI {
	@Autowired
	IGenreService genreService;

	@GetMapping("/genres")
	public List<GenreModel> findAll() {
		return genreService.findAll();
	}
	
	@PostMapping("/addgenre")
	public <S extends GenreModel> S save(@RequestBody S model) {
		return genreService.save(model);
	}
	
	
}
