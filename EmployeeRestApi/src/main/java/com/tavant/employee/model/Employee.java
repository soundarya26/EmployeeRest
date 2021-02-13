package com.tavant.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
@Entity(name="Employee")
@Table(name="employees")
public class Employee {
	@Id @Column(name="employeeNumber")
	private Integer employeeId;
	private String firstName;
	private String LastName;
	@Transient
	private String extension;
	@Email(message="email should be valid")
	private String email;
	private Integer officeCode;
	private Integer reportsTo;
	private String jobTitle;
	

}
