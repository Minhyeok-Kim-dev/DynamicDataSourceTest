package com.test.mink.model;

public class UserInfo {
	private String id;
	private String pwd;
	private String orderCompCd;

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
	public String getOrderCompCd() {
		return orderCompCd;
	}
	public void setOrderCompCd(String orderCompCd) {
		this.orderCompCd = orderCompCd;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", pwd=" + pwd + ", orderCompCd=" + orderCompCd + "]";
	}
}
