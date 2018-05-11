package com.test.mink.model;

import java.util.List;

public class DummyForm {
	List<Dummy> dummyList;

	public List<Dummy> getDummyList() {
		return dummyList;
	}

	public void setDummyList(List<Dummy> dummyList) {
		this.dummyList = dummyList;
	}

	@Override
	public String toString() {
		return "DummyForm [dummyList=" + dummyList + "]";
	}

}
