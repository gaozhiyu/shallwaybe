package com.william.listener;

import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.junit.Test;

import com.william.DAO.AddressHistoryDAO;
import com.william.DAO.LatestCoordinateDAO;
import com.william.DAO.MessageDAO;
import com.william.filter.LogFile;
import com.william.to.AddressDTO;
import com.william.to.AddressHistoryInDTO;
import com.william.to.LatestCoordinateInDTO;
import com.william.to.MessageInDTO;
import com.william.to.ShakeInDTO;
import com.william.util.ChatMessageQueue;
import com.william.util.MessageQueue;
import com.william.util.ParserJsonUtil;



public class ContextListener implements ServletContextListener {


	@SuppressWarnings("deprecation")
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Current Thread initialized");
		

		MessageQueue.getInstance().setListener(
				new MessageQueue.MessageListener() {
					
					//Detail logic message process
					public void onMessage(ShakeInDTO msg) throws Exception {
						//cgc.processGameLogic(msg);
						System.out.println("PrintedByWilliam"+msg.toString());
						ParserJsonUtil geo = new ParserJsonUtil();
						AddressDTO address = geo.getAddress(msg.getLatitude(),msg.getLongitude());
						LatestCoordinateInDTO cordDTO = new LatestCoordinateInDTO();
						//TODO add the validation
						cordDTO.setUserIntID(msg.getUserIntID());
						cordDTO.setLatitude(msg.getLatitude());
						cordDTO.setLongitude(msg.getLongitude());
						cordDTO.setCountry(address.getCountry());
						//TODO Enable the null value
						if(address.getProvince()==null || "".equals(address.getProvince()))
							cordDTO.setProvince(address.getCountry());
						else 
							cordDTO.setProvince(address.getProvince());
						if(address.getCity()==null || "".equals(address.getCity()))
							cordDTO.setCity(cordDTO.getProvince());
						else 
							cordDTO.setCity(address.getCity());

						
						//cordDTO.setCountry(address.getCountry());
						LatestCoordinateDAO mlcDAO = new LatestCoordinateDAO();
/*
						if(!msg.getUserid().equals(mlcDAO.readLatestCoordinate(msg.getUserid()).getUserIntID())){
							mlcDAO.addLatestCoordinate(cordDTO);
						} else{
							mlcDAO.updateLatestCoordinate(cordDTO);
						}
	*/					
						mlcDAO.saveOrUpdateLatestCoordinate(cordDTO);
	
						AddressHistoryDAO ahDAO = AddressHistoryDAO.getInstance();
						AddressHistoryInDTO addressTo = new AddressHistoryInDTO();
						addressTo.setUserIntID(msg.getUserIntID());
						addressTo.setCity(cordDTO.getCity());
						addressTo.setProvince(cordDTO.getProvince());
						addressTo.setCountry(cordDTO.getCountry());
						addressTo.setPlaceType("B");
						ahDAO.addAddressHistory(addressTo);
					}
				});
		
		ChatMessageQueue.getInstance().setListener(
				new ChatMessageQueue.MessageListener() {

					@Override
					public void onMessage(LogFile msg) throws Exception {
						// TODO Auto-generated method stub
						System.out.println("PrintedByWilliam"+msg.toString());
						MessageInDTO messageInDTO = new MessageInDTO(msg.getLine(),msg.getFromID(),msg.getFromNickname(),msg.getToID());
						MessageDAO messageDAO = new MessageDAO();
						messageDAO.addMessage(messageInDTO);
					}
		});
		
		
	}

}