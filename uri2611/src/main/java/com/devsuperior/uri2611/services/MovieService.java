package com.devsuperior.uri2611.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;

	public List<MovieMinDTO> encontrarFilmesPorGenero(String genre) {
		List<MovieMinProjection> list = repository.encontrarFilmesPeloGenero(genre);
		List<MovieMinDTO> res = list.stream().map(x -> new MovieMinDTO(x)).collect(Collectors.toList());

		return res;
	}
}
