package com.spring.miniproject.controller;

import java.util.ArrayList;
import java.util.Date;
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
		
		Long idRole = Long.valueOf(request.getParameter("idRole"));
		
		AkunModel akunModel = new AkunModel();
		akunModel.setName(request.getParameter("name"));		
		akunModel.setPassword(request.getParameter("password"));
		akunModel.setMobileFlag(0);
		akunModel.setIsActive(1);
		akunModel.setIdRole(idRole);
		akunModel.setCreatedOn(new Date());
		
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
	
	@RequestMapping(value="user/edit/save")
	public String roleEditSave(HttpServletRequest request, Model model) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		String nama = request.getParameter("name");
		String password = request.getParameter("password");
		Long idRole = Long.valueOf(request.getParameter("idRole"));
		
		AkunModel akunModelDB = new AkunModel();
		akunModelDB = this.akunService.searchById(id);
		
		akunModelDB.setName(nama);
		akunModelDB.setPassword(password);
		akunModelDB.setIdRole(idRole);
		akunModelDB.setModifiedOn(new Date());
		
		this.akunService.update(akunModelDB);
		model.addAttribute("akunModelDB", akunModelDB);
		
		String jsp = "user/user";
		return jsp;
	}
	
	@RequestMapping(value="user/search/name")
	public String userSearchName(HttpServletRequest request, Model model) {
		String name = request.getParameter("nameCari");
		List<AkunModel> akunModelList = new ArrayList<AkunModel>();
		akunModelList = this.akunService.searchByLikeName(name);
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
