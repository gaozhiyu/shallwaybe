package com.william.to;

import java.util.Date;
import java.util.regex.Pattern;

public class ReplyInDTO {
	
	private String dateID;
    private String replierIntID;
	private String replyContents;
	
	public ReplyInDTO() {
		super();
	}

	public ReplyInDTO(String dateID, String replierIntID, String replyContents) {
		super();
		this.dateID = dateID;
		this.replierIntID = replierIntID;
		this.replyContents = replyContents;
	}

	public String getDateID() {
		return dateID;
	}

	public void setDateID(String dateID) {
		this.dateID = dateID;
	}

	public String getReplierIntID() {
		return replierIntID;
	}

	public void setReplierIntID(String replierIntID) {
		this.replierIntID = replierIntID;
	}

	public String getReplyContents() {
		return replyContents;
	}

	public void setReplyContents(String replyContents) {
		this.replyContents = replyContents;
	}
		
	
	public boolean isValid(){

		StringBuilder sb = new StringBuilder();
		boolean inputValid = true;
		
		String userIntIDString ="^[0-9a-zA-Z]+$";
    	boolean dateIDMatch = Pattern.matches(userIntIDString, dateID);
    	if (dateIDMatch == false){
    		sb.append("\ndateID is not valid!");
    		inputValid =false;
    	}
    	
    	boolean userIntIDMatch = Pattern.matches(userIntIDString, replierIntID);
    	if (userIntIDMatch == false){
    		sb.append("\nreplierIntID is not valid!");
    		inputValid =false;
    	}
    	
    	return inputValid;
	}
}
