package com.spring.test01.member.vo;

public class GuestBookVO {

	private String id;
	private String guestID;
	private String message;
	private String role;
	private String classColor;
	

	public GuestBookVO() {
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getGuestID() {
		return guestID;
	}


	public void setGuestID(String guestID) {
		this.guestID = guestID;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getClassColor() {
		return classColor;
	}


	public void setClassColor(String classColor) {
		this.classColor = classColor;
	}


	public GuestBookVO(String id, String guestID, String message, String role, String classColor) {
		
		this.id = id;
		this.guestID = guestID;
		this.message = message;
		this.role = role;
		this.classColor = classColor;
	}
	
	
	
	
}
