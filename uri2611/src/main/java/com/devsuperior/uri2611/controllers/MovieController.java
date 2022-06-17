package com.devsuperior.uri2611.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService service;

	@GetMapping("/genre")
	public ResponseEntity<List<MovieMinDTO>> encontrarFilmesPorGenero(@PathParam("genre") String genre) {
		List<MovieMinDTO> list = service.encontrarFilmesPorGenero(genre);

		return ResponseEntity.ok().body(list);
	}
}
