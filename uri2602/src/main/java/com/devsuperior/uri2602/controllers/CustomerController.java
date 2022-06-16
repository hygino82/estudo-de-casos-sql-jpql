package com.devsuperior.uri2602.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.uri2602.dto.CustomerDTO;
import com.devsuperior.uri2602.dto.CustomerMinDTO;
import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService service;

	@GetMapping
	public List<Customer> buscarTodos() {
		return service.buscarTodos();
	}

	@GetMapping("/nome")
	public List<CustomerMinDTO> buscarPeloNome(@PathParam("state") String state) {
		return service.buscarPeloNome(state);
	}
	
	@GetMapping("/estado")
	public List<CustomerDTO> buscarPeloEstado(@PathParam("state") String state) {
		return service.buscarPeloEstado(state);
	}
}
