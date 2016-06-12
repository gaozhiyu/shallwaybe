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
        
        LatestCoordinateInDTO latestCoordinateInDTO = new LatestCoordinateInDTO("bbf8c163753e404b8d5e5a6e51c831e3","2.1", "2.2" ,"中国","河南省", "平顶山");
        
        LatestCoordinateOutDTO latestCoordinateOutDTO= new LatestCoordinateOutDTO();
        LatestCoordinateDAO MLC = new LatestCoordinateDAO();
        
//        MLC.addLatestCoordinate(latestCoordinateInDTO);
//        MLC.updateLatestCoordinate(latestCoordinateInDTO);
        MLC.saveOrUpdateLatestCoordinate(latestCoordinateInDTO);
        
        latestCoordinateOutDTO = MLC.readLatestCoordinate("bbf8c163753e404b8d5e5a6e51c831e3");
        
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
