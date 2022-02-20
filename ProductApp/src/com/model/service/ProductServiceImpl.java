package com.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.model.exceptions.DataAccessException;
import com.model.exceptions.ProductNotFoundException;
import com.model.persistence.Product;
import com.model.persistence.ProductDao;
import com.model.persistence.ProductDaoImpl;



public class ProductServiceImpl implements ProductService{
	
	private ProductDao productDao;
	
	public ProductServiceImpl() {
		productDao=new ProductDaoImpl();
	}

	@Override
	public Product addProduct(Product product) {
		return productDao.addProduct(product);
		 
	}


	@Override
	public List<Product> getAll() throws DataAccessException {
		List<Product> products = new ArrayList<>();
		products = productDao.getAll();
		return products;
		
	}

	@Override
	public Optional<Product> getById(int id) throws ProductNotFoundException {
		Optional<Product> product = productDao.getById(id);
		return product;
	}

	

}
