package com.william.test;

import com.william.DAO.FollowDAO;
import com.william.to.FollowInDTO;
import com.william.to.FollowOutDTO;

public class FollowApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FollowDAO followDAO = new FollowDAO();
		FollowOutDTO[] followArray = null;
		
		FollowInDTO followInDTO = new FollowInDTO("5b3ad3653abf47729f5147405e16bead","981e630a59964937a006d320d2d097df");
		
		followDAO.addFollow(followInDTO);
		followArray = followDAO.readFollow("5b3ad3653abf47729f5147405e16bead");
		
		for(int i=0; i<followArray.length;i++){
			System.out.println();
			System.out.println("ID: "+followArray[i].getId());
			System.out.println("\tDateID: "+followArray[i].getDateID());
			System.out.println("\tFollowerIntID: "+followArray[i].getFollowerIntID());
			System.out.println("\tFollowerNickname: " + followArray[i].getFollowerNickname());
			System.out.println("\tFollowTime: "+followArray[i].getFollowTime());
		}
		
//		followDAO.deleteFollow("f483ce4efca14d8bbf96a5f8b66327af");

	}

}
