package com.spring.miniproject.controller;

import java.util.ArrayList; 
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.miniproject.model.MenuAksesModel;
import com.spring.miniproject.model.RoleModel;
import com.spring.miniproject.model.MenuModel;
import com.spring.miniproject.service.MenuAksesService;
import com.spring.miniproject.service.MenuService;
import com.spring.miniproject.service.RoleService;

@Controller
public class MenuAksesController {

	@Autowired
	private MenuAksesService menuAksesService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private MenuService menuService;
		
	@RequestMapping(value="menuaccess")
	public String menuAkses(Model model) {
		String jsp = "menuaccess/menuakses";
		return jsp;
	}
	
	@RequestMapping(value="menuaccess/tambah")
	public String tambahMenuAccess(Model model) {
		
		this.listDataRole(model);
		this.listDataMenu(model);
		
		String jsp = "menuaccess/tambah";
		return jsp;
	}	
	
	private void listDataMenu(Model model) {
		// TODO Auto-generated method stub
		List<MenuModel> menuModelList = new ArrayList<MenuModel>();
		menuModelList = this.menuService.select();
		model.addAttribute("menuModelList", menuModelList);
	}

	@RequestMapping(value="menuaccess/create")
	public String create(HttpServletRequest request, Model model) throws Exception{
		
		Long idRole = Long.valueOf(request.getParameter("idRole"));
		Long idMenu = Long.valueOf(request.getParameter("idMenu"));
		
		MenuAksesModel menuAksesModel = new MenuAksesModel();
	
		menuAksesModel.setIdRole(idRole);
		menuAksesModel.setIdMenu(idMenu);
		menuAksesModel.setCreatedOn(new Date());
		
		this.menuAksesService.create(menuAksesModel);
		model.addAttribute("menuAksesModel", menuAksesModel);
		
		String jsp = "menuaccess/menuakses";
		return jsp;
	}
	
	@RequestMapping(value="menuaccess/list")
	public String listMenuAkses(Model model) {
		List<MenuAksesModel> menuAksesModelList = new ArrayList<MenuAksesModel>();
		menuAksesModelList = this.menuAksesService.searchAll();
		model.addAttribute("menuAksesModelList", menuAksesModelList);
		String jsp = "menuaccess/list";
		return jsp;
	}
	
	@RequestMapping(value="menuaccess/search/name")
	public String menuAksesSearchName(HttpServletRequest request, Model model) {
		String name = request.getParameter("nameCari");
		List<MenuAksesModel> menuAksesModelList = new ArrayList<MenuAksesModel>();
		menuAksesModelList = this.menuAksesService.searchByLikeName(name);
		model.addAttribute("menuAksesModelList", menuAksesModelList);
		String jsp = "menuaccess/list";
		return jsp;
	}
	
	private void listDataRole(Model model) {
		List<RoleModel> roleModelList = new ArrayList<RoleModel>();
		roleModelList = this.roleService.select();
		model.addAttribute("roleModelList", roleModelList);
	}
	
	@RequestMapping (value="menuaccess/delete")
	public String delete(HttpServletRequest request, Model model) {
		Long id = Long.valueOf(request.getParameter("id"));
		MenuAksesModel menuAksesModel = new MenuAksesModel();
		menuAksesModel = this.menuAksesService.searchById(id);
		model.addAttribute("menuAksesModel", menuAksesModel);
		String jsp = "menuaccess/delete";
		return jsp;
	}
	
	@RequestMapping(value="menuaccess/delete/save")
	public String deleteSave(HttpServletRequest request, Model model) {
		Long id = Long.valueOf(request.getParameter("id"));
		
		MenuAksesModel menuAksesModel = new MenuAksesModel();
		menuAksesModel = this.menuAksesService.searchById(id);
	
		this.menuAksesService.delete(menuAksesModel);
		
		String jsp = "menuaccess/menuakses";
		return jsp;
	}
}
