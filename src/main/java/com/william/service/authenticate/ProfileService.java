package com.william.service.authenticate;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.william.DAO.ProfileDAO;
import com.william.entity.ProfileEntity;
import com.william.to.ProfileInDTO;
import com.william.vo.ProfileVO;
import com.william.vo.UpdateProfileVO;

public class ProfileService {
	
	private SimpleDateFormat df =new SimpleDateFormat("dd/MM/yyyy");
	
	public UpdateProfileVO updateProfile(ProfileInDTO inDTO){
		ProfileDAO pDAO = new ProfileDAO();
		UpdateProfileVO cvo = new UpdateProfileVO();
		boolean flag = false;
		try {
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
	
	public ProfileVO viewProfileByEmail(ProfileInDTO inDTO){
		ProfileDAO pDAO = new ProfileDAO();
		ProfileEntity profileEntity=pDAO.readProfile(inDTO.getEmail());
		ProfileVO profileVO = new ProfileVO();
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
		}else{
			profileVO.setStatus("N");
		}
		return profileVO;
	}

}
