package com.model.service;

import java.util.List;
import java.util.Optional;

import com.model.exceptions.DataAccessException;
import com.model.exceptions.ProductNotFoundException;
import com.model.persistence.Product;



public interface ProductService {
	public Product addProduct(Product product);
	public List<Product> getAll() throws DataAccessException;
	public Optional<Product> getById(int id) throws ProductNotFoundException;

}
