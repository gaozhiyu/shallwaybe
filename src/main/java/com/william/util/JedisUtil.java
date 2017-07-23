package com.william.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {
	private static JedisPool pool;
	
	public static JedisPool getinstance()
	{
		if(pool == null){
			pool = new JedisPool(new JedisPoolConfig(), "localhost");
		    System.out.println("Connection to server sucessfully");
		} 
		return pool;
	}
	
	public static void set(String key, String value){
		set(key, "APP", value);
		//getinstance().set(key, value);	
		//getinstance().expire(key, 15*60);
	}
	
	
	public static String get(String key){  
		return get(key, "APP");
	}
	
	
	public static boolean del(String key){
		
		Jedis jedis = null;
		Long result = -1L;
		try {
		    jedis = pool.getResource();
		    /// ... 运行相关的Redis操作
			// TODO Auto-generated method stub
		    result = jedis.del(key);
		} finally {
		    if (jedis != null) {
		        jedis.close();
		    }
		}
		return result > 0;
		//Long result = getinstance().del(key);
		
		
		/*if(result>0)
			return true;
		else{
			String str = get(key);
			if(str!=null && !"".equals(str))
				return false;
			else 
				return true;
		}*/

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
		Jedis jedis = null;
		try {
		    jedis = pool.getResource();
		    /// ... 运行相关的Redis操作
		    jedis.hset(key, field, value);
		    jedis.expire(key,60*60*24);
		} finally {
		    if (jedis != null) {
		    	//pool.returnResource(jedis);
		        jedis.close();
		        //jedisPool.returnResource(jedis);
		    }
		}
		

		
		
	}

	public static String get(String key, String field) {

		Jedis jedis = null;
		String result = null;
		try {
		    jedis = pool.getResource();
		    /// ... 运行相关的Redis操作
			// TODO Auto-generated method stub
			result =  jedis.hget(key, field);
		} finally {
		    if (jedis != null) {
		    	//pool.returnResource(jedis);
		        jedis.close();
		    }
		}
		return result;
	}
	
	public static long hdel(String key, String field) {
		// TODO Auto-generated method stub
		Long result = -1L;
		
		Jedis jedis = null;
		try {
		    jedis = pool.getResource();
		    /// ... 运行相关的Redis操作
			// TODO Auto-generated method stub
			result= jedis.hdel(key, field);
		} finally {
		    if (jedis != null) {
		    	//pool.returnResource(jedis);
		        jedis.close();
		    }
		}
		 return result ;
	}
	
	
	
}
