package com.devsuperior.uri2611;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.repositories.MovieRepository;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {

	@Autowired
	private MovieRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Resultado usando SQL Raiz");
		var list = repository.encontrarFilmesPeloGenero("action");
		List<MovieMinDTO> res = list.stream().map(x -> new MovieMinDTO(x)).collect(Collectors.toList());

		res.forEach(x -> System.out.println(x));

		System.out.println("\n----------------------------------------------------\n");
		System.out.println("Resultado usando JPQL");

		var list1 = repository.jpqlEncontrarFilmesPeloGenero("action");
		list1.forEach(x -> System.out.println(x));
	}
}
