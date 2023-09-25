package com.qsp.springbootstudent.Exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qsp.springbootstudent.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandler(IdNotFound ex) {
		ResponseStructure<String> structure =new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("Student With Given id Is not Found");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmailNotFound.class)
	public ResponseEntity<ResponseStructure<String>> emailNotFoundExceptionHandler(EmailNotFound ex) {
		ResponseStructure<String> structure =new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("Student With Given Email Is not Found");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PhoneNotFound.class)
	public ResponseEntity<ResponseStructure<String>> phoneNotFoundExceptionHandler(PhoneNotFound ex) {
		ResponseStructure<String> structure =new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("Student With Given phone Is not Found");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MaxSecuredMarksFound.class)
	public ResponseEntity<ResponseStructure<String>> maxSecuredMarksFound(MaxSecuredMarksFound ex) {
		ResponseStructure<String> structure =new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("Secured Marks is Grater than Total marks");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmptyListFound.class)
	public ResponseEntity<ResponseStructure<String>> emptyListFound(EmptyListFound ex) {
		ResponseStructure<String> structure =new ResponseStructure<String>();
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("No Data Found");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> errors= ex.getAllErrors();
		Map<String, String> map=new HashMap<String ,String>();
		for(ObjectError objectError: errors) {
			FieldError error=(FieldError) objectError;
			String field=error.getField();
			String message=error.getDefaultMessage();
			map.put(field, message);
		}
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
	}

}
