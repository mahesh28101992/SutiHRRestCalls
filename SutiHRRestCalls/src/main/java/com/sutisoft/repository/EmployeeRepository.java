package com.sutisoft.repository;

import org.springframework.data.repository.CrudRepository;

import com.sutisoft.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
