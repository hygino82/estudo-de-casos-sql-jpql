package com.devsuperior.uri2990;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import com.devsuperior.uri2990.repositories.EmpregadoRepository;

@SpringBootApplication
public class Uri2990Application implements CommandLineRunner {

	@Autowired
	private EmpregadoRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2990Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Resultado usando SQL Raiz NOT IN");
		List<EmpregadoDeptProjection> list = repository.buscaEmpregadosSemProjetos();
		List<EmpregadoDeptDTO> res = list.stream().map(x -> new EmpregadoDeptDTO(x)).collect(Collectors.toList());
		res.forEach(x -> System.out.println(x));
		
		System.out.println("\n-------------------------------------------\n");
		
		System.out.println("Resultado usando JPQL");
		List<EmpregadoDeptDTO> res1 = repository.jpqlBuscaEmpregadosSemProjetos();
		res1.forEach(x -> System.out.println(x));
		
		System.out.println("\n-------------------------------------------\n");
		System.out.println("Resultado usando SQL Raiz LEFT JOIN");
		List<EmpregadoDeptProjection> list2 = repository.buscaEmpregadosSemProjetosV2LeftJoin();
		List<EmpregadoDeptDTO> res2 = list2.stream().map(x -> new EmpregadoDeptDTO(x)).collect(Collectors.toList());
		res2.forEach(x -> System.out.println(x));
	}
}
