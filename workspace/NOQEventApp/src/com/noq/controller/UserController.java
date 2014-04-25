package com.noq.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.noq.domain.User;
import com.noq.formviews.UserRegistrationForm;
import com.noq.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/signup")
	public ModelAndView signUp() {
		Map<String, Object> model = new HashMap<String, Object>();
		return new ModelAndView("Signup");
	}

	@RequestMapping(value = "/createuser",method = RequestMethod.POST)
	public ModelAndView saveUserData(
			 @Valid UserRegistrationForm userRegistrationForm,
			BindingResult result) {
		ModelAndView modelView = new ModelAndView();
		if(result.hasErrors()){
			System.out.println("invalid");
			modelView.setViewName("Signup");
		}
		else
		{
		String userName = userRegistrationForm.getUserName();
		System.out.println("username:"+userName);
		String emailID = userRegistrationForm.getEmailId();
		System.out.println("emailID:"+emailID);
		if ((!"".equals(userName) && userName != null)
				&& (!"".equals(emailID) && emailID != null)) {
			User user = new User();
			String password = "test";
			user.setUsername(userName);
			user.setEmailid(emailID);
			user.setPassword(password);
			userService.addUser(user);
			System.out.println("Save User Data");
			modelView.setViewName("LoginUser");
		} else {
			modelView.setViewName("Signup");

		}
		}
		return modelView;
	}
}
