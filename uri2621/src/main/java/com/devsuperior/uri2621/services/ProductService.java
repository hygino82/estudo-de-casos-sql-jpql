package com.devsuperior.uri2621.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public List<ProductMinDTO> buscaPorQuantidadeNome(Integer min, Integer max, String beginName) {
		return repository.jpqlBuscaPorQuantidadeLetraInicial(min, max, beginName);
	}
}
