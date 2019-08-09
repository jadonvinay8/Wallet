package com.cg.service;

public interface Validator {
	
	String aidPattern = "[1-9][0-9][0-9]";
	String phonePattern = "[1-9]{1}[0-9]{9}";
	String namePattern = "[a-zA-Z][a-zA-Z ]*";
	String balPattern = "[1-9][0-9]*";
	
	public static boolean validateData(String data, String pattern) {
		
		return data.matches(pattern);
	}
	
}
