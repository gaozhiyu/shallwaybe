package com.william.util;

import redis.clients.jedis.Jedis;

public class JedisUtil {
	private static Jedis jedis;
	
	public static Jedis getinstance()
	{
		if(jedis == null){
			jedis = new Jedis("localhost");
		    System.out.println("Connection to server sucessfully");
		} 
		return jedis;
	}
	
	public static void set(String key, String value){
		set(key, "APP", value);
		//getinstance().set(key, value);	
		//getinstance().expire(key, 15*60);
	}
	
	
	public static String get(String key){
		//return getinstance().get(key);
		return getinstance().hget(key, "APP").toString();
		
//		getinstance().expire(key, 15*60);
	}
	
	
	public static boolean del(String key){
		Long result = getinstance().del(key);
		if(result>0)
			return true;
		else{
			String str = get(key);
			if(str!=null && !"".equals(str))
				return false;
			else 
				return true;
		}
			
//		getinstance().expire(key, 15*60);
	}
	
	public static void main(String[] args){
	      System.out.println("Connection to server sucessfully");
	      //set the data in redis string
	      set("tutorial-name", "Redis tutorial");
	     // Get the stored data and print it
	     System.out.println("Stored string in redis:: "+ get("tutorial-name"));
	}

	public static void set(String key, String field, String value) {
		// TODO Auto-generated method stub
		getinstance().hset(key, field, value);
		getinstance().persist(key);
		
	}

	public static String get(String key, String field) {
		// TODO Auto-generated method stub
		return getinstance().hget(key, field);
	}
}
