package com.william.service.unauthenticate;
//InputValidation is done 
import com.william.DAO.ProfileDAO;
import com.william.DAO.WorldCitiesDAO;
import com.william.to.AddressDTO;
import com.william.to.CoordinateDTO;
import com.william.to.GISDTO;
import com.william.to.RegisterInDTO;
import com.william.to.RegisterOutDTO;
import com.william.to.ValidationResult;
import com.william.util.ParserJsonUtil;

public class ProfileService {
	
	public RegisterOutDTO register(RegisterInDTO inDTO){
		ProfileDAO mgDAO = new ProfileDAO();
		WorldCitiesDAO wcDAO = WorldCitiesDAO.getInstance();
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setCountry(inDTO.getCountry());
		addressDTO.setProvince(inDTO.getProvince());
		addressDTO.setCity(inDTO.getCity());
		CoordinateDTO cord=wcDAO.getCoordinateList(addressDTO);
		inDTO.setLatitude(""+cord.getLatitude());
		inDTO.setLongitude(""+cord.getLongitude());
		ParserJsonUtil geo = new ParserJsonUtil();
		AddressDTO tmp= geo.getAddress(cord.getLatitude(),cord.getLongitude());
		if(tmp != null){
			inDTO.setGoogleCountry(tmp.getCountry());
			inDTO.setGoogleProvince(tmp.getProvince());
			inDTO.setGoogleCity(tmp.getCity());
		}
		RegisterOutDTO outDTO = null;
		ValidationResult result = inDTO.isValid();
		if(result != null && result.isResultValid())
			outDTO = mgDAO.addProfile(inDTO);
		//TODO add the mapcall
		if(outDTO!= null)
			outDTO.setStatus("Y");
		else
			outDTO.setStatus("N");
		return outDTO;
	}
	
	public GISDTO getCountryList(){
		WorldCitiesDAO wcDAO = WorldCitiesDAO.getInstance();;
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
	
	public GISDTO getProvinceList(String country){
		WorldCitiesDAO wcDAO = WorldCitiesDAO.getInstance();;
		String[] provinceArray =  wcDAO.getProvinceList(country);
		GISDTO gisDTO = new GISDTO();
		if(provinceArray!=null && provinceArray.length>0){
			gisDTO.setStatus("Y");
			gisDTO.setProvinceArray(provinceArray);
		}else{
			gisDTO.setStatus("N");
		}
		return gisDTO;
	}
	
	public GISDTO getCityList(AddressDTO address){
		WorldCitiesDAO wcDAO = WorldCitiesDAO.getInstance();;
		String[] cityArray =  wcDAO.getCityList(address.getCountry(),address.getProvince());
		GISDTO gisDTO = new GISDTO();
		if(cityArray!=null && cityArray.length>0){
			gisDTO.setStatus("Y");
			gisDTO.setCityArray(cityArray);
		}else{
			gisDTO.setStatus("N");
		}
		return gisDTO;
	}
}
