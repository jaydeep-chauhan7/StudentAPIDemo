package com.example.exception;
//This is Custom General Exception Class  
public class StudentException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentException(String errorMessage) {
		super(errorMessage);
	}
}
