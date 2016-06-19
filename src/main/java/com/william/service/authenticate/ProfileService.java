package com.william.service.authenticate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.william.DAO.ProfileDAO;
import com.william.DAO.WorldCitiesDAO;
import com.william.entity.ProfileEntity;
import com.william.to.AddressDTO;
import com.william.to.CoordinateDTO;
import com.william.to.GISDTO;
import com.william.to.ProfileInDTO;
import com.william.util.ParserJsonUtil;
import com.william.vo.ProfileVO;
import com.william.vo.UpdateProfileVO;

public class ProfileService {
	
	private SimpleDateFormat df =new SimpleDateFormat("dd/MM/yyyy");
	
	public UpdateProfileVO updateProfile(ProfileInDTO inDTO){
		ProfileDAO pDAO = new ProfileDAO();
		UpdateProfileVO cvo = new UpdateProfileVO();
		WorldCitiesDAO wcDAO = new WorldCitiesDAO();
		boolean flag = false;
		try {
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setCountry(inDTO.getCountry());
		addressDTO.setProvince(inDTO.getProvince());
		addressDTO.setCity(inDTO.getCity());
		CoordinateDTO cord=wcDAO.getCoordinateList(addressDTO);
		inDTO.setLatitude(""+cord.getLatitude());
		inDTO.setLongitude(""+cord.getLongitude());
		ParserJsonUtil geo = new ParserJsonUtil();
		AddressDTO tmp= geo.getAddress(inDTO.getLatitude(),inDTO.getLongitude());
		if(tmp != null){
			inDTO.setGoogleCountry(tmp.getCountry());
			inDTO.setGoogleProvince(tmp.getProvince());
			inDTO.setGoogleCity(tmp.getCity());
		}
		
		
			flag = pDAO.updateProfile(inDTO);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag){
			cvo.setNickname(inDTO.getNickname());
			cvo.setStatus("Y");
		}else{
			cvo.setStatus("N");
		}
		return cvo;
			
	}
	
	
	public void changePassword(){
		
	}
	
	public ProfileVO viewProfileByEmail(String email){
		ProfileDAO pDAO = new ProfileDAO();
		ProfileEntity profileEntity=pDAO.readProfile(email);
		ProfileVO profileVO = new ProfileVO();
		WorldCitiesDAO wcDAO = new WorldCitiesDAO();
		
		//GISDTO gis = new GISDTO();
		if(profileEntity!=null){
			profileVO.setStatus("Y");
			profileVO.setNickname(profileEntity.getNickname());
			profileVO.setUserid(profileEntity.getUserIntID());
			profileVO.setCountry(profileEntity.getCountry());
			profileVO.setProvince(profileEntity.getProvince());
			if(profileEntity.getDateOfBirth()!=null){
				profileVO.setDateOfBirth(df.format(profileEntity.getDateOfBirth()));
			}
			profileVO.setCity(profileEntity.getCity());
			profileVO.setEmail(profileEntity.getEmail());
			profileVO.setGender(profileEntity.getGender());
			profileVO.setSignature(profileEntity.getSignature());
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, -1);
			if(cal.getTime().after(profileEntity.getLastAddressUpdate())){
			//if(true){
				String[] countryArray =  wcDAO.getCountryList();
				profileVO.setCountryArray(countryArray);
				String[] provinceArray =  wcDAO.getProvinceList(profileEntity.getCountry());
				profileVO.setProvinceArray(provinceArray);
				String[] cityArray =  wcDAO.getCityList(profileEntity.getCountry(),profileEntity.getProvince());
				profileVO.setCityArray(cityArray);
				profileVO.setAddressFlag(true);
			} else {
				profileVO.setAddressFlag(false);
			}
			
		}else{
			profileVO.setStatus("N");
		}
		return profileVO;
	}

}
