package com.william.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.william.DAO.AddressHistoryDAO;
import com.william.to.AddressHistoryInDTO;
import com.william.to.AddressHistoryOutDTO;

public class AddressHistoryApp {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
//        String updateTimeString ="2016-03-09 18:30:00";
//        SimpleDateFormat sdfd1 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date updateTime =sdfd1.parse(updateTimeString);
        
//		Date updateTime = new Date();
		
//        String[] cityList = null;
        AddressHistoryOutDTO[] AddressHistoryArray = null;
        AddressHistoryInDTO addressHistory = new AddressHistoryInDTO("981e630a59964937a006d320d2d097df","Singapore","Guang Dong Province","Guang Zhou","R");
        
        AddressHistoryDAO AHS = new AddressHistoryDAO();
        
        AHS.addAddressHistory(addressHistory);
        AddressHistoryArray=AHS.readAddressHistory("981e630a59964937a006d320d2d097df","R");   
        
        for (int i=0; i<AddressHistoryArray.length;i++){
        	if (i==0)
        		System.out.println("Nickname: "+AddressHistoryArray[i].getNickname());
        	
        	System.out.println("\tCity "+i+" : "+AddressHistoryArray[i].getCity());
        	
        }
        
	}

}
