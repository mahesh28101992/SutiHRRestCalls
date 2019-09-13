package com.sutisoft.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sutisoft.model.Employee;
import com.sutisoft.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList = (List<Employee>) employeeRepository.findAll();
		return employeeList;
	}

	@Override
	public Employee getEmployeeById(Integer empId) {
		Optional<Integer> emp = Optional.ofNullable(empId);
		Employee employee = new Employee();
		if(emp.isPresent()) {
			employee = employeeRepository.findById(empId).get();
		}
		return employee;
	}
}
