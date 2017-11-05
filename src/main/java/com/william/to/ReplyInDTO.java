package com.william.to;

import java.util.Date;
import java.util.regex.Pattern;

public class ReplyInDTO {
	
	private String dateID;
	// The guy post the message
	private String mainUserIntID;
	// The replyid coming from the first reply of replyblock 
	private String srcReplyID;
	// The userid of the reply coming from the first reply of replyblock
	private String sourceUserIntID;
	// the id for each replyer
    private String replierIntID;
	private String replyContents;
	
	public ReplyInDTO() {
		super();
	}

	public ReplyInDTO(String dateID, String mainUserIntID, String srcReplyID, String sourceUserIntID,
			String replierIntID, String replyContents) {
		super();
		this.dateID = dateID;
		this.mainUserIntID = mainUserIntID;
		this.srcReplyID = srcReplyID;
		this.sourceUserIntID = sourceUserIntID;
		this.replierIntID = replierIntID;
		this.replyContents = replyContents;
	}


	public String getDateID() {
		return dateID;
	}

	public void setDateID(String dateID) {
		this.dateID = dateID;
	}

	public String getMainUserIntID() {
		return mainUserIntID;
	}

	public void setMainUserIntID(String mainUserIntID) {
		this.mainUserIntID = mainUserIntID;
	}

	public String getSrcReplyID() {
		return srcReplyID;
	}

	public void setSrcReplyID(String srcReplyID) {
		this.srcReplyID = srcReplyID;
	}
	
	public String getSourceUserIntID() {
		return sourceUserIntID;
	}

	public void setSourceUserIntID(String sourceUserIntID) {
		this.sourceUserIntID = sourceUserIntID;
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
    	
    	boolean srcReplyIDMatch = Pattern.matches(userIntIDString, sourceUserIntID);
    	if (srcReplyIDMatch == false){
    		sb.append("\nsourceUserIntID is not valid!");
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
