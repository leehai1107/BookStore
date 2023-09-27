package com.main.bookstore.entity;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Genres")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Genre {
	@Id
	@Column(name="GenreId")
	private int genreId;
	
	@Column(name = "GenreName")
	private String genreName;

	@ManyToMany(mappedBy = "genres")
	private Collection<Book> books;
}
