package com.william.test;

import org.junit.Test;

import com.william.DAO.BlackListDAO;
import com.william.to.BlackListInDTO;
import com.william.to.BlackListOutDTO;


public class TestBlackList {
	
	BlackListDAO blackListDAO = new BlackListDAO();
	BlackListOutDTO[] blackListArray = null;
	BlackListInDTO blackListInDTO = new BlackListInDTO("29ec271d483b4930a28ceb5c2adce59a","0b2a583f6ff042168a2bc63f35c9b63b");
	boolean flag =false;

	@Test
	public void testAddBlackList(){
		blackListDAO.addBlackList(blackListInDTO);
		
	}
	
	@Test
	public void testReadBlackList(){
		blackListArray = blackListDAO.readBlackList("07d407cf02154d8f814c099cb0301c16");
		
		for(int i=0; i<blackListArray.length;i++){
			System.out.println();
			System.out.println("EntryID: "+blackListArray[i].getEntryID());
			System.out.println("\tUserIntID: "+blackListArray[i].getUserIntID());
			System.out.println("\tBlockUserIntID: "+blackListArray[i].getBlockUserIntID());
			System.out.println("\tBlockUserNickname: " + blackListArray[i].getBlockUserNickname());
			
			System.out.println("\tDeleteStatus: "+blackListArray[i].getDeleteStatus());
			System.out.println("\tUpdateTime: "+blackListArray[i].getUpdateTime());
		}
		
	}
	
	@Test
	public void testReadMyBlackList(){
		
		flag=blackListDAO.readBlackList("07d407cf02154d8f814c099cb0301c16", "c83c744d00e64d459ad56b5894b6a646");
		System.out.println("\tThe checked user is in my blacklist: "+flag);
		
	}
	
	@Test
	public void testDeleteStatus(){
		blackListDAO.deleteBlackList("07d407cf02154d8f814c099cb0301c16", "c83c744d00e64d459ad56b5894b6a646");
	}
	
	@Test
	public void testUpdateStatus(){
		blackListDAO.updateBlackList("07d407cf02154d8f814c099cb0301c16", "c83c744d00e64d459ad56b5894b6a646");
	}
}
