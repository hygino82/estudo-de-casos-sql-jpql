package com.devsuperior.uri2621;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.projections.ProductMinProjection;
import com.devsuperior.uri2621.repositories.ProductRepository;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Resultado usando SQL Raiz");
		List<ProductMinProjection> list = repository.buscaPorQuantidadeLetraInicial(10, 20, "P");
		List<ProductMinDTO> res = list.stream().map(x -> new ProductMinDTO(x)).collect(Collectors.toList());
		res.forEach(x -> System.out.println(x));

		System.out.println("\n----------------------------------------------------\n");
		System.out.println("Resultado usando JPQL");
		List<ProductMinDTO> res1 = repository.jpqlBuscaPorQuantidadeLetraInicial(10, 20, "P");
		res1.forEach(x -> System.out.println(x));

	}
}
