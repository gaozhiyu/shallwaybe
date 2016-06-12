package com.william.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
}
