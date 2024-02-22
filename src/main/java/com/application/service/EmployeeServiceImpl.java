package com.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.application.model.Employee;
import com.application.model.EmployeeDetails;
import com.application.pojo.EmployeePojo;
import com.application.utility.TaxCalculationUtill;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	List<EmployeePojo> pojoList=new ArrayList<>();
	

	@Override
	public List<EmployeeDetails> calculateTaxDeduction() {
		if(!CollectionUtils.isEmpty(pojoList)) {
			List<EmployeeDetails> empDetailList=new ArrayList<>();
	
			for(EmployeePojo emp: pojoList) {
				EmployeeDetails empDetail=new EmployeeDetails();
		
		
				double yearlySalary = TaxCalculationUtill.calculateYearlySalary(emp);
	            double taxAmount = TaxCalculationUtill.calculateTaxAmount(yearlySalary);
	            double cessAmount = TaxCalculationUtill.calculateCessAmount(yearlySalary);
				
	            empDetail.setEmployeeId(emp.getEmployeeId());
	            empDetail.setFirstName(emp.getFirstName());
	            empDetail.setLastName(emp.getLastName());
	            empDetail.setYearlySalary(yearlySalary);
	            empDetail.setTaxAmount(taxAmount);
	            empDetail.setCessAmount(cessAmount);
	            
	            empDetailList.add(empDetail);
				
			}
			return empDetailList;
		}
		return null;
		
	}

	@Override
	public void storeEmployeeDetails(List<Employee> modelEmp) {
		if(!CollectionUtils.isEmpty(modelEmp)) {
			for(Employee emp: modelEmp) {
				
				EmployeePojo pojoEmp=new EmployeePojo();
				pojoEmp.setEmployeeId(emp.getEmployeeId());
				pojoEmp.setFirstName(emp.getFirstName());
				pojoEmp.setLastName(emp.getLastName());
				pojoEmp.setEmail(emp.getEmail());
				pojoEmp.setPhoneNumbers(emp.getPhoneNumbers());
				pojoEmp.setDoj(emp.getDoj());
				pojoEmp.setSalary(emp.getSalary());
				
				pojoList.add(pojoEmp);
			}
		}
		
	}
	 			

}
