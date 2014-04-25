package com.noq.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.noq.domain.User;
import com.noq.service.AuthenticationService;

@Controller


public class AuthenticationController {

	@Autowired
	AuthenticationService authService;
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String userName,
			@RequestParam("password") String password,HttpSession session) {
		ModelAndView modelView = new ModelAndView();
		System.out.println("in login service");
		//Map<String, Object> model = new HashMap<String, Object>();
		User user = authService.login(userName, password);
		if (user!=null){
			session.setAttribute("username",user.getUsername());
			session.setAttribute("userid", user.getUserId());
			modelView = new ModelAndView("redirect:/events.html");
		}
		else{
		modelView.setViewName("redirect:/loginFail.html");
		}
		return modelView;
	}

	@RequestMapping("/loginFail")
	public ModelAndView failedlogin() {
		Map<String, Object> model = new HashMap<String, Object>();

		return new ModelAndView("redirect:/home.html");
	}
	
	@RequestMapping("/loginPage")
	public ModelAndView loginPage() {
		Map<String, Object> model = new HashMap<String, Object>();

		return new ModelAndView("LoginUser");
	}
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		Map<String, Object> model = new HashMap<String, Object>();
session.removeAttribute("username");
session.invalidate();
		return new ModelAndView("redirect:/home.html");
	}
}
