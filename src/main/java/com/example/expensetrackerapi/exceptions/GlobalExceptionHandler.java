package com.example.expensetrackerapi.exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.expensetrackerapi.entity.ErrorObject;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorObject> handleExpenseNotFoundException(ResourceNotFoundException ex, WebRequest request){
		
		ErrorObject errorObj = new ErrorObject();
		errorObj.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorObj.setMessage(ex.getMessage());
		errorObj.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<ErrorObject>(errorObj,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex , WebRequest request){
		
		ErrorObject errorObj = new ErrorObject(HttpStatus.BAD_REQUEST.value(),ex.getMessage(),System.currentTimeMillis());
		
		return new ResponseEntity<Object>(errorObj,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorObject> handleGeneralException(Exception ex , WebRequest request){
		
		ErrorObject errorObj = new ErrorObject(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage(),System.currentTimeMillis());
		
		return new ResponseEntity<ErrorObject>(errorObj,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		Map<String, Object> body = new HashMap<String, Object>();
		
		body.put("statusCode", HttpStatus.BAD_REQUEST.value());
		
		List<String> errors = ex.getBindingResult()
			.getFieldErrors()
			.stream()
			.map(x -> x.getDefaultMessage())
			.collect(Collectors.toList());
		
		body.put("messages", errors);
		
		body.put("timestamp", new Date());
		
		return new ResponseEntity<Object>(body, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(ItemAlreadyExistsException.class)
	public ResponseEntity<Object> handleItemAlreadyExistsException(ItemAlreadyExistsException ex,WebRequest request){
		ErrorObject errorObj = new ErrorObject(HttpStatus.CONFLICT.value(),ex.getMessage(),System.currentTimeMillis());
		
		return new ResponseEntity<Object>(errorObj,HttpStatus.CONFLICT);
	}
	
}
