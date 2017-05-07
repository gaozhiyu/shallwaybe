package com.william.service.authenticate;

import com.william.DAO.BlackListDAO;
import com.william.to.BlackListInDTO;
import com.william.to.BlackListOutDTO;
import com.william.vo.BlackListVO;
import com.william.vo.CommonInput;
import com.william.vo.CommonVO;

public class SettingService {

	public BlackListVO retrieveBlackList(CommonInput input){
		BlackListDAO bLDAO = BlackListDAO.getInstance();
		BlackListVO blVO = new BlackListVO();
		BlackListOutDTO[] blList = bLDAO.readBlackList(input.getUserIntID());
		if(blList!= null && blList.length>0){
			blVO.setStatus("Y");
			blVO.setBlArray(blList);
		}
		return blVO;
	}
	
	
	public CommonVO deleteBL(BlackListInDTO bbDTO){
		BlackListDAO bLDAO = BlackListDAO.getInstance();
		bLDAO.deleteBlackList(bbDTO.getUserIntID(), bbDTO.getBlockUserIntID());
		CommonVO cvo = new CommonVO();
		cvo.setStatus("Y");
		return cvo;
	}
}
