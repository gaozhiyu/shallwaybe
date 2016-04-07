package com.william.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.william.DAO.LatestCoordinateDAO;
import com.william.entity.LatestCoordinateEntity;
import com.william.to.LatestCoordinateInDTO;

public class LatestCoordinateApp {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
//        String lastShakeTimeString ="2016-04-05 12:30:00";
//        SimpleDateFormat sdfd1 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date lastShakeTime =sdfd1.parse(lastShakeTimeString);
        
        LatestCoordinateInDTO latestCoordinateInDTO = new LatestCoordinateInDTO("46", 2.5, 2.6 ,"Singapore","He Nan Province", "Luo Yang");
        
        LatestCoordinateEntity latestCoordinateEntity= new LatestCoordinateEntity();
        LatestCoordinateDAO MLC = new LatestCoordinateDAO();
        
//        MLC.addLatestCoordinate(latestCoordinateInDTO);
        MLC.updateLatestCoordinate(latestCoordinateInDTO);
        
        latestCoordinateEntity = MLC.readLatestCoordinate("4");
        
		System.out.println();
		System.out.println("ShallWayID: "+latestCoordinateEntity.getShallWayID());
		System.out.println("\tLongitude: "+latestCoordinateEntity.getLongitude());
		System.out.println("\tLatitude: "+latestCoordinateEntity.getLatitude());
		System.out.println("\tLast Shake Time: "+latestCoordinateEntity.getLastShakeTime());
		System.out.println("\tCountry: "+latestCoordinateEntity.getCountry());
		System.out.println("\tProvince: "+latestCoordinateEntity.getProvince());
		System.out.println("\tCity: "+latestCoordinateEntity.getCity());
		System.out.println("\tLast Address Update: "+latestCoordinateEntity.getLastAddressUpdate());
	
	}
	
}
