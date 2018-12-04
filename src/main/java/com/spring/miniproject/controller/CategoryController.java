package com.spring.miniproject.controller;

import java.util.ArrayList;  
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.miniproject.model.CategoryModel;
import com.spring.miniproject.model.RoleModel;
import com.spring.miniproject.service.CategoryService;
import com.spring.miniproject.service.RoleService;
import com.spring.miniproject.service.SequenceService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private SequenceService sequenceService;
	
	@RequestMapping(value="category")
	public String category() {
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
	
}
