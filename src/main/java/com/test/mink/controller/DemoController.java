package com.test.mink.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.mink.model.Dummy;
import com.test.mink.model.DummyForm;
import com.test.mink.service.DummyService;

@RequestMapping(value="/demo")
@Controller
public class DemoController {
	@Autowired
	DummyService dummyService;
	
	@RequestMapping(value="searchDummyList", method=RequestMethod.POST)
	@ResponseBody
	public DummyForm searchDummyList() throws Exception {
		System.out.println("################# searchDummyList");
		List<Dummy> dummyList = dummyService.searchDummyList();
		
		for(Dummy dummy : dummyList) {
			System.out.println(dummy);
		}
		
		DummyForm dummyForm = new DummyForm();
		dummyForm.setDummyList(dummyList);
		
		return dummyForm;
	}
	
}
