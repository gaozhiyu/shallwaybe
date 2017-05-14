package com.william.test;

import java.sql.SQLException;

import org.junit.Test;

import com.william.DAO.FollowDAO;
import com.william.DAO.MyFollowDAO;
import com.william.entity.FollowEntity;
import com.william.to.FollowInDTO;
import com.william.to.FollowOutDTO;
import com.william.to.ShallWayOutDTO;

public class TestMyFollow {
	
	FollowEntity followEntity = null;
	MyFollowDAO followDAO = new MyFollowDAO();
	ShallWayOutDTO[] followArray = null;
	FollowInDTO followInDTO = new FollowInDTO("807d4160db5c4822990d1047753515d2","dab4dbe204294a368fc3c30cb7f479a3");
	boolean following =false;
	
	@Test
	public void testAddMyFollow(){
		followDAO.addMyFollow(followInDTO);
	}

	@Test
	public void testReadMyFollowList() throws SQLException{
		followArray = followDAO.readMyFollowList("dab4dbe204294a368fc3c30cb7f479a3");
		
		for(int i=0; i<followArray.length;i++){
			System.out.println();
//			System.out.println("ID: "+followArray[i].getId());
			System.out.println("\tDateID: "+followArray[i].getDateID());
//			System.out.println("\tFollowerIntID: "+followArray[i].getFollowerIntID());
			System.out.println("\tFollowerNickname: " + followArray[i].getNickname());
//			System.out.println("\tFollowTime: "+followArray[i].getFollowTime());
//			System.out.println("\tDeleteStatus: "+followArray[i].getDeleteStatus());
		}
	}
	
	@Test
	public void testReadIfFollow(){
		followEntity =followDAO.readMyFollowStatus(followInDTO);
		System.out.println("Verify the dateID: "+followEntity.getDateID());
//		System.out.println("Check if I followed this ShallWay record before: "+followEntity.getDeleteStatus());
		
	}
	
	@Test
	public void testUpdateOrDeleteFollow(){
		followDAO.updateFollow(followInDTO, false);
	}
}
