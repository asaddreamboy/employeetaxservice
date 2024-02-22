package com.application.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetails extends EmployeeCommon {
	@NotNull(message = "The yearlySalary field is required.")
    private double yearlySalary;
	@NotNull(message = "The taxAmount field is required.")
    private double taxAmount;
	@NotNull(message = "The cessAmount field is required.")
    private double cessAmount;
    
}
