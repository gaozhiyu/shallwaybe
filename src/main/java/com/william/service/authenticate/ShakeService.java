package com.william.service.authenticate;

import com.william.to.ShakeInDTO;
import com.william.to.ShakeOutDTO;

public class ShakeService {

	public ShakeOutDTO[] shakeForPpList(ShakeInDTO shakeInDTO){
		
		ShakeOutDTO[] shakeList = new ShakeOutDTO[2];
		shakeList[0]= new ShakeOutDTO("bar1","12","12:13");
		shakeList[1]= new ShakeOutDTO("bar2","12","12:13");
		return shakeList;
		
	}

}
