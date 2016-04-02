package com.william.service.authenticate;

import com.william.to.ShakeDTO;
import com.william.to.ShakeInDTO;
import com.william.to.ShakeOutDTO;

public class ShakeService {

	public ShakeOutDTO shakeForPpList(ShakeInDTO shakeInDTO){
		
		ShakeDTO[] shakeList = new ShakeDTO[2];
		shakeList[0]= new ShakeDTO("bar1","12","12:13");
		shakeList[1]= new ShakeDTO("bar2","12","12:13");
		ShakeOutDTO shakeDTO = new ShakeOutDTO();
		shakeDTO.setShakeArray(shakeList);
		shakeDTO.setStatus("Y");
		return shakeDTO;
		
	}

}
