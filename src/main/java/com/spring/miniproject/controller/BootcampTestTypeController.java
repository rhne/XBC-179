package com.spring.miniproject.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.miniproject.model.BootcampTestTypeModel;
import com.spring.miniproject.model.MenuModel;
import com.spring.miniproject.service.BootcampTestTypeService;
import com.spring.miniproject.service.MenuService;

@Controller
public class BootcampTestTypeController extends BaseController{
	
	@Autowired
	private BootcampTestTypeService bootcamptesttypeService;
	
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
	
	@RequestMapping(value="bootcamp_test_type")
	public String bootcamptesttype(Model model) {
		this.aksesLogin(model);
		String jsp = "bootcamp_test_type/bootcamp_test_type";
		return jsp;
	}
	
	@RequestMapping(value="bootcamp_test_type/tambah")
	public String tambahbootcamptesttype(Model model) {
		
		String jsp = "bootcamp_test_type/tambah";
		return jsp;
	}	
	
	@RequestMapping(value="bootcamp_test_type/create")
	public String create(HttpServletRequest request, Model model){
		
		BootcampTestTypeModel bootcamptesttypeModel = new BootcampTestTypeModel();
		bootcamptesttypeModel.setName(request.getParameter("name"));		
		bootcamptesttypeModel.setNotes(request.getParameter("notes"));
		bootcamptesttypeModel.setIsActive(1);
		Long createdBy = this.getAkunModel().getId();
		bootcamptesttypeModel.setCreatedBy(createdBy);
		bootcamptesttypeModel.setCreatedOn(new Date());
		
		this.bootcamptesttypeService.create(bootcamptesttypeModel);
		model.addAttribute("bootcamptesttypeModel", bootcamptesttypeModel);
		
		String jsp = "bootcamp_test_type/bootcamp_test_type";
		return jsp;
	}
	
	@RequestMapping(value="bootcamp_test_type/list")
	public String list(Model model) {
		List<BootcampTestTypeModel> bootcamptesttypeModelList = new ArrayList<BootcampTestTypeModel>();
		bootcamptesttypeModelList = this.bootcamptesttypeService.searchAll();
		model.addAttribute("bootcamptesttypeModelList", bootcamptesttypeModelList);
		String jsp = "bootcamp_test_type/list";
		return jsp;
	}
	@RequestMapping(value="bootcamp_test_type/search/name")
	public String SearchName(HttpServletRequest request, Model model) {
		String name = request.getParameter("nameCari");
		List<BootcampTestTypeModel> bootcamptesttypeModelList = new ArrayList<BootcampTestTypeModel>();
		bootcamptesttypeModelList = this.bootcamptesttypeService.searchByLikeName(name);
		model.addAttribute("bootcamptesttypeModelList", bootcamptesttypeModelList);
		String jsp = "bootcamp_test_type/list";
		return jsp;
	}
	@RequestMapping (value="bootcamp_test_type/delete")
	public String delete(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		BootcampTestTypeModel bootcamptesttypeModel = new BootcampTestTypeModel();
		bootcamptesttypeModel = this.bootcamptesttypeService.searchById(Long.parseLong(id));
		model.addAttribute("bootcamptesttypeModel", bootcamptesttypeModel);
		String jsp = "bootcamp_test_type/delete";
		return jsp;
	}
	
	@RequestMapping (value="bootcamp_test_type/delete/save")
	public String delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		BootcampTestTypeModel bootcamptesttypeModel = new BootcampTestTypeModel();
		bootcamptesttypeModel = this.bootcamptesttypeService.searchById(Long.parseLong(id));
		this.bootcamptesttypeService.delete(bootcamptesttypeModel);
		
		String jsp = "bootcamp_test_type/bootcamp_test_type";
		return jsp;
	}
	//edit
		@RequestMapping(value="bootcamp_test_type/edit")
		public String Edit(HttpServletRequest request, Model model) {
			String id = (request.getParameter("id"));
			BootcampTestTypeModel bootcamptesttypeModel = new BootcampTestTypeModel();
			
			bootcamptesttypeModel = this.bootcamptesttypeService.searchById(Long.parseLong(id));
			model.addAttribute("bootcamptesttypeModel", bootcamptesttypeModel);
			String jsp = "bootcamp_test_type/edit";
			return jsp;
		}
		
		
		@RequestMapping(value="bootcamp_test_type/edit/save")
		public String EditSave(HttpServletRequest request, Model model) throws Exception{
			String id = request.getParameter("id");
			BootcampTestTypeModel bootcamptesttypeModel = new BootcampTestTypeModel();
			bootcamptesttypeModel = this.bootcamptesttypeService.searchById(Long.parseLong(id));
			bootcamptesttypeModel.setName(request.getParameter("name"));		
			bootcamptesttypeModel.setNotes(request.getParameter("notes"));
			Long modifiedBy = this.getAkunModel().getId();
			bootcamptesttypeModel.setModifiedBy(modifiedBy);
			bootcamptesttypeModel.setModifiedOn(new Date());
			
			this.bootcamptesttypeService.update(bootcamptesttypeModel);
			model.addAttribute("bootcamptesttypeModel", bootcamptesttypeModel);
			
			String jsp = "bootcamp_test_type/edit";
			return jsp;
		}
}
