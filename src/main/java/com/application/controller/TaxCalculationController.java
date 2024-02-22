package com.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.application.exception.FinancialYearCheckException;
import com.application.model.Employee;
import com.application.model.EmployeeDetails;
import com.application.service.EmployeeService;
import com.application.utility.TaxCalculationUtill;

import jakarta.validation.Valid;

@RestController
public class TaxCalculationController {
	 	@Autowired(required=true)
	    private EmployeeService employeeService;
	 	
	 	@GetMapping("/test")
	    public String sayHello() {
	        return "Hello";
	    }

	    @PostMapping("/store")
	    public void storeEmployeeDetails(@Valid @RequestBody List<Employee> employee) {
	    	
	    	  employeeService.storeEmployeeDetails(employee);
	    }		
	    		 
	    
		@GetMapping("/tax-deduction")
	    public @ResponseBody List<EmployeeDetails> calculateTaxDeduction() {
	        return  employeeService.calculateTaxDeduction();
	    }

}
