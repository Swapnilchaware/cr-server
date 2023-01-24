package com.example.cashrich.util;

public class ValidationHelper {

	private ValidationHelper() {
		
	}

	public static boolean checkMinLengthAndMaxLength(String word,int min,int max) {
		
		if (word.length() >= min && word.length() <= max) {
			return true;
		}
		return false;
	}
		
}
