package com.model.persistence;

import java.util.List;
import java.util.Optional;

import com.model.exceptions.DataAccessException;

public interface ProductDao {
	
	public Product addProduct(Product product);
	
	public List<Product> getAll()throws DataAccessException;
	public Optional<Product> getById(int id);

}
