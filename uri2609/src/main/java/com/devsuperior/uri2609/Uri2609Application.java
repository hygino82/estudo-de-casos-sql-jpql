package com.devsuperior.uri2609;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import com.devsuperior.uri2609.repositories.CategoryRepository;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2609Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<CategorySumProjection> list = repository.buscarPorCategoriaSoma();
		List<CategorySumDTO> res = list.stream().map(x -> new CategorySumDTO(x)).collect(Collectors.toList());
		System.out.println("Resultado usando SQL Raiz");
		res.forEach(x -> System.out.println(x));

		System.out.println("\n----------------------------------------------------\n");
		System.out.println("Resultado usando JPQL");
		List<CategorySumDTO> res1 = repository.jpqlBuscarPorCategoriaSoma();
		res1.forEach(x -> System.out.println(x));
	}
}
