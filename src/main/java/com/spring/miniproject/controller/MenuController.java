package com.spring.miniproject.controller;

import java.util.ArrayList; 
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
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private SequenceService sequenceService;
	
	@RequestMapping(value="menu")
	public String menu() {
		String jsp = "menu/menu";
		
		return jsp;
	}
	
	@RequestMapping(value="menu/add")
	public String menuAdd(Model model) {
		String menAuto = "";
		menAuto = this.kodeMenuGenerator();
		model.addAttribute("menAuto", menAuto);
		String jsp = "menu/add";
		return jsp;
	}
	
	@RequestMapping(value="menu/add/save")
	public String menuAddSave(HttpServletRequest request, Model model) {
		String kode = request.getParameter("kode");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String imgurl = request.getParameter("imgurl");
		String menuorder = request.getParameter("menuorder");
		String parent = request.getParameter("parent");
		String menuurl = request.getParameter("menuurl");
		
		MenuModel menuModel = new MenuModel();
		
		menuModel.setKode(kode);
		menuModel.setTitle(title);
		menuModel.setTitle(description);
		menuModel.setTitle(imgurl);
		menuModel.setTitle(menuorder);
		menuModel.setTitle(parent);
		menuModel.setTitle(menuurl);
		
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
		String menuorder = request.getParameter("menuorder");
		String parent = request.getParameter("parent");
		String menuurl = request.getParameter("menuurl");
		
		MenuModel menuModel = new MenuModel();
		menuModel = this.menuService.searchById(id);
		
		menuModel.setKode(kode);
		menuModel.setTitle(title);
		menuModel.setTitle(description);
		menuModel.setTitle(imgurl);
		menuModel.setTitle(menuorder);
		menuModel.setTitle(parent);
		menuModel.setTitle(menuurl);
		
		this.menuService.update(menuModel);
		model.addAttribute("menuModel", menuModel);
		
		String jsp = "menu/menu";
		return jsp;
	}
	
	public String kodeMenuGenerator() {
		Integer idMenu = 0;
		idMenu = this.sequenceService.nextIdMenu();
		
		String menAuto ="";
		if (idMenu < 10) {
			menAuto = "M000" + idMenu;
		}else if (idMenu >= 10 && idMenu < 100) {
			menAuto = "M00" + idMenu;
		}else if (idMenu >= 100 && idMenu < 1000) {
			menAuto = "M0" + idMenu;
		}else if (idMenu >=1000) {
			menAuto = "M" + idMenu;
		}else {
			
		}
		
		return menAuto;
	}
	
}
