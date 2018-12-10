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
import com.spring.miniproject.model.MenuModel;
import com.spring.miniproject.model.RoleModel;
import com.spring.miniproject.service.AkunService;
import com.spring.miniproject.service.MenuService;
import com.spring.miniproject.service.RoleService;

@Controller
public class AkunController extends BaseController{

	@Autowired
	private AkunService akunService;
	
	@Autowired
	private RoleService roleService;
	
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
		
	@RequestMapping(value="user")
	public String user(Model model) {
		this.aksesLogin(model);
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
	
	@RequestMapping(value="user/edit")
	public String userEdit(HttpServletRequest request,Model model) {
		Long id = Long.valueOf(request.getParameter("id"));
		AkunModel akunModel = new AkunModel();
		akunModel = this.akunService.searchById(id);
		model.addAttribute("akunModel", akunModel);
		
		this.listDataRole(model);
		
		String jsp = "user/edit";
		return jsp;
	}
	
	@RequestMapping(value="user/edit/save")
	public String akunEditSave(HttpServletRequest request, Model model) {
		Long id = Long.valueOf(request.getParameter("id"));
		
		String nama = request.getParameter("name");
		String password = request.getParameter("password");
		Long idRole = Long.valueOf(request.getParameter("idRole"));
		Integer mobileFlag = Integer.valueOf(request.getParameter("mobileFlag"));
		Long mobileToken= Long.valueOf(request.getParameter("mobileToken"));
		
		AkunModel akunModelDB = new AkunModel();
		akunModelDB = this.akunService.searchById(id);
		
		akunModelDB.setName(nama);
		akunModelDB.setPassword(password);
		akunModelDB.setIdRole(idRole);
		akunModelDB.setModifiedOn(new Date());
		akunModelDB.setMobileFlag(mobileFlag);
		akunModelDB.setMobileToken(mobileToken);
		
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
	
	@RequestMapping (value="user/deactivate")
	public String deactivate(HttpServletRequest request, Model model) {
		Long id = Long.valueOf(request.getParameter("id"));
		AkunModel akunModel = new AkunModel();
		akunModel = this.akunService.searchById(id);
		model.addAttribute("akunModel", akunModel);
		String jsp = "user/deactivate";
		return jsp;
	}
	
	@RequestMapping(value="user/deactivate/save")
	public String userDeactivateSave(HttpServletRequest request, Model model) {
		Long id = Long.valueOf(request.getParameter("id"));
		
		AkunModel userModel = new AkunModel();
		userModel = this.akunService.searchById(id);
	
		this.akunService.deactivate(userModel);
		
		String jsp = "user/user";
		return jsp;
	}
}
