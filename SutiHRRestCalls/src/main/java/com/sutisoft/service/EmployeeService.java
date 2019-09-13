package com.sutisoft.service;

import java.util.List;

import com.sutisoft.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	Employee getEmployeeById(Integer empId);
}
