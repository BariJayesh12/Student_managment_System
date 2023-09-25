package com.qsp.springbootstudent.Exception;

public class EmptyListFound extends RuntimeException{
	
	private String message;

	@Override
	public String getMessage() {
	
		return message;
	}
	public EmptyListFound(String message) {
		super();
		this.message = message;
	}
	

}
