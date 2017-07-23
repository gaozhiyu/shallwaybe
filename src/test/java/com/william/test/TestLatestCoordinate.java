package com.william.test;

import org.junit.Test;

import com.william.DAO.LatestCoordinateDAO;
import com.william.to.LatestCoordinateInDTO;
import com.william.to.LatestCoordinateOutDTO;

public class TestLatestCoordinate {
	
//  String lastShakeTimeString ="2016-04-05 12:30:00";
//  SimpleDateFormat sdfd1 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//  Date lastShakeTime =sdfd1.parse(lastShakeTimeString);
  
	LatestCoordinateInDTO latestCoordinateInDTO = new LatestCoordinateInDTO("07d407cf02154d8f814c099cb0301c16","2.1", "2.2" ,"中国","南海省", "新加坡市");
  
	LatestCoordinateOutDTO latestCoordinateOutDTO= new LatestCoordinateOutDTO();
	LatestCoordinateDAO MLC = new LatestCoordinateDAO();	
	
	@Test
	public void TestSaveOrUpdateLatestCoordinate(){
//      MLC.addLatestCoordinate(latestCoordinateInDTO);
//      MLC.updateLatestCoordinate(latestCoordinateInDTO);
		MLC.saveOrUpdateLatestCoordinate(latestCoordinateInDTO);		
	}

	@Test
	public void TestReadLatestCoordinate(){
		
        latestCoordinateOutDTO = MLC.readLatestCoordinate("07d407cf02154d8f814c099cb0301c16");
        
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
