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


public class EmployeeDaoImpl implements EmployeeDao{
	
	private Connection connection;
	
	 public EmployeeDaoImpl() {
		connection=ConnectionFactory.getConnection();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		try {
			PreparedStatement pstmt=connection.prepareStatement ("insert into emp(ename, city, desi, salary) values(?,?,?,?)",
							Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, employee.getEname());
			pstmt.setString(2, employee.getCity());
			pstmt.setString(3, employee.getDesi());
			pstmt.setDouble(4, employee.getSalary());
			
			pstmt.executeUpdate();
			
			ResultSet rs=pstmt.getGeneratedKeys();
			
			if(rs.next()) {
				employee.setId(rs.getInt(1));
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return employee;
	}

	@Override
	public Employee deleteEmployee(int id) {
		try {
			PreparedStatement pstmt=connection.prepareStatement
					("delete from emp where id=?");
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {
		try {
			PreparedStatement pstmt=connection.prepareStatement
					("update emp set salary=? where id=?");
			
			pstmt.setDouble(1, employee.getSalary());
			pstmt.setInt(2, employee.getId());
			
			pstmt.executeUpdate();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> getAll() throws DataAccessException {
		System.out.println("getting all records using jdbc");
		//we will read all the rec from db and put into a arrayList and return to the user
		List<Employee> employees=new ArrayList<Employee>();
		try {
			Employee tempEmployee=null;
			
			PreparedStatement pstmt=connection.prepareStatement("select * from emp");
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				tempEmployee=new Employee(rs.getInt(1),
						rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
				employees.add(tempEmployee);
			}
			
		}catch(SQLException ex) {
			throw new DataAccessException(ex);
		}
		
		return employees;
	}

	@Override
	public Optional<Employee> getById(int id) {
		Employee tempEmployee=null;
		try {
			PreparedStatement pstmt=connection.prepareStatement("select * from emp where id=?");
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				tempEmployee=new Employee(rs.getInt(1),
						rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return Optional.ofNullable(tempEmployee);
	}
	

}
