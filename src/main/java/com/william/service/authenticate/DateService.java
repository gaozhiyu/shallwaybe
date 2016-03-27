package com.william.service.authenticate;

import com.william.to.DateInDTO;
import com.william.to.DateOutDTO;

public class DateService {

	public DateOutDTO[] retriveMyDate(DateInDTO dateInDTO){
		DateOutDTO[] dateArray = new DateOutDTO[5];
		for(int i = 0;i<5;i++){
			DateOutDTO tmp = new DateOutDTO();
			tmp.setShallwayID("Date"+i);
			dateArray[i]= tmp;
		}
		
		return dateArray;
	}

}
