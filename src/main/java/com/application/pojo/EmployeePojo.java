package com.application.pojo;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePojo {
	private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private List<String> phoneNumbers;
    private LocalDate doj;
    private double salary;

}
