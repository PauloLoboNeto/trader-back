package com.initializer.controllers.exceptions;

public class CompanyActionNotFoundExceptionHandler extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CompanyActionNotFoundExceptionHandler(String id) {
		super("Company Action: " + id + " not found.");
	}

}
