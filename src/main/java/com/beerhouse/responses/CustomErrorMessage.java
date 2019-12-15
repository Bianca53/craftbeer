package com.beerhouse.responses;


public class CustomErrorMessage {
	
	private String message;

	public CustomErrorMessage() {

	}

	public CustomErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
