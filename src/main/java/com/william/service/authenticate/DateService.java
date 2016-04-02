package com.william.service.authenticate;

import com.william.to.DateDTO;
import com.william.to.DateInDTO;
import com.william.to.DateOutDTO;

public class DateService {

	public DateOutDTO retriveMyDate(DateInDTO dateInDTO){
		DateDTO[] dateArray = new DateDTO[5];
		for(int i = 0;i<5;i++){
			DateDTO tmp = new DateDTO();
			tmp.setShallwayID("Date"+i);
			dateArray[i]= tmp;
		}
		DateOutDTO outDto = new DateOutDTO();
		outDto.setDateArray(dateArray);
		outDto.setStatus("Y");
		return outDto;
	}
	
	public void searchDate(){
		
	}
	
	public void createDate(){
		
	}

}
