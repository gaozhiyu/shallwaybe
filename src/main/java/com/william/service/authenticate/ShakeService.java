package com.william.service.authenticate;

import com.william.DAO.ProfileDAO;
import com.william.DAO.ShakeDAO;
import com.william.entity.ProfileEntity;
import com.william.to.AddressDTO;
import com.william.to.ShakeDTO;
import com.william.to.ShakeInDTO;
import com.william.to.ShakeOutDTO;
import com.william.util.MessageQueue;
import com.william.util.ParserJsonUtil;

public class ShakeService {

	public ShakeOutDTO shakeForPpList(ShakeInDTO shakeInDTO){
		
		ShakeDTO[] shakeList = null;
		ShakeDAO dao = ShakeDAO.getInstance();
		ShakeOutDTO shakeDTO = new ShakeOutDTO();
		if(shakeInDTO.getShakeType()==0){
			ParserJsonUtil geo = new ParserJsonUtil();
			AddressDTO tmp = geo.getAddress(shakeInDTO.getLatitude(), shakeInDTO.getLongitude());
			//ProfileEntity profileEnity =ProfileDAO.getInstance().readProfileByID(shakeInDTO.getUserIntID());
			shakeList = dao.shakeForUnknownList(shakeInDTO,tmp.getCountry(),tmp.getProvince(),tmp.getCity());
		} else {
			shakeList = dao.shakeForList(shakeInDTO);
		}
		if(shakeList!=null){
			shakeDTO.setShakeArray(shakeList);
			shakeDTO.setStatus("Y");
		} else {
			shakeDTO.setStatus("N");
		}
		//shakeDTO.setStatus("Y");
		MessageQueue.getInstance().postMessage(shakeInDTO);
		return shakeDTO;
		
	}

}
