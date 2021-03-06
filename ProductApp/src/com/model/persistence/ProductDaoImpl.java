package com.model.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.model.exceptions.DataAccessException;
import com.model.exceptions.ProductNotFoundException;



public class ProductDaoImpl implements ProductDao {
	
	private Connection connection;
	
	public ProductDaoImpl() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public Product addProduct(Product product) {
		try {
			PreparedStatement insertData = connection
					.prepareStatement("insert into product(" + "name,price, qty, manfDate, inspectedDate) values (?,?,?,?,?)",
							Statement.RETURN_GENERATED_KEYS);
			insertData.setString(1, product.getName());
			insertData.setDouble(2, product.getPrice());
			insertData.setInt(3, product.getQty());
			insertData.setDate(3, product.getManfDate());
			insertData.setDate(3, product.getInspectedDate());
			insertData.executeUpdate();
			
			ResultSet rs = insertData.getGeneratedKeys();
			
			if(rs.next()) {
				product.setId(rs.getInt(1));
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return product;
	}

	@Override
	public List<Product> getAll() throws DataAccessException {
		List<Product> products = new ArrayList<>();
		try {
			Product product = null;
			PreparedStatement statement = connection.prepareStatement("select * from product");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				product = new Product(result.getInt(1), result.getString(2), result.getDouble(3), result.getInt(4), result.getDate(5), result.getDate(6));
				products.add(product);
			}
		}catch(SQLException e) {
			throw new DataAccessException(e);
		}
		return products;
	}

	@Override
	public Optional<Product> getById(int id) {
		Product product = null;
		try {
			PreparedStatement statement = connection.prepareStatement("select * from product where id=?");
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				product = new Product(result.getInt(1), result.getString(2), result.getDouble(3), result.getInt(4), result.getDate(5), result.getDate(6));
			}else {
				throw new ProductNotFoundException("product with id= "+id+" is not found");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return Optional.ofNullable(product);
	}

	

}
