package com.spring.miniproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.miniproject.model.MenuModel;
import com.spring.miniproject.service.MenuService;

@Controller
public class LoginController extends BaseController{
	
	@Autowired
	private MenuService menuService;
	
	public void aksesLogin(Model model) {
		
		model.addAttribute("username", this.getAkunModel().getName());
		model.addAttribute("nameRole", this.getAkunModel().getRoleModel().getName());
		
		List<MenuModel> menuModelList = null;
		Long idRole = this.getAkunModel().getRoleModel().getId();
		menuModelList = this.menuService.selectMenuByRole(idRole);
		model.addAttribute("menuModelList", menuModelList);
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
		
		this.aksesLogin(model);
		return new ModelAndView("/index");
	}
	
	
	@RequestMapping(value="/j_spring_security_logout", method=RequestMethod.GET)
	public ModelAndView logout(Model model, HttpSession session){
		return new ModelAndView("/login");
	}
	
	public void DataLogin (Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		
		session.setAttribute("userLogin", request.getParameter("name"));
	}
}
