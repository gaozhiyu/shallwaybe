package com.william.filter;

public class LogFile {

    private String line;
    
    private String toID;
    
    private String fromID;
    private String fromNickname;

	public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

	public String getFromNickname() {
		return fromNickname;
	}

	public void setFromNickname(String fromNickname) {
		this.fromNickname = fromNickname;
	}

	public String getToID() {
		return toID;
	}

	public void setToID(String toID) {
		this.toID = toID;
	}

	public String getFromID() {
		return fromID;
	}

	public void setFromID(String fromID) {
		this.fromID = fromID;
	}
    
    
}
