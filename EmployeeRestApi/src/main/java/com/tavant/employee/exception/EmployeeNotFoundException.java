package com.tavant.employee.exception;

public class EmployeeNotFoundException extends Exception {
	public EmployeeNotFoundException(String msg) {
		super(msg);
	}
	@Override
	public String toString() {
		return super.toString()+super.getMessage();
	}

}
