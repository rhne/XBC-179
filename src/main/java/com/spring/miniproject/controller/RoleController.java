package com.spring.miniproject.controller;

import java.util.ArrayList;  
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.miniproject.model.MenuModel;
import com.spring.miniproject.model.RoleModel;
import com.spring.miniproject.service.MenuService;
import com.spring.miniproject.service.RoleService;
import com.spring.miniproject.service.SequenceService;

@Controller
public class RoleController extends BaseController{
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private SequenceService sequenceService;
	
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
	
	@RequestMapping(value="role")
	public String role(Model model) {
		this.aksesLogin(model);
		
		String jsp = "role/role";
		return jsp;
	}
	
	@RequestMapping(value="role/tambah")
	public String roleAdd(Model model) {
		String roleAuto = "";
		roleAuto = this.kodeRoleGenerator();
		model.addAttribute("roleAuto", roleAuto);
		String jsp = "role/tambah";
		return jsp;
	}
	
	@RequestMapping(value="role/create")
	public String rolecreate(HttpServletRequest request, Model model) {
		String kode = request.getParameter("kode");
		String nama = request.getParameter("name");
		String desc = request.getParameter("description");
		
		RoleModel roleModel = new RoleModel();
		
		roleModel.setKode(kode);
		roleModel.setName(nama);
		roleModel.setDescription(desc);
		roleModel.setIsActive(1);
		roleModel.setCreatedOn(new Date());
		
		this.roleService.create(roleModel);;
		model.addAttribute("roleModel", roleModel);
		
		String jsp = "role/role";
		return jsp;
	}
	
	@RequestMapping(value="role/list")
	public String roleList(Model model) {
		List<RoleModel> roleModelList = new ArrayList<RoleModel>();
		roleModelList = this.roleService.select();
		model.addAttribute("roleModelList", roleModelList);
		
		String jsp = "role/list";
		return jsp;
	}
	
	@RequestMapping(value="role/edit")
	public String roleEdit(HttpServletRequest request,Model model) {
		Long id = Long.valueOf(request.getParameter("id"));
		RoleModel roleModel = new RoleModel();
		roleModel = this.roleService.searchById(id);
		model.addAttribute("roleModel", roleModel);
		
		String jsp = "role/edit";
		return jsp;
	}
	
	@RequestMapping(value="role/edit/save")
	public String roleEditSave(HttpServletRequest request, Model model) {
		Long id = Long.valueOf(request.getParameter("id"));
		
		String kode = request.getParameter("kode");
		String nama = request.getParameter("name");
		String desc = request.getParameter("description");
		
		RoleModel roleModelDB = new RoleModel();
		roleModelDB = this.roleService.searchById(id);
		
		roleModelDB.setKode(kode);
		roleModelDB.setName(nama);
		roleModelDB.setDescription(desc);
		roleModelDB.setModifiedOn(new Date());
		
		this.roleService.update(roleModelDB);
		model.addAttribute("roleModelDB", roleModelDB);
		
		String jsp = "role/role";
		return jsp;
	}
	
	@RequestMapping (value="role/deactivate")
	public String deactivate(HttpServletRequest request, Model model) {
		Long id = Long.valueOf(request.getParameter("id"));
		RoleModel roleModel = new RoleModel();
		roleModel = this.roleService.searchById(id);
		model.addAttribute("roleModel", roleModel);
		String jsp = "role/deactivate";
		return jsp;
	}
	
	@RequestMapping(value="role/deactivate/save")
	public String roleDeactivateSave(HttpServletRequest request, Model model) {
		Long id = Long.valueOf(request.getParameter("id"));
		
		RoleModel roleModelDB = new RoleModel();
		roleModelDB = this.roleService.searchById(id);
	
		this.roleService.deactivate(roleModelDB);
		
		String jsp = "role/role";
		return jsp;
	}
	
	public String kodeRoleGenerator() {
		Integer idRole = 0;
		idRole = this.sequenceService.nextIdRole();
		
		String roleAuto ="";
		if (idRole < 10) {
			roleAuto = "RO000" + idRole;
		}else if (idRole >= 10 && idRole < 100) {
			roleAuto = "RO00" + idRole;
		}else if (idRole >= 100 && idRole < 1000) {
			roleAuto = "RO0" + idRole;
		} else if (idRole >= 1000) {
			roleAuto = "RO" + idRole;
		} else {
			
		}
		
		return roleAuto;
	}
	
	@RequestMapping(value="role/search/name")
	public String roleSearchName(HttpServletRequest request, Model model) {
		String name = request.getParameter("nameCari");
		List<RoleModel> roleModelList = new ArrayList<RoleModel>();
		roleModelList = this.roleService.searchByLikeName(name);
		model.addAttribute("roleModelList", roleModelList);
		String jsp = "role/list";
		return jsp;
	}
	
}
