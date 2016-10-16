package com.william.util;

import java.lang.reflect.Method;
import java.util.HashMap;

public class MethodHashMap {
	private static HashMap<String, Method> methodMap ;
	
	public static HashMap<String, Method> getInstance(){
		if(methodMap == null)
			methodMap = new HashMap<String, Method>();
		return methodMap;
	}
	
	

}
