package com.Invoice.Response;

public class LoginResponse {
	private boolean success;
	private String token;
	private String username;
	private String email;
	private String phonenum;
	private String state;
	private Long userid;
	private String profileurl;
	private String name;

	public LoginResponse(boolean success, String token, String username, String email, String phonenum, String state,
			Long userid, String profileurl, String name) {
		this.success = success;
		this.token = token;
		this.username = username;
		this.email = email;
		this.phonenum = phonenum;
		this.state = state;
		this.userid = userid;
		this.profileurl = profileurl;
		this.name = name;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getProfileurl() {
		return profileurl;
	}

	public void setProfileurl(String profileurl) {
		this.profileurl = profileurl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
