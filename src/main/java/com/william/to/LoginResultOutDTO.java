package com.william.to;

import com.william.vo.CommonVO;

public class LoginResultOutDTO extends CommonVO{

		// TODO Auto-generated method stub
	String sessionID;
	String username;
	String nickname;
	private byte[] profilePhoto;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public byte[] getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(byte[] profilePhoto) {
		this.profilePhoto = profilePhoto;
	}
		
	

}
