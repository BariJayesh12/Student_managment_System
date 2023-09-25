package com.qsp.springbootstudent.Exception;

public class MaxSecuredMarksFound extends RuntimeException {

private String message;
	
	@Override
	public String getMessage() {
		
		return message;
	}

	public MaxSecuredMarksFound(String message) {
		super();
		this.message = message;
	}
}
