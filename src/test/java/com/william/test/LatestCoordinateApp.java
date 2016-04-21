package com.william.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.william.DAO.LatestCoordinateDAO;
import com.william.entity.LatestCoordinateEntity;
import com.william.to.LatestCoordinateInDTO;
import com.william.to.LatestCoordinateOutDTO;

public class LatestCoordinateApp {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
//        String lastShakeTimeString ="2016-04-05 12:30:00";
//        SimpleDateFormat sdfd1 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date lastShakeTime =sdfd1.parse(lastShakeTimeString);
        
        LatestCoordinateInDTO latestCoordinateInDTO = new LatestCoordinateInDTO("981e630a59964937a006d320d2d097df","1.1", "1.2" ,"Singapore","He Nan Province", "Kai Feng");
        
        LatestCoordinateOutDTO latestCoordinateOutDTO= new LatestCoordinateOutDTO();
        LatestCoordinateDAO MLC = new LatestCoordinateDAO();
        
//        MLC.addLatestCoordinate(latestCoordinateInDTO);
        MLC.updateLatestCoordinate(latestCoordinateInDTO);
        
        latestCoordinateOutDTO = MLC.readLatestCoordinate("981e630a59964937a006d320d2d097df");
        
		System.out.println();
		System.out.println("Nickname: "+latestCoordinateOutDTO.getNickname());
		System.out.println("UserIntID: "+latestCoordinateOutDTO.getUserIntID());
		System.out.println("\tLongitude: "+latestCoordinateOutDTO.getLongitude());
		System.out.println("\tLatitude: "+latestCoordinateOutDTO.getLatitude());
		System.out.println("\tLast Shake Time: "+latestCoordinateOutDTO.getLastShakeTime());
		System.out.println("\tCountry: "+latestCoordinateOutDTO.getCountry());
		System.out.println("\tProvince: "+latestCoordinateOutDTO.getProvince());
		System.out.println("\tCity: "+latestCoordinateOutDTO.getCity());
		System.out.println("\tLast Address Update: "+latestCoordinateOutDTO.getLastAddressUpdate());
	
	}
	
}
