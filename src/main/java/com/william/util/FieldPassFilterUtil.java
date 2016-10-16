package com.william.util;

import java.util.regex.Pattern;

public class FieldPassFilterUtil {
	
	// for country, province, city
	public static boolean validAlphOnly(String str){
    	String patternString ="^[a-zA-Z ]+$";
    	boolean isMatch = Pattern.matches(patternString, str);
 		return isMatch;
	}
	
	// for UserIntID
	public static boolean validAlphDigOnly(String str){
    	String patternString ="^[0-9a-zA-Z ]+$";
    	boolean isMatch = Pattern.matches(patternString, str);
 		return isMatch;
	}
	
	//Password length should be 8-16 characters
	public static boolean validPasswordLength(String str){
		boolean passwordValid;
    	if (str.length()>= 8 && str.length()<=16)
    		passwordValid = true;
    	else
    		passwordValid = false;
    	
    	return passwordValid;
	}
		
	public static boolean validEmailAdreess(String str){
    	String emailString ="^([a-z0-9A-Z_]+[-|\\.]?)+[a-z0-9A-Z]?@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    	boolean emailMatch = Pattern.matches(emailString, str);
		return emailMatch;		
	}
	
	public static boolean validLatitude(String str){
       	String latitudeString = "^[-|+]?([0-8]?\\d{1}\\.\\d{1,5}|90\\.0{1,5})$";
    	boolean latitudeMatch = Pattern.matches(latitudeString, str);
    	return latitudeMatch;
	}
	
	public static boolean validLongitude(String str){
    	String longitudeString = "^[-|+]?((1[0-7]\\d{1}|0?\\d{1,2})\\.\\d{1,5}|180\\.0{1,5})$";
    	boolean longitudeMatch = Pattern.matches(longitudeString, str);
    	return longitudeMatch;
	}
}
