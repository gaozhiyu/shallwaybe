package com.william.service.authenticate;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.william.DAO.ShallWayDAO;
import com.william.entity.ShallWayEntity;
import com.william.to.DateDTO;
import com.william.to.DateInDTO;
import com.william.to.DateOutDTO;
import com.william.to.ShallWayInDTO;
import com.william.vo.CreateDateOutVO;

public class DateService {
	
	private SimpleDateFormat df =new SimpleDateFormat("dd/MM/yyyy");

	public DateOutDTO retriveMyDate(DateInDTO dateInDTO){
		
		
		DateOutDTO outDto = new DateOutDTO();
		ShallWayDAO msw= new ShallWayDAO();
		ShallWayEntity[] shallwayArray = msw.readShallWay(dateInDTO.getUserid());
		DateDTO[] dateArray = null;
		if(shallwayArray!= null && shallwayArray.length>0){
			dateArray = new DateDTO[shallwayArray.length];
			for(int i = 0;i < shallwayArray.length; i++ ){
				dateArray[i]= new DateDTO();
				dateArray[i].setUserid(shallwayArray[i].getUserIntID());
				dateArray[i].setCity(shallwayArray[i].getCity());
				dateArray[i].setCountry(shallwayArray[i].getCountry());
				dateArray[i].setStarttime(df.format(shallwayArray[i].getStartTime()));
				dateArray[i].setEndtime(df.format(shallwayArray[i].getEndTime()));
				dateArray[i].setDateid(shallwayArray[i].getDateID());
				dateArray[i].setPlace(shallwayArray[i].getPlace());
				dateArray[i].setProvince(shallwayArray[i].getProvince());
				dateArray[i].setTitle(shallwayArray[i].getTitle());
			}
			outDto.setDateArray(dateArray);
			outDto.setStatus("Y");
		} else{
			outDto.setStatus("N");
		}
		
		

		return outDto;
	}
	
	public void searchDate(){
		
	}
	
	public CreateDateOutVO createDate(ShallWayInDTO inDTO){
		CreateDateOutVO output = new CreateDateOutVO();
		inDTO.setProvince(inDTO.getCity().substring(0, 1));//TODO change in future
		ShallWayDAO msw= new ShallWayDAO();
		try {
			msw.addShallWay(inDTO);
			output.setStatus("Y");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			output.setStatus("N");
		}
		return output;
	}

}
