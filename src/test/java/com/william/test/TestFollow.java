package com.william.test;

import org.junit.Test;

import com.william.DAO.FollowDAO;
import com.william.to.FollowInDTO;
import com.william.to.FollowOutDTO;

public class TestFollow {
	
	FollowDAO followDAO = new FollowDAO();
	FollowOutDTO[] followArray = null;
	FollowInDTO followInDTO = new FollowInDTO("9d1472c02617443fa558a0e5b90c4007","3f46187fd7904aedb59537d6288e052f");
	
	@Test
	public void testAddFollow(){
		followDAO.addFollow(followInDTO);
	}

	@Test
	public void testReadFollow(){
		followArray = followDAO.readFollow("9d1472c02617443fa558a0e5b90c4007");
		
		for(int i=0; i<followArray.length;i++){
			System.out.println();
			System.out.println("ID: "+followArray[i].getId());
			System.out.println("\tDateID: "+followArray[i].getDateID());
			System.out.println("\tFollowerIntID: "+followArray[i].getFollowerIntID());
			System.out.println("\tFollowerNickname: " + followArray[i].getFollowerNickname());
			System.out.println("\tFollowTime: "+followArray[i].getFollowTime());
			System.out.println("\tDeleteStatus: "+followArray[i].getDeleteStatus());
		}
	}
	
	@Test
	public void testDeleteFollow(){
		followDAO.deleteFollow("3b3a38d89c564428a47d75c33f79dcb0");
	}
}
