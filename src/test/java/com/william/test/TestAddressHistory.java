package com.william.test;

import java.util.Date;

import org.junit.Test;

import com.william.DAO.AddressHistoryDAO;
import com.william.to.AddressHistoryInDTO;
import com.william.to.AddressHistoryOutDTO;

public class TestAddressHistory {
	
	AddressHistoryDAO addressHistoryDAO = AddressHistoryDAO.getInstance() ;
    AddressHistoryOutDTO[] AddressHistoryArray = null;
    AddressHistoryInDTO addressHistory = new AddressHistoryInDTO("07d407cf02154d8f814c099cb0301c16","Singapore","Jurong West","NTU","B");
    
	
	@Test
	public void testAddAddressHistory(){
		addressHistoryDAO.addAddressHistory(addressHistory);
	}
	
	@Test
	public void testReadAddressHistory(){
        AddressHistoryArray=addressHistoryDAO.readAddressHistory("07d407cf02154d8f814c099cb0301c16","B");   
        
        for (int i=0; i<AddressHistoryArray.length;i++){
        	System.out.println("Record No." + (i+1));
        	System.out.println("\tAddressSequenceID: "+AddressHistoryArray[i].getAddressSequenceID()); 
        	System.out.println("\tCountry: "+AddressHistoryArray[i].getCountry());  
        	System.out.println("\tProvince: "+AddressHistoryArray[i].getProvince()); 
        	System.out.println("\tCity: "+AddressHistoryArray[i].getCity()); 
        	System.out.println("\tUpdateTime: "+AddressHistoryArray[i].getUpdateTime());  
        }      
	}
}
