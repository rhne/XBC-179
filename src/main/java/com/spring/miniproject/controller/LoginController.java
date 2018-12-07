package com.spring.miniproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController extends BaseController{
	
	public void aksesLogin(Model model) {
		
		model.addAttribute("name", this.getAkunModel().getName());
		model.addAttribute("password", this.getAkunModel().getPassword());
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value="error", required=false) String error,
			@RequestParam(value="logout",required=false) String logout){
		ModelAndView model = new ModelAndView();
		if(error != null){
			model.addObject("error","Invalid username and password");
		}
		if(logout != null){
			model.addObject("msg","You are have logged out successfully");
		}
		return model;
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView index(Model model, HttpSession session){


		return new ModelAndView("/index");
	}
	
	
	@RequestMapping(value="/j_spring_security_logout", method=RequestMethod.GET)
	public ModelAndView logout(Model model, HttpSession session){
		return new ModelAndView("/login");
	}
}
