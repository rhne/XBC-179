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
import com.spring.miniproject.service.MenuService;
import com.spring.miniproject.service.SequenceService;

@Controller
public class MenuController extends BaseController{
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private SequenceService sequenceService;
	
	public void aksesLogin(Model model) {
		
		model.addAttribute("username", this.getAkunModel().getName());
		model.addAttribute("nameRole", this.getAkunModel().getRoleModel().getName());
		
		List<MenuModel> menuModelList = null;
		Long idRole = this.getAkunModel().getRoleModel().getId();
		menuModelList = this.menuService.selectMenuByRole(idRole);
		model.addAttribute("menuModelList", menuModelList);
	}
	
	@RequestMapping(value="menu")
	public String menu(Model model) {
		this.aksesLogin(model);
		String jsp = "menu/menu";
		
		return jsp;
	}
	
	@RequestMapping(value="menu/tambah")
	public String tambah(Model model) {
		String menuAuto = "";
		menuAuto = this.kodeGenerator();
		model.addAttribute("menuAuto", menuAuto);
		this.listDataMenu(model);
		
		String jsp = "menu/tambah";
		return jsp;
	}
	
	private void listDataMenu(Model model) {
		// TODO Auto-generated method stub
		List<MenuModel> menuModelList = new ArrayList<MenuModel>();
		menuModelList = this.menuService.select();
		model.addAttribute("menuModelList", menuModelList);
	}

	@RequestMapping(value="menu/create")
	public String menucreate(HttpServletRequest request, Model model) {
		
		String kode = request.getParameter("kode");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String imgurl = request.getParameter("imgurl");
		Integer menuorder = Integer.valueOf(request.getParameter("menuorder"));
		Long menuparent = Long.valueOf(request.getParameter("menuparent"));
		String menuurl = request.getParameter("menuurl");
		
		MenuModel menuModel = new MenuModel();
		
		menuModel.setKode(kode);
		menuModel.setTitle(title);
		menuModel.setDescription(description);
		menuModel.setImgurl(imgurl);
		menuModel.setMenuorder(menuorder);
		menuModel.setMenuparent(menuparent);
		menuModel.setMenuurl(menuurl);
		
		//audit trail
		Long createdBy = this.getAkunModel().getId();
		menuModel.setCreatedBy(createdBy);
		menuModel.setCreatedOn(new Date());
		menuModel.setActive(1);
		
		this.menuService.create(menuModel);;
		model.addAttribute("menuModel", menuModel);
		
		String jsp = "menu/menu";
		return jsp;
	}
	
	@RequestMapping(value="menu/list")
	public String menuList(Model model) {
		List<MenuModel> menuModelList = new ArrayList<MenuModel>();
		menuModelList = this.menuService.select();
		model.addAttribute("menuModelList", menuModelList);
		
		String jsp = "menu/list";
		return jsp;
	}
	
	@RequestMapping(value="menu/edit")
	public String menuEdit(HttpServletRequest request,Model model) {
		Long id = Long.valueOf(request.getParameter("id"));
		MenuModel menuModel = new MenuModel();
		menuModel = this.menuService.searchById(id);
		model.addAttribute("menuModel", menuModel);
		
		this.listDataMenu(model);
		
		String jsp = "menu/edit";
		return jsp;
	}
	
	@RequestMapping(value="menu/edit/save")
	public String menuEditSave(HttpServletRequest request, Model model) {
		Long id = Long.valueOf(request.getParameter("id"));
		
		String kode = request.getParameter("kode");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String imgurl = request.getParameter("imgurl");
		Integer menuorder = Integer.valueOf(request.getParameter("menuorder"));
		Long menuparent = Long.valueOf(request.getParameter("menuparent"));
		String menuurl = request.getParameter("menuurl");
		
		MenuModel menuModel = new MenuModel();
		menuModel = this.menuService.searchById(id);
		
		menuModel.setKode(kode);
		menuModel.setTitle(title);
		menuModel.setDescription(description);
		menuModel.setImgurl(imgurl);
		menuModel.setMenuorder(menuorder);
		menuModel.setMenuparent(menuparent);
		menuModel.setMenuurl(menuurl);
		
		//audit trail
		Long modifiedBy = this.getAkunModel().getId();
		menuModel.setModifiedBy(modifiedBy);
		menuModel.setModifiedOn(new Date());
		
		this.menuService.update(menuModel);
		model.addAttribute("menuModel", menuModel);
		
		String jsp = "menu/menu";
		return jsp;
	}
	
	public String kodeGenerator() {
		Integer idMenu = 0;
		idMenu = this.sequenceService.nextIdMenu();
		
		String menuAuto ="";
		if (idMenu < 10) {
			menuAuto = "M000" + idMenu;
		}else if (idMenu >= 10 && idMenu < 100) {
			menuAuto = "M00" + idMenu;
		}else if (idMenu >= 100 && idMenu < 1000) {
			menuAuto = "M0" + idMenu;
		}else if (idMenu >=1000) {
			menuAuto = "M" + idMenu;
		}else {
			
		}
		
		return menuAuto;
	}
	
	@RequestMapping (value="menu/deactivate")
	public String deactivate(HttpServletRequest request, Model model) {
		Long id = Long.valueOf(request.getParameter("id"));
		MenuModel menuModel = new MenuModel();
		menuModel = this.menuService.searchById(id);
		model.addAttribute("menuModel", menuModel);
		String jsp = "menu/deactivate";
		return jsp;
	}
	
	@RequestMapping(value="menu/deactivate/save")
	public String menuDeactivateSave(HttpServletRequest request, Model model) {
		Long id = Long.valueOf(request.getParameter("id"));
				
		MenuModel menuModel = new MenuModel();
		menuModel = this.menuService.searchById(id);
	
		//audit trail
		Long modifiedBy = this.getAkunModel().getId();
		menuModel.setModifiedBy(modifiedBy);
		menuModel.setModifiedOn(new Date());
				
		this.menuService.deactivate(menuModel);
		
		String jsp = "user/user";
		return jsp;
	}
	
	@RequestMapping(value="menu/search/name")
	public String menuSearchName(HttpServletRequest request, Model model) {
		String title = request.getParameter("nameCari");
		List<MenuModel> menuModelList = new ArrayList<MenuModel>();
		menuModelList = this.menuService.searchByLikeTitle(title);
		model.addAttribute("menuModelList", menuModelList);
		String jsp = "menu/list";
		return jsp;
	}
	
}
