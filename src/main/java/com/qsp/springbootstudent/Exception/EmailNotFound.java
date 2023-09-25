package com.qsp.springbootstudent.Exception;

public class EmailNotFound extends RuntimeException{

private String message;
	
	@Override
	public String getMessage() {
		
		return message;
	}

	public EmailNotFound(String message) {
		super();
		this.message = message;
	}
}
