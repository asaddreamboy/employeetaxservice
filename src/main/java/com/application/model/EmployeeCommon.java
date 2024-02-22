package com.application.model;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCommon{
	@NotNull(message = "The employeeId field is required.")
	private String employeeId;
	@NotNull(message = "The firstName field is required.")
    private String firstName;
	@NotNull(message = "The lastName field is required.")
    private String lastName;
  
}
