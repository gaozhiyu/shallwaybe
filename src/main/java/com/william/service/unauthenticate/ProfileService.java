package com.william.service.unauthenticate;

import com.william.DAO.ProfileDAO;
import com.william.DAO.WorldCitiesDAO;
import com.william.to.GISDTO;
import com.william.to.RegisterInDTO;
import com.william.to.RegisterOutDTO;

public class ProfileService {
	
	public RegisterOutDTO register(RegisterInDTO inDTO){
		ProfileDAO mgDAO = new ProfileDAO();
		inDTO.setProvince(inDTO.getCity().substring(0, 1));//TODO change in future
		RegisterOutDTO outDTO = mgDAO.addProfile(inDTO);
		if(outDTO!= null)
			outDTO.setStatus("Y");
		else
			outDTO.setStatus("N");
		return outDTO;
	}
	
	public GISDTO getCountryList(){
		WorldCitiesDAO wcDAO = new WorldCitiesDAO();
		String[] countryArray =  wcDAO.getCountryList();
		GISDTO gisDTO = new GISDTO();
		if(countryArray!=null && countryArray.length>0){
			gisDTO.setStatus("Y");
			gisDTO.setCountryArray(countryArray);
		}else{
			gisDTO.setStatus("N");
		}
		return gisDTO;
	}
}
