package com.devsuperior.uri2621.dto;

import com.devsuperior.uri2621.entities.Product;
import com.devsuperior.uri2621.entities.Provider;

public class ProductDTO {

	private Long id;
	private String name;
	private Integer amount;
	private Double price;
	private Provider provider;

	public ProductDTO() {
	}

	public ProductDTO(Long id, String name, Integer amount, Double price, Provider provider) {
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.price = price;
		this.provider = provider;
	}

	public ProductDTO(Product entity) {
		id = entity.getId();
		name = entity.getName();
		amount = entity.getAmount();
		price = entity.getPrice();
		provider = entity.getProvider();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", amount=" + amount + ", price=" + price + ", provider="
				+ provider + "]";
	}
}
