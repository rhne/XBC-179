package com.spring.miniproject.controller;

import java.util.ArrayList;  
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.miniproject.model.CategoryModel;
import com.spring.miniproject.model.MenuModel;
import com.spring.miniproject.service.CategoryService;
import com.spring.miniproject.service.MenuService;
import com.spring.miniproject.service.SequenceService;

@Controller
public class CategoryController extends BaseController{
	
	@Autowired
	private CategoryService categoryService;
	
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
	
	@RequestMapping(value="category")
	public String category(Model model) {
		this.aksesLogin(model);
		String jsp = "category/category";
		return jsp;
	}
	
	@RequestMapping(value="category/tambah")
	public String categoryAdd(Model model) {
		String codeAuto = "";
		codeAuto = this.codeCategoryGenerator();
		model.addAttribute("codeAuto", codeAuto);
		String jsp = "category/tambah";
		return jsp;
	}
	
	@RequestMapping(value="category/create")
	public String categorycreate(HttpServletRequest request, Model model) {
		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String desc = request.getParameter("description");
		
		CategoryModel categoryModel = new CategoryModel();
		
		categoryModel.setCode(code);
		categoryModel.setName(name);
		categoryModel.setDescription(desc);
		categoryModel.setIsActive(1);
		Long createdBy = this.getAkunModel().getId();
		categoryModel.setCreatedBy(createdBy);
		
		this.categoryService.create(categoryModel);;
		model.addAttribute("categoryModel", categoryModel);
		
		String jsp = "category/category";
		return jsp;
	}
	
	@RequestMapping(value="category/list")
	public String categoryList(Model model) {
		List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
		categoryModelList = this.categoryService.select();
		model.addAttribute("categoryModelList", categoryModelList);
		
		String jsp = "category/list";
		return jsp;
	}
	
	
	public String codeCategoryGenerator() {
		Integer idCategory = 0;
		idCategory = this.sequenceService.nextIdCategory();
		
		String codeAuto ="";
		if (idCategory < 10) {
			codeAuto = "C000" + idCategory;
		}else if (idCategory >= 10 && idCategory < 100) {
			codeAuto = "C00" + idCategory;
		}else if (idCategory >= 100 && idCategory < 1000) {
			codeAuto = "C0" + idCategory;
		}else if (idCategory >=1000) {
			codeAuto = "C" + idCategory;
		}else {
			
		}
		
		return codeAuto;
	}
	@RequestMapping(value="category/search/name")
	public String SearchName(HttpServletRequest request, Model model) {
		String name = request.getParameter("nameCari");
		List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
		categoryModelList = this.categoryService.searchByLikeName(name);
		model.addAttribute("categoryModelList", categoryModelList);
		String jsp = "category/list";
		return jsp;
	}
	@RequestMapping (value="category/delete")
	public String delete(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		CategoryModel categoryModel = new CategoryModel();
		categoryModel = this.categoryService.searchById(Long.parseLong(id));
		model.addAttribute("categoryModel", categoryModel);
		String jsp = "category/delete";
		return jsp;
	}
	
	@RequestMapping (value="category/delete/save")
	public String delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		CategoryModel categoryModel = new CategoryModel();
		categoryModel = this.categoryService.searchById(Long.parseLong(id));
		this.categoryService.delete(categoryModel);
		
		String jsp = "category/category";
		return jsp;
	}
	//edit
	@RequestMapping(value="category/edit")
	public String Edit(HttpServletRequest request, Model model) {
		String id = (request.getParameter("id"));
		CategoryModel categoryModel = new CategoryModel();
		categoryModel = this.categoryService.searchById(Long.parseLong(id));
		model.addAttribute("categoryModel", categoryModel);
		String jsp = "category/edit";
		return jsp;
	}
	
	
	@RequestMapping(value="category/edit/save")
	public String EditSave(HttpServletRequest request, Model model) throws Exception{
		String id = request.getParameter("id");
		CategoryModel categoryModel = new CategoryModel();
		categoryModel = this.categoryService.searchById(Long.parseLong(id));		
		categoryModel.setName(request.getParameter("name"));
		Long modifiedBy = this.getAkunModel().getId();
		categoryModel.setModifiedBy(modifiedBy);
		
		this.categoryService.update(categoryModel);
		model.addAttribute("categoryModel", categoryModel);
		
		String jsp = "category/category";
		return jsp;
	}
}
