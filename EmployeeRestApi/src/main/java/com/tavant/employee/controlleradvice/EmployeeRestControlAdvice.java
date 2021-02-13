package com.tavant.employee.controlleradvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.tavant.employee.errorresponse.ErrorResponse;
import com.tavant.employee.exception.EmployeeNotFoundException;
import com.tavant.employee.exception.NoDataFoundException;

@ControllerAdvice
public class EmployeeRestControlAdvice {
	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseEntity<ErrorResponse>handleEmployeeNotFoundException(EmployeeNotFoundException e,WebRequest req)
	{
		List<String>details=new ArrayList<String>();
		details.add(e.getLocalizedMessage());
		ErrorResponse errorResponse=new ErrorResponse("INCORRECT_RESPONSE",details);
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoDataFoundException.class)
	public final ResponseEntity<ErrorResponse>handleNoDataFoundException(NoDataFoundException e,WebRequest req)
	{
		List<String>details=new ArrayList<String>();
		details.add(e.getLocalizedMessage());
		ErrorResponse errorResponse=new ErrorResponse("INCORRECT_RESPONSE",details);
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
	
}
