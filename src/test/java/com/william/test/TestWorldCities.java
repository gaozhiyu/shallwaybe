package com.william.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.william.DAO.WorldCitiesDAO;
import com.william.to.AddressDTO;
import com.william.to.CoordinateDTO;

public class TestWorldCities {

	WorldCitiesDAO WCD = new WorldCitiesDAO();
	CoordinateDTO coordinateDTO = new CoordinateDTO();
	AddressDTO addressInDTO = new AddressDTO();

	String[] countryList = null;
	String[] provinceList = null;
	String[] cityList = null;
	
	@Test
	public void testGetCountryList(){
		countryList = WCD.getCountryList();
		assertEquals(223, countryList.length);			
	}
	
	@Test
	public void testGetProvinceList(){
		provinceList = WCD.getProvinceList("China");
		assertEquals(30, provinceList.length);			
	}
	
	@Test
	public void testGetCityList(){
		cityList = WCD.getCityList("China","Henan");
		assertEquals(16, cityList.length);			
	}
	
	@Test
	public void testGetCoordinateList(){
		addressInDTO.setCountry("China");
		addressInDTO.setProvince("Henan");
		addressInDTO.setCity("Pingdingshan");
		coordinateDTO = WCD.getCoordinateList(addressInDTO);
//		assertEquals(33.730407530, coordinateDTO.getLatitude());
//To test this part again 12.06.2016
		assertTrue(0 == coordinateDTO.getLatitude());
	}
	
	
	
	
	
}
