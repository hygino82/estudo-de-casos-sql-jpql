package com.devsuperior.uri2602.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.uri2602.dto.CustomerDTO;
import com.devsuperior.uri2602.dto.CustomerMinDTO;
import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustomerMinProjection;
import com.devsuperior.uri2602.projections.CustomerProjection;
import com.devsuperior.uri2602.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	public List<Customer> buscarTodos() {
		return repository.buscarTodos();
	}

	public List<CustomerMinDTO> buscarPeloNome(String state) {
		List<CustomerMinProjection> list = repository.buscarApenasNome(state);

		return list.stream().map(x -> new CustomerMinDTO(x)).collect(Collectors.toList());
	}

	public List<CustomerDTO> buscarPeloEstado(String state) {
		List<CustomerProjection> list = repository.buscarPeloEstado(state);

		return list.stream().map(x -> new CustomerDTO(x)).collect(Collectors.toList());
	}
}
