package com.spring.miniproject.controller;

import java.util.ArrayList;     
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.miniproject.model.AkunModel;
import com.spring.miniproject.model.RoleModel;
import com.spring.miniproject.service.AkunService;
import com.spring.miniproject.service.RoleService;

@Controller
public class AkunController {

	@Autowired
	private AkunService akunService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="user")
	public String user(Model model) {
		String jsp = "user/user";
		return jsp;
	}
	
	@RequestMapping(value="user/tambah")
	public String tambahakun(Model model) {
		
		this.listDataRole(model);
		
		String jsp = "user/tambah";
		return jsp;
	}	
	
	@RequestMapping(value="user/create")
	public String create(HttpServletRequest request, Model model) throws Exception{
		
		Integer idRole = Integer.valueOf(request.getParameter("idRole"));
		
		AkunModel akunModel = new AkunModel();
		akunModel.setName(request.getParameter("name"));		
		akunModel.setPassword(request.getParameter("password"));
		akunModel.setIdRole(idRole);
		
		this.akunService.create(akunModel);
		model.addAttribute("akunModel", akunModel);
		
		String jsp = "user/user";
		return jsp;
	}
	
	@RequestMapping(value="user/list")
	public String listakun(Model model) {
		List<AkunModel> akunModelList = new ArrayList<AkunModel>();
		akunModelList = this.akunService.searchAll();
		model.addAttribute("akunModelList", akunModelList);
		String jsp = "user/list";
		return jsp;
	}
	
	private void listDataRole(Model model) {
		List<RoleModel> roleModelList = new ArrayList<RoleModel>();
		roleModelList = this.roleService.select();
		model.addAttribute("roleModelList", roleModelList);
	}
	
}
