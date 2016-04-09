package com.william.to;

public class LoginResultOutDTO extends CommonDTO{

		// TODO Auto-generated method stub
	String sessionID;
	String userIntID;
	String nickname;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUserIntID() {
		return userIntID;
	}

	public void setUserIntID(String userIntID) {
		this.userIntID = userIntID;
	}

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
		
	

}
