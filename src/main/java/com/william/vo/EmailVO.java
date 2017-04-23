package com.william.vo;

public class EmailVO {
	public final String fromEmail = "admin@shall-way.com";
	private String toEmail;
	private String subject;
	private String body;
	
	
	public String getToEmail() {
		return toEmail;
	}
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public EmailVO(String toEmail, String subject, String body) {
		super();
		this.toEmail = toEmail;
		this.subject = subject;
		this.body = body;
	}
	
	public EmailVO() {
	}
	
	

}
