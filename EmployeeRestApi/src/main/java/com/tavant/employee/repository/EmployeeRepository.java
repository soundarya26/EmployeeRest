package com.tavant.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tavant.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
