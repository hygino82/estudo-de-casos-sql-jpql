package com.devsuperior.uri2621.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService service;

	@GetMapping("/provider")
	public List<ProductMinDTO> buscaPorQuantidadeNome(@PathParam("min") Integer min, @PathParam("max") Integer max,
			@PathParam("name") String name) {
		return service.buscaPorQuantidadeNome(min, max, name);
	}
}
