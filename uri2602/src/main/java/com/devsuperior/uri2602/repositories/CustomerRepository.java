package com.devsuperior.uri2602.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustomerMinProjection;
import com.devsuperior.uri2602.projections.CustomerProjection;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM customers")
	List<Customer> buscarTodos();

	@Query(nativeQuery = true, value = "SELECT name " + "FROM customers " + "WHERE state= :state")
	List<CustomerMinProjection> buscarApenasNome(String state);

	@Query(nativeQuery = true, value = "SELECT * FROM customers WHERE state= :state")
	List<CustomerProjection> buscarPeloEstado(String state);


}
