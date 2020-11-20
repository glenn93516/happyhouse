package com.ssafy.happyhouse.repository.dto;

public class MemberDto {
	private String userid;
	private String userpw;
	private String username;
	private String useremail;
	private String userphone;
	private int role; //회원0 관리자1
	
	public MemberDto() {}
	
	public MemberDto(String userid, String userpw, String username, String useremail, String userphone) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.useremail = useremail;
		this.userphone = userphone;
	}
	
	public MemberDto(String userid, String userpw, String username, String useremail, String userphone, int role) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.useremail = useremail;
		this.userphone = userphone;
		this.role = role;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	public int getRole() {
		return role;
	}
	public void setRoll(int role) {
		this.role = role;
	}
}
