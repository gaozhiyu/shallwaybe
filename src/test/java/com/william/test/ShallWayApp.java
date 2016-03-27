package com.william.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.william.DAO.ShallWayDAO;


public class ShallWayApp {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
        String startTimeString ="2016-03-20 08:30:00";
        SimpleDateFormat sdfd1 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime =sdfd1.parse(startTimeString);
        
        String endTimeString ="2016-04-20 23:59:59";
        SimpleDateFormat sdfd2 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date endTime =sdfd2.parse(endTimeString);
        
        String postTimeString ="2016-03-02 18:00:00";
        SimpleDateFormat sdfd3 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date postTime =sdfd3.parse(postTimeString);
		
		ShallWayDAO MSW= new ShallWayDAO();
		
		MSW.addShallWay("1003", "Singapore", "Jurong West", "NTU", startTime, endTime, postTime, true, true, false, false, "ONE DAY TREK", "QQ: 554163030", "The Southern Ridges: From Kent Ridge MRT to VivoCity, free to join, taking arond 3 hours, total distance:9KM.");
//		MSW.listShallWay();
		MSW.updateShallWay("f000f0c77f794b7aa1171bf4a167d6a0","445", "China", "Henan", "Pingdingshan", startTime, endTime, postTime, true, true, false, false, "ONE DAY TREK", "QQ: 554163030", "The Southern Ridges: From Kent Ridge MRT to VivoCity, free to join, taking arond 3 hours, total distance:9KM.");
//		MSW.deleteShallWay("9ec2ba5f14c74418a9d042c63509470c", "123");
		System.out.println(startTime);
		System.out.println(endTime);
		System.out.println(postTime);
	}

}
