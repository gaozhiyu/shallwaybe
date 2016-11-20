package com.william.test;

import org.junit.Test;

import com.william.DAO.FollowDAO;
import com.william.to.FollowInDTO;
import com.william.to.FollowOutDTO;

public class TestFollow {
	
	FollowDAO followDAO = new FollowDAO();
	FollowOutDTO[] followArray = null;
	FollowInDTO followInDTO = new FollowInDTO("94ab4fbd272b43d2beed7688345f5fa3","b53a45037c244371baaeb5e7af75aa90");
	
	@Test
	public void testAddFollow(){
		followDAO.addFollow(followInDTO);
	}

	@Test
	public void testReadFollow(){
		followArray = followDAO.readFollow("94ab4fbd272b43d2beed7688345f5fa3");
		
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
