package com.william.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CryptWithMD5Util {
	private static MessageDigest md;

	   public static String cryptWithMD5Util(String pass){
	    try {
	        md = MessageDigest.getInstance("SHA-512");
	        byte[] passBytes = pass.getBytes();
	        md.reset();
	        byte[] digested = md.digest(passBytes);
	        StringBuffer sb = new StringBuffer();
	        for(int i=0;i<digested.length;i++){
	            sb.append(Integer.toHexString(0xff & digested[i]));
	        }
	        return sb.toString();
	    } catch (NoSuchAlgorithmException ex) {
	        Logger.getLogger(CryptWithMD5Util.class.getName()).log(Level.SEVERE, null, ex);
	    }
	        return null;


	   }
	   
	   
		public static String testRandomNumber(int lenght){
			
		    final String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		    final int N = alphabet.length();
		    Random r = new Random();
		    StringBuilder sb = new StringBuilder();

		    for (int i = 0; i < lenght; i++) {
		    	char newchar = alphabet.charAt(r.nextInt(N));
//		        System.out.print(newchar);
		        sb.append(newchar);
		    }
		    
		    //System.out.println("\n New String:" + sb.toString());
		    
		    return sb.toString();
		}
}
