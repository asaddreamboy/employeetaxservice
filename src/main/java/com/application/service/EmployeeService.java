package com.application.service;

import java.util.List;

import com.application.model.Employee;
import com.application.model.EmployeeDetails;

public interface EmployeeService {
	
	 void storeEmployeeDetails(List<Employee> employee);
	 List<EmployeeDetails> calculateTaxDeduction();

}
