package com.application.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends EmployeeCommon{
	@NotNull(message = "The email field is required.")
    private String email;
	@NotNull(message = "The phoneNumbers field is required.")
    private List<String> phoneNumbers;
	@NotNull(message = "The date of joining field is required.")
	@JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate doj;
	@NotNull(message = "The salary field is required.")
    private double salary;
   
}
