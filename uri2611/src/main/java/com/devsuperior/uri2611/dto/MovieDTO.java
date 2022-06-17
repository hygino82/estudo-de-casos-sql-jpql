package com.devsuperior.uri2611.dto;

import com.devsuperior.uri2611.entities.Genre;
import com.devsuperior.uri2611.entities.Movie;

public class MovieDTO {

	private Long id;
	private String name;
	private Genre genre;

	public MovieDTO() {
	}

	public MovieDTO(Long id, String name, Genre genre) {
		this.id = id;
		this.name = name;
		this.genre = genre;
	}

	public MovieDTO(Movie entity) {
		id = entity.getId();
		name = entity.getName();
		genre = entity.getGenre();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "MovieDTO [id=" + id + ", name=" + name + ", genre=" + genre + "]";
	}
}
