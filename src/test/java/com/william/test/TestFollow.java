package com.william.test;

import org.junit.Test;

import com.william.DAO.FollowDAO;
import com.william.entity.FollowEntity;
import com.william.to.FollowInDTO;
import com.william.to.FollowOutDTO;

public class TestFollow {
	
	FollowEntity followEntity = null;
	FollowDAO followDAO = new FollowDAO();
	FollowOutDTO[] followArray = null;
	FollowInDTO followInDTO = new FollowInDTO("807d4160db5c4822990d1047753515d2","dab4dbe204294a368fc3c30cb7f479a3");
	boolean flag= false;
	String followID;
	
	@Test
	public void testAddFollow(){
		followID = followDAO.addFollow(followInDTO);
		System.out.println("Follow"+followID);
	}

	@Test
	public void testReadFollow(){
		followArray = followDAO.readFollow("807d4160db5c4822990d1047753515d2");
		
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
	public void testReadIfFollow(){
		followEntity =followDAO.readFollow(followInDTO);
		System.out.println("Verify the dateID: "+followEntity.getDateID());
//		System.out.println("Check if I followed this ShallWay record before: "+followEntity.getDeleteStatus());
		
	}
	
	
	@Test
	public void testUpdateOrDeleteFollow(){
		followDAO.updateFollow(followInDTO, false);
	}
}
