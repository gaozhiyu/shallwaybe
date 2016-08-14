package com.william.service.authenticate;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.william.DAO.ShallWayDAO;
import com.william.DAO.WorldCitiesDAO;
import com.william.entity.ShallWayEntity;
import com.william.to.DateDTO;
import com.william.to.DateInDTO;
import com.william.to.DateOutDTO;
import com.william.to.ShallWayInDTO;
import com.william.to.ShallWayOutDTO;
import com.william.to.ShallWaySearchDTO;
import com.william.to.ShallWayUpdateDTO;
import com.william.to.ShallWayValidation;
import com.william.vo.CommonVO;
import com.william.vo.CreateDateOutVO;

public class DateService {
	
	private SimpleDateFormat df =new SimpleDateFormat("dd/MM/yyyy");

	public DateOutDTO retriveMyDate(DateInDTO dateInDTO){
		
		
		DateOutDTO outDto = new DateOutDTO();
		ShallWayDAO msw= ShallWayDAO.getInstance();
		ShallWayEntity[] shallwayArray = msw.readShallWay(dateInDTO.getUserIntID(),Integer.parseInt(dateInDTO.getPage()));
		DateDTO[] dateArray = null;
		if(shallwayArray!= null && shallwayArray.length>0){
			dateArray = new DateDTO[shallwayArray.length];
			for(int i = 0;i < shallwayArray.length; i++ ){
				dateArray[i]= new DateDTO();
				dateArray[i].setUserIntID(shallwayArray[i].getUserIntID());
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
	
	public DateOutDTO searchDate(ShallWaySearchDTO inDTO) throws SQLException{
		DateOutDTO outDto = new DateOutDTO();
		ShallWayDAO msw= ShallWayDAO.getInstance();
		DateDTO[] dateArray = null;
		try {
//ToWilliam: 	ShallWayOutDTO[] shallwayArray = msw.readShallWay(inDTO,1) change to ShallWayOutDTO[] shallwayArray = msw.readShallWay(inDTO); page number should be included in FE.
			ShallWayOutDTO[] shallwayArray = msw.readShallWay(inDTO);
			if(shallwayArray!= null && shallwayArray.length>0){
				dateArray = new DateDTO[shallwayArray.length];
				for(int i = 0;i < shallwayArray.length; i++ ){
					dateArray[i]= new DateDTO();
					dateArray[i].setUserIntID(shallwayArray[i].getUserIntID());
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
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outDto;
	}
	
	public CreateDateOutVO createDate(ShallWayInDTO inDTO){
		CreateDateOutVO output = new CreateDateOutVO();
		//inDTO.setProvince(inDTO.getCity().substring(0, 1));//TODO change in future
		ShallWayDAO msw= ShallWayDAO.getInstance();
		ShallWayValidation shallWayValidation= null;
		
		try {
		/*
		 * Object return = inDTO.isvalid();//return has two attrbute, validresult && errormsg
		 * if(return.isValid())
		 */
			shallWayValidation = inDTO.isValid();
			if(!shallWayValidation.isResultValid()){
				output.setStatus("N");
				output.setReason(shallWayValidation.getResultString());
				return output;
			}
			msw.addShallWay(inDTO);
			output.setStatus("Y");
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			output.setStatus("N");
		}
		return output;
	}
	
	
	public ShallWayOutDTO viewDate(DateInDTO inDTO) throws SQLException{
		
		//inDTO.setProvince(inDTO.getCity().substring(0, 1));//TODO change in future
		ShallWayDAO msw= ShallWayDAO.getInstance();
		ShallWayOutDTO dateVO=msw.retrieveDateByDateID(inDTO.getDateid());
		WorldCitiesDAO wcDAO = WorldCitiesDAO.getInstance();
		String[] countryArray =  wcDAO.getCountryList();
		dateVO.setCountryArray(countryArray);
		String[] provinceArray =  wcDAO.getProvinceList(dateVO.getCountry());
		dateVO.setProvinceArray(provinceArray);
		String[] cityArray =  wcDAO.getCityList(dateVO.getCountry(),dateVO.getProvince());
		dateVO.setCityArray(cityArray);
		dateVO.setStartTimeStr(df.format(dateVO.getStartTime()));
		dateVO.setEndTimeStr(df.format(dateVO.getEndTime()));
		
		
		if(dateVO != null){
			dateVO.setStatus("Y");
		}else{
			dateVO.setStatus("N");
		}
		
		return dateVO;
	}
	
	public CommonVO updateDate (ShallWayUpdateDTO shallWayUpdateDTO){
		ShallWayDAO msw= ShallWayDAO.getInstance();	
		CommonVO output =new CommonVO();
		ShallWayValidation shallWayValidation= null;
		try {
			
			shallWayValidation = shallWayUpdateDTO.isValid();
			if (!shallWayValidation.isResultValid()){
				output.setReason(shallWayValidation.getResultString());
				output.setStatus("N");
				return output;
			}
			
			boolean flag=msw.updateShallWay(shallWayUpdateDTO);
			if(flag)
				output.setStatus("Y");
			else 
				output.setStatus("N");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			output.setStatus("N");
		}
		return output;
	
	}

}
