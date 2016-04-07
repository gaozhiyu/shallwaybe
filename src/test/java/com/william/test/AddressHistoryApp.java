package com.william.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.william.DAO.AddressHistoryDAO;
import com.william.to.AddressHistoryInDTO;

public class AddressHistoryApp {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
//        String updateTimeString ="2016-03-09 18:30:00";
//        SimpleDateFormat sdfd1 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date updateTime =sdfd1.parse(updateTimeString);
        
//		Date updateTime = new Date();
		
        String[] cityList = null;
        AddressHistoryInDTO addressHistory = new AddressHistoryInDTO("0001","China","Henan Province","Luo Yang","R");
        
        AddressHistoryDAO AHS = new AddressHistoryDAO();
        
//        AHS.addAddressHistory(addressHistory);
        cityList=AHS.readAddressHistory("0001","b");   
        
        for (int i=0; i<cityList.length;i++)
        	System.out.println("City "+i+" : "+cityList[i]);
        
	}

}
