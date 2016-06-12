package com.william.test;

import com.william.DAO.WorldCitiesDAO;
import com.william.to.AddressDTO;
import com.william.to.CoordinateDTO;

public class WorldCitiesApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WorldCitiesDAO WCD = new WorldCitiesDAO();
		
		String[] countryList = null;
		String[] provinceList = null;
		String[] cityList = null;
		
		CoordinateDTO coordinateDTO = new CoordinateDTO();
		AddressDTO addressInDTO = new AddressDTO();
		addressInDTO.setCountry("China");
		addressInDTO.setProvince("Henan");
		addressInDTO.setCity("Pingdingshan");
		
		countryList =  WCD.getCountryList();
		provinceList = WCD.getProvinceList("china");
		cityList=WCD.getCityList("China", "Henan");
		
		coordinateDTO=WCD.getCoordinateList(addressInDTO);
		System.out.println("Latitude: "+coordinateDTO.getLatitude());
		System.out.println("Longitude: "+coordinateDTO.getLongitude());
		
//		for (int i=0; i<countryList.length;i++){
//			System.out.println("Country No."+(i+1)+": "+countryList[i]);
//			
//		}
		
//		for (int i=0; i<provinceList.length;i++){
//			System.out.println("Province No."+(i+1)+": "+provinceList[i]);
//			
//		}	
		
//		for (int i=0; i<cityList.length;i++){
//			System.out.println("City No."+(i+1)+": "+cityList[i]);
//			
//		}

	}

}
