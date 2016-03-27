package com.william.service.unauthenticate;

import com.william.DAO.ProfileDAO;
import com.william.to.RegisterInDTO;
import com.william.to.RegisterOutDTO;

public class ProfileService {
	
	public RegisterOutDTO register(RegisterInDTO inDTO){
		ProfileDAO mgDAO = new ProfileDAO();
		RegisterOutDTO outDTO = mgDAO.addProfile(inDTO);
		return outDTO;
	}

}
