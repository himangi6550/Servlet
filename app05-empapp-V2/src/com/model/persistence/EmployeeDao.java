package com.model.persistence;

import java.util.*;

import com.model.exceptions.DataAccessException;

public interface EmployeeDao {
	
	public Employee addEmployee(Employee employee);
	public Employee deleteEmployee(int id);
	public Employee updateEmployee(int id , Employee employee);
	public List<Employee> getAll()throws DataAccessException;
	public Optional<Employee> getById(int id);
	

}
