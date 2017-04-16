package com.william.to;

public class BlackListInDTO {

	private String userIntID;
    private String blockUserIntID;
    
	public BlackListInDTO() {
		super();
	}

	public BlackListInDTO(String userIntID, String blockUserIntID) {
		super();
		this.userIntID = userIntID;
		this.blockUserIntID = blockUserIntID;
	}

	public String getUserIntID() {
		return userIntID;
	}

	public void setUserIntID(String userIntID) {
		this.userIntID = userIntID;
	}

	public String getBlockUserIntID() {
		return blockUserIntID;
	}

	public void setBlockUserIntID(String blockUserIntID) {
		this.blockUserIntID = blockUserIntID;
	}
	
}
