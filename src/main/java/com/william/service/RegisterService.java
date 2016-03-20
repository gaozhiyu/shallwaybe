package com.william.service;

import com.william.DAO.ProfileDAO;
import com.william.to.RegisterInDTO;
import com.william.to.RegisterOutDTO;

public class RegisterService {
	
	public RegisterOutDTO register(RegisterInDTO inDTO){
		ProfileDAO mgDAO = new ProfileDAO();
		RegisterOutDTO outDTO = mgDAO.addProfile(inDTO);
		return outDTO;
	}

}
