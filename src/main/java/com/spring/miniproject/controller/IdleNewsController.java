package com.spring.miniproject.controller;

import java.util.ArrayList;     
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.miniproject.model.BootcampTestTypeModel;
import com.spring.miniproject.model.CategoryModel;
import com.spring.miniproject.model.IdleNewsModel;
import com.spring.miniproject.service.CategoryService;
import com.spring.miniproject.service.IdleNewsService;

@Controller
public class IdleNewsController {

	@Autowired
	private IdleNewsService idlenewsService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="idle_news")
	public String user(Model model) {
		String jsp = "idle_news/idle_news";
		return jsp;
	}
	
	@RequestMapping(value="idle_news/tambah")
	public String tambahidle(Model model) {
		this.listDataCategory(model);
		String jsp = "idle_news/tambah";
		return jsp;
	}	
	
	@RequestMapping(value="idle_news/create")
	public String create(HttpServletRequest request, Model model) throws Exception{
		IdleNewsModel idlenewsModel = new IdleNewsModel();
		idlenewsModel.setTitle(request.getParameter("title"));		
		idlenewsModel.setContent(request.getParameter("content"));
		idlenewsModel.setIdCategory(Long.valueOf(request.getParameter("idCategory")));
		idlenewsModel.setIsDeleted(0);
		idlenewsModel.setIsPublish(0);
		
		this.idlenewsService.create(idlenewsModel);
		model.addAttribute("idlenewsModel", idlenewsModel);
		
		String jsp = "idle_news/idle_news";
		return jsp;
	}
	
	@RequestMapping(value="idle_news/list")
	public String listidle(Model model) {
		List<IdleNewsModel> idlenewsModelList = new ArrayList<IdleNewsModel>();
		idlenewsModelList = this.idlenewsService.searchAll();
		model.addAttribute("idlenewsModelList", idlenewsModelList);
		String jsp = "idle_news/list";
		return jsp;
	}
	@SuppressWarnings("unused")
	private void listDataCategory(Model model) {
		List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();
		categoryModelList = this.categoryService.select();
		model.addAttribute("categoryModelList", categoryModelList);
	}
	
	@RequestMapping(value="idle_news/search/name")
	public String SearchName(HttpServletRequest request, Model model) {
		String name = request.getParameter("nameCari");
		List<IdleNewsModel> idlenewsModelList = new ArrayList<IdleNewsModel>();
		idlenewsModelList = this.idlenewsService.searchByLikeName(name);
		model.addAttribute("idlenewsModelList", idlenewsModelList);
		String jsp = "idle_news/list";
		return jsp;
	}
}
