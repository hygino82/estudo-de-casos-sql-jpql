package com.devsuperior.uri2602;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2602.dto.CustomerMinDTO;
import com.devsuperior.uri2602.repositories.CustomerRepository;
import com.devsuperior.uri2602.services.CustomerService;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	@Autowired
	private CustomerService service;

	public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\nResultado SQL Raiz");
		var list1 = repository.buscarApenasNome("rs");
		List<CustomerMinDTO> res1 = list1.stream().map(x -> new CustomerMinDTO(x)).collect(Collectors.toList());
		res1.forEach(x -> System.out.println(x));
		
		System.out.println("\n--------------------------------------\n");

		System.out.println("\nResultado JPQL");
		var list = repository.busca02Jpql("rs");

		list.forEach(x -> System.out.println(x));
	}
}
