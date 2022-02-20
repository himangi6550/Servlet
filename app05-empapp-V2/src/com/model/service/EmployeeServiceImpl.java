package com.model.service;

import java.util.List;
import java.util.Optional;

import com.model.exceptions.DataAccessException;
import com.model.persistence.*;

public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDao employeeDao;

	public EmployeeServiceImpl() {
		employeeDao=new EmployeeDaoImpl();
	}
	
	@Override
	public Employee addEmployee(Employee employee) {
		///u can write extra logic here
		return employeeDao.addEmployee(employee);
	}

	@Override
	public Employee deleteEmployee(int id) {
		return employeeDao.deleteEmployee(id);
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {
		return employeeDao.updateEmployee(id, employee);
	}

	@Override
	public List<Employee> getAll() throws DataAccessException{
		return employeeDao.getAll();
	}

	@Override
	public Optional<Employee> getById(int id) {
		return employeeDao.getById(id);
	}

}
