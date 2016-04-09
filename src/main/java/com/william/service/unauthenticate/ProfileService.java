package com.william.service.unauthenticate;

import com.william.DAO.ProfileDAO;
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
}
