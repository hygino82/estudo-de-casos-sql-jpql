package com.devsuperior.uri2602;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2602.dto.CustomerDTO;
import com.devsuperior.uri2602.services.CustomerService;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner {

//	@Autowired
//	private CustomerRepository repository;

	@Autowired
	private CustomerService service;

	public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		List<CustomerMinProjection> list = repository.buscarApenasNome("RS");
//		System.out.println("Lista de pessoas");
//
//		list.forEach(x -> System.out.println(x.getName()));

		List<CustomerDTO> list = service.buscarPeloEstado("RS");
		list.forEach(x -> System.out.println(x));

	}
}
