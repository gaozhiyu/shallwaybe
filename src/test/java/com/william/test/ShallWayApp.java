package com.william.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.william.DAO.ShallWayDAO;
import com.william.entity.ShallWayEntity;
import com.william.to.ShallWayInDTO;
import com.william.to.ShallWayUpdateDTO;


public class ShallWayApp {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
        String startTimeString ="20/4/2016";
//        SimpleDateFormat sdfd1 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date startTime =sdfd1.parse(startTimeString);
        
        String endTimeString ="1/5/2016";
//        SimpleDateFormat sdfd2 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date endTime =sdfd2.parse(endTimeString);
        		
		ShallWayDAO MSW= new ShallWayDAO();
		ShallWayEntity[] shallWayArray =null;
		
		ShallWayInDTO shallWayIn = new ShallWayInDTO ("1000","Huzong", "Singapore","Marine Parade", "Bedok", "Finland Garden", startTimeString, endTimeString, "true", "true", "false", "false", "ONE DAY Tour", "QQ: 554163030", "Happy Happy Day");
		ShallWayUpdateDTO shallWayUpdate = new ShallWayUpdateDTO ("3e9b1901cb9c40debf328759e22d1a6f","1003","Huzong", "Singapore","Jurong West", "NTU", "North Spine", startTimeString, endTimeString, "false", "false", "true", "true", "ONE DAY TREK", "QQ: 554163030", "Happy Happy Walk!");
		
		MSW.addShallWay(shallWayIn);			
//		MSW.updateShallWay(shallWayUpdate);		
//		MSW.deleteShallWay("d20ed3b6437f4baaaa0e9e0419328ad7", "1003");
	
		shallWayArray = MSW.readShallWay("1000");
		
		for (int i=0; i < shallWayArray.length; i++){
			System.out.println();
			System.out.println("ID: "+shallWayArray[i].getId());
			System.out.println("\tShallWayID: "+shallWayArray[i].getShallWayID());
			System.out.println("\tCountry: "+shallWayArray[i].getCountry());
			System.out.println("\tProvince: "+shallWayArray[i].getProvince());
			System.out.println("\tCity: "+shallWayArray[i].getCity());
			System.out.println("\tPlace: "+shallWayArray[i].getPlace());
			System.out.println("\tStart Time: "+shallWayArray[i].getStartTime());
			System.out.println("\tEnd Time: "+shallWayArray[i].getEndTime());
			System.out.println("\tPost Time: "+shallWayArray[i].getPostTime());
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
