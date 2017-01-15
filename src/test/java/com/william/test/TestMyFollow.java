package com.william.test;

import java.sql.SQLException;

import org.junit.Test;

import com.william.DAO.FollowDAO;
import com.william.DAO.MyFollowDAO;
import com.william.to.FollowInDTO;
import com.william.to.FollowOutDTO;
import com.william.to.ShallWayOutDTO;

public class TestMyFollow {
	
	MyFollowDAO followDAO = new MyFollowDAO();
	ShallWayOutDTO[] followArray = null;
	FollowInDTO followInDTO = new FollowInDTO("f1a2b86dc4fc4175bacfc7317dbd8a15","b53a45037c244371baaeb5e7af75aa90");
	boolean following =false;
	
	@Test
	public void testAddMyFollow(){
		followDAO.addMyFollow(followInDTO);
	}

	@Test
	public void testReadMyFollowList() throws SQLException{
		followArray = followDAO.readMyFollowList("b53a45037c244371baaeb5e7af75aa90");
		
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
	public void testReadMyFollowStatus(){
		following = followDAO.readMyFollowStatus(followInDTO);
		
		System.out.println(following);
	}
	
	@Test
	public void testDeleteMyFollow(){
		followDAO.deleteMyFollow(followInDTO);
	}
}
