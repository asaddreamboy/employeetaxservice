package com.application.utility;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.application.pojo.EmployeePojo;

public class TaxCalculationUtill {
	@Value("#{'${financiaYear.consider}'.split(',')}")
	public static List<String> FINANCIAL_YEARS;
	
	public static double calculateYearlySalary(EmployeePojo employee) {
        LocalDate doj = employee.getDoj();
        double salary = employee.getSalary();
        int monthsWorked = 12 - doj.getMonthValue() + 4; // April 1st
        if(doj.getDayOfMonth() > 1) {
        	int daysNotWorked=doj.getDayOfMonth()-1;
        	int daysWorked=monthsWorked*30;
        	double salaryPerDay=salary/30;
        return (daysWorked-daysNotWorked)*salaryPerDay;
        }
        return salary * monthsWorked;
    }
	
	public static double calculateTaxAmount(double yearlySalary) {
        double taxAmount = 0;
        if (yearlySalary > 250000 && yearlySalary <= 500000) {
            taxAmount = (yearlySalary - 250000) * 0.05;
        } else if (yearlySalary > 500000 && yearlySalary <= 1000000) {
            taxAmount = 12500 + (yearlySalary - 500000) * 0.1;
        } else if (yearlySalary > 1000000) {
            taxAmount = 62500 + (yearlySalary - 1000000) * 0.2;
        }
        return taxAmount;
    }
	
	public static double calculateCessAmount(double yearlySalary) {
        return yearlySalary > 2500000 ? yearlySalary * 0.02 : 0;
    }

}
