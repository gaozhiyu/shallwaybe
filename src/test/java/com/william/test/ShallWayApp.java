package com.william.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.william.DAO.ShallWayDAO;
import com.william.entity.ShallWayEntity;
import com.william.to.ShallWayInDTO;
import com.william.to.ShallWayOutDTO;
import com.william.to.ShallWaySearchDTO;
import com.william.to.ShallWayUpdateDTO;


public class ShallWayApp {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
        String startTimeString ="20/04/2016";
        String endTimeString ="01/06/2016";
        SimpleDateFormat sdfd1 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdfd2 =new SimpleDateFormat("yyyy-MM-dd");
        
//        SimpleDateFormat sdfd1 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date startTime =sdfd1.parse(startTimeString); 
        		
		ShallWayDAO MSW= new ShallWayDAO();
		ShallWayOutDTO[] shallWayArray =null;
//		ShallWayOutDTO shallWayArray = new ShallWayOutDTO();
//		ShallWayEntity[] shallWayArray =null;
		

		ShallWayInDTO shallWayIn = new ShallWayInDTO ("981e630a59964937a006d320d2d097df","Singapore","CithHall", "CBD", "Merlion", startTimeString, endTimeString, "true", "true", "true", "true", "ONE DAY Tour", "QQ: 554163030", "Happy Happy Day");
		ShallWayUpdateDTO shallWayUpdate = new ShallWayUpdateDTO ("9c5fcf6772494885a8a9ed00c3961383","981e630a59964937a006d320d2d097df","Singapore","Clementi", "NUS", "S 16", startTimeString, endTimeString, "false", "false", "false", "false", "ONE DAY TREK", "QQ: 554163030", "Happy Happy Walk!");
		ShallWaySearchDTO shallWaySearch = new ShallWaySearchDTO("Singapore","CithHall","CBD","Merlion", startTimeString, endTimeString, "true", "false", "false", "false");
		
//		MSW.addShallWay(shallWayIn);			
//		MSW.updateShallWay(shallWayUpdate);		
//		MSW.deleteShallWay("865093ac5c35444f8ab4cecdbb8fe62f", "1000");
	
//		shallWayArray = MSW.readShallWay("981e630a59964937a006d320d2d097df", 1);
//		shallWayArray = MSW.readShallWay(shallWaySearch,"", 1);
		shallWayArray = MSW.readShallWay(shallWaySearch,"981e630a59964937a006d320d2d097df",1);
		
//		shallWayArray = MSW.retrieveDateByDateID("109a2fce63d7497bbbdd48efd5a88c5b");
//		System.out.println("Nickname: "+shallWayArray.getNickname());
		
//		System.out.println("\tCar Pool: "+shallWaySearch.getCarPool().equals("false"));
//		System.out.println("\tCar Pool: "+shallWaySearch.getCarPool());
//		System.out.println("\tFree Tour: "+shallWaySearch.getFreeTour().equals("true"));
//		System.out.println("\tFree Tour: "+shallWaySearch.getFreeTour());
//		System.out.println("\tHotel Share: "+shallWaySearch.getHotelShare());
//		System.out.println("\tFree Guide: "+shallWaySearch.getFreeGuide());
	
		
		for (int i=0; i < shallWayArray.length; i++){
			System.out.println();
//			System.out.println("Nickname: "+shallWayArray[i].getNickname());
			System.out.println("DateID: "+shallWayArray[i].getDateID());
			System.out.println("\tUserIntID: "+shallWayArray[i].getUserIntID());
			System.out.println("\tCountry: "+shallWayArray[i].getCountry());
			System.out.println("\tProvince: "+shallWayArray[i].getProvince());
			System.out.println("\tCity: "+shallWayArray[i].getCity());
			System.out.println("\tPlace: "+shallWayArray[i].getPlace());
			System.out.println("\tStart Time: "+sdfd2.format(shallWayArray[i].getStartTime()));
			System.out.println("\tEnd Time: "+sdfd2.format(shallWayArray[i].getEndTime()));
			System.out.println("\tPost Time: "+sdfd1.format(shallWayArray[i].getPostTime()));
			System.out.println("\tCar Pool: "+shallWayArray[i].getCarPool());
			System.out.println("\tFree Tour: "+shallWayArray[i].getFreeTour());
			System.out.println("\tHotel Share: "+shallWayArray[i].getHotelShare());
			System.out.println("\tFree Guide: "+shallWayArray[i].getFreeGuide());
			System.out.println("\tTitle: "+shallWayArray[i].getTitle());
			System.out.println("\tContact: "+shallWayArray[i].getContact());
			System.out.println("\tDescription: "+shallWayArray[i].getDescription());
		}
		
	}

}
