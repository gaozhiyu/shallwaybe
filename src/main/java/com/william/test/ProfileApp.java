package com.william.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.william.DAO.ProfileTrial;

public class ProfileApp {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
        String dateOfBirthString ="1987-09-04";
        SimpleDateFormat sdfd0 =new SimpleDateFormat("yyyy-MM-dd");
        Date dateOfBirth =sdfd0.parse(dateOfBirthString);
		
        String lastUpdateString ="2016-03-20 08:30:00";
        SimpleDateFormat sdfd1 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date lastUpdate =sdfd1.parse(lastUpdateString);
        
        String createTimeString ="2016-02-01 12:00:00";
        SimpleDateFormat sdfd2 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date createTime =sdfd2.parse(createTimeString);
        
        String lastAddressUpdateString ="2016-03-15 18:00:00";
        SimpleDateFormat sdfd3 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date lastAddressUpdate =sdfd3.parse(lastAddressUpdateString);
		
		ProfileTrial MP= new ProfileTrial();
		
//		MP.addProfile("666666@gmail.com", "MyPassword", "HelloWord", "M", dateOfBirth, "China", "Henan", lastUpdate, createTime, lastAddressUpdate, "ShallWay? Yes!");
//this part to be modified 19.3.2016
		
		System.out.println(dateOfBirth);
		System.out.println(lastUpdate);
		System.out.println(createTime);	
		System.out.println(lastAddressUpdate);	
	}

}
