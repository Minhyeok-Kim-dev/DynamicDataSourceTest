package com.test.mink.model;

public class LoginForm {
	private String id;
	private String pwd;

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
	@Override
	public String toString() {
		return "LoginForm [id=" + id + ", pwd=" + pwd + "]";
	}
}
