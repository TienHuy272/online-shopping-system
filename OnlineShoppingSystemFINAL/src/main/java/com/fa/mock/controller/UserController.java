package com.fa.mock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.fa.mock.model.UserSystem;
import com.fa.mock.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/adminLogin")
	public String showLogin() {
		return "AdminLogin";
	}
	
	@RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
	public String login(@ModelAttribute("admin") UserSystem admin, 
						HttpSession session, Model model) {
		UserSystem theAdmin = userService.login(admin);
		String role = userService.getUserRole();
		if (theAdmin != null) {
			session.setAttribute("role", role);
			session.setAttribute("theAdmin", theAdmin);
			return "redirect:/adminProfile";
		} else {
			model.addAttribute("message", "Invalid Username or Password !");
			return "AdminLogin";
		}
	}
	
	
	@RequestMapping(value = "/adminProfile")
	public String showProfile(@SessionAttribute("theAdmin") UserSystem theAdmin, Model model) {
		if (theAdmin != null) {
			model.addAttribute("theAdmin", theAdmin);
		} else {
			model.addAttribute("theAdmin", new UserSystem());
		}
		return "AdminProfile";
	}
	
	
//	@RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
//	public String updateProfile(@ModelAttribute("theAdmin") UserSystem theAdmin) {
//		userService.updateUserSystem(theAdmin);
//		return "redirect:/adminProfile";
//	}
}
