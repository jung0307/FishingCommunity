package com.spring.test01.member.vo;

import org.springframework.stereotype.Component;

@Component("memberVO")
public class MemberVO {

	private String id;
	private String pwd;
	private String role;
	private String signUpDate;
	
	public MemberVO() {
		// TODO Auto-generated constructor stub
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSignUpDate() {
		return signUpDate;
	}

	public void setSignUpDate(String signUpDate) {
		this.signUpDate = signUpDate;
	}

	public MemberVO(String id, String pwd, String role, String signUpDate) {
	
		this.id = id;
		this.pwd = pwd;
		this.role = role;
		this.signUpDate = signUpDate;
	}




	
	
}
