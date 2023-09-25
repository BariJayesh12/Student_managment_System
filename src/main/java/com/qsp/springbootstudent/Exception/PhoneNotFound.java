package com.qsp.springbootstudent.Exception;

public class PhoneNotFound extends RuntimeException {

	private String message;

	@Override
	public String getMessage() {

		return message;
	}

	public PhoneNotFound(String message) {
		super();
		this.message = message;
	}

}
