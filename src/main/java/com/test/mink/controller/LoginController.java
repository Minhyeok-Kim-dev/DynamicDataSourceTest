package com.test.mink.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.GeneratorStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.mink.common.SessionUtil;
import com.test.mink.model.LoginForm;
import com.test.mink.service.LoginService;

@Controller
@RequestMapping(value="/")
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(LoginForm loginForm) throws Exception {
		System.out.println("############ login");
		System.out.println(loginForm);
		
		loginService.login(loginForm);
		
		if(SessionUtil.getAttribute("dataSource") == null) {
			return "redirect:/login";
		}
		
		return "main";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout() throws Exception {
		SessionUtil.setAttribute("dataSource", null);
		return "redirect:/login";
	}
}
