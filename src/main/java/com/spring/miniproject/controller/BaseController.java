package com.spring.miniproject.controller;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;


import com.spring.miniproject.model.AkunModel;
import com.spring.miniproject.service.AkunService;

@Controller
public class BaseController {

	@Autowired
	private AkunService akunService;
	
	public <Akun> AkunModel getAkunModel() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		AkunModel akunModel = new AkunModel ();
		if (auth!=null) {
			User akun = (User) auth.getPrincipal();
			String username = akun.getUsername();
			String password = akun.getPassword();
			
			akunModel = this.akunService.searchByUsernamePassword(username, password);
		}
		return akunModel;
	}
}
