package com.test.mink.model;

public class Dummy {
	private int seq;
	private String content;

	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Dummy [seq=" + seq + ", content=" + content + "]";
	}
}
