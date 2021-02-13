package com.tavant.employee.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.employee.exception.EmployeeNotFoundException;
import com.tavant.employee.exception.NoDataFoundException;
import com.tavant.employee.model.Employee;
import com.tavant.employee.repository.EmployeeRepository;
@CrossOrigin
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;
	@GetMapping
	public String getEmployee() {
		return "welcome to react";
	}
	
	@GetMapping("/all")
	public List<Employee> getAllEmployees() throws Exception
	{
		List list=this.employeeRepository.findAll();
		return Optional.ofNullable(list.isEmpty()?null:list).orElseThrow(()->new NoDataFoundException("No data found"));
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<?>getEmployeeById(@PathVariable("id")Integer id)throws EmployeeNotFoundException
	{
		Optional<Employee>optional=employeeRepository.findById(id);
		if(optional.isPresent()) 
		{
			return ResponseEntity.ok(optional.get());
		}
		else {
			throw new EmployeeNotFoundException("Resource not found");
		}
		
	}
@PostMapping
public Employee addEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException
{
	if(employee.getEmployeeId()==null)
	{
		throw new EmployeeNotFoundException("cannot add employee");
	}
	return employeeRepository.save(employee);
}
@DeleteMapping("/delete/{id}")
public String deleteEmployee(@PathVariable("id") Integer id)throws EmployeeNotFoundException
{
	Optional<Employee>optional=employeeRepository.findById(id);
	if(optional.isPresent())
	{
		employeeRepository.deleteById(id);
		return "Resource deleted succesfully";
	}
	else
	{
		throw new EmployeeNotFoundException("resource not found");
	}
}
@PutMapping("/{Id}")
public ResponseEntity<Employee> updateAccount(@PathVariable("Id")Integer id,@Valid @RequestBody Employee resourceDetails)throws EmployeeNotFoundException{
	Employee acc=employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("record not found"));
	acc.setFirstName(resourceDetails.getFirstName());
	acc.setLastName(resourceDetails.getLastName());
	acc.setEmail(resourceDetails.getEmail());
	final Employee newDetails=employeeRepository.save(acc);
	return ResponseEntity.ok(newDetails);
}
}
