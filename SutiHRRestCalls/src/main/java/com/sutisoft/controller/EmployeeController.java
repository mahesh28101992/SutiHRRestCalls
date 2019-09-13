/**
 * 
 */
package com.sutisoft.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sutisoft.model.Employee;
import com.sutisoft.service.EmployeeService;

/**
 * @author maheshk
 *
 */
@RestController
public class EmployeeController {

	Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
	public String welcome() {
		return "Welocme to SutiHR Application";
	}

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		log.info("********** Enter Into getAllEmployees() in EmployeeController class *********");
		List<Employee> employeeList = new ArrayList<Employee>();

		try {
			employeeList = employeeService.getAllEmployees();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("********** Error in getAllEmployees() in EmployeeController class *********");
		}
		log.info("********** Exit Into getAllEmployees() in EmployeeController class *********");
		return employeeList;
	}

	@GetMapping("/getEmployeeById/{empId}")
	public Employee getEmployeeById(@PathVariable(name = "empId") Integer empId) {
		log.info("********** Enter Into getEmployeeById() in EmployeeController class *********");
		Employee employee = new Employee();
		if (empId != null) {
			employee = employeeService.getEmployeeById(empId);
		}
		log.info("********** Exit Into getEmployeeById() in EmployeeController class *********");
		return employee;
	}

	@GetMapping("/getEmployeeDetails")
	public ModelAndView getEmployeeDetails() {
		log.info("********** Enter Into getEmployeeDetails() in EmployeeController class *********");
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			employeeList = employeeService.getAllEmployees();
		} catch (Exception e) {
			if (employeeList == null) {
				e.printStackTrace();
				log.error("********** Error in getEmployeeDetails() in EmployeeController class *********");
			}
		}
		log.info("********** Exit Into getEmployeeDetails() in EmployeeController class *********");
		return new ModelAndView("employeeDetails", "employeeList", employeeList);
	}
}
