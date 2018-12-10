package com.spring.miniproject.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.miniproject.model.CategoryModel;
import com.spring.miniproject.model.IdleNewsModel;
import com.spring.miniproject.model.MenuModel;
import com.spring.miniproject.service.CategoryService;
import com.spring.miniproject.service.IdleNewsService;
import com.spring.miniproject.service.MenuService;

@Controller
public class IdleNewsController extends BaseController{

	@Autowired
	private MenuService menuService;
	
	@Autowired
	private IdleNewsService idlenewsService;
	
	@Autowired
	private CategoryService categoryService;
	
	public void aksesLogin(Model model) {
		
		model.addAttribute("username", this.getAkunModel().getName());
		model.addAttribute("nameRole", this.getAkunModel().getRoleModel().getName());
		
		List<MenuModel> menuModelList = null;
		Long idRole = this.getAkunModel().getRoleModel().getId();
		menuModelList = this.menuService.selectMenuByRole(idRole);
		model.addAttribute("menuModelList", menuModelList);
	}
	
	@RequestMapping(value="idle_news")
	public String user(Model model) {
		this.aksesLogin(model);
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
		Long createdBy = this.getAkunModel().getId();
		idlenewsModel.setCreatedBy(createdBy);
		idlenewsModel.setCreatedOn(new Date());
		
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
	@RequestMapping (value="idle_news/delete")
	public String delete(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		IdleNewsModel idlenewsModel = new IdleNewsModel();
		idlenewsModel = this.idlenewsService.searchById(Long.parseLong(id));
		model.addAttribute("idlenewsModel", idlenewsModel);
		String jsp = "idle_news/delete";
		return jsp;
	}
	
	@RequestMapping (value="idle_news/delete/save")
	public String delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		IdleNewsModel idlenewsModel = new IdleNewsModel();
		idlenewsModel = this.idlenewsService.searchById(Long.parseLong(id));
		this.idlenewsService.delete(idlenewsModel);
		
		String jsp = "idle_news/idle_news";
		return jsp;
	}
	//edit
	@RequestMapping(value="idle_news/edit")
	public String Edit(HttpServletRequest request, Model model) {
		String id = (request.getParameter("id"));
		IdleNewsModel idlenewsModel = new IdleNewsModel();
		idlenewsModel = this.idlenewsService.searchById(Long.parseLong(id));
		model.addAttribute("idlenewsModel", idlenewsModel);
		this.listDataCategory(model);
		String jsp = "idle_news/edit";
		return jsp;
	}
	
	
	@RequestMapping(value="idle_news/edit/save")
	public String EditSave(HttpServletRequest request, Model model) throws Exception{
		String id = request.getParameter("id");
		IdleNewsModel idlenewsModel = new IdleNewsModel();
		idlenewsModel = this.idlenewsService.searchById(Long.parseLong(id));		
		idlenewsModel.setTitle(request.getParameter("title"));		
		idlenewsModel.setContent(request.getParameter("content"));
		idlenewsModel.setIdCategory(Long.valueOf(request.getParameter("idCategory")));
		Long modifiedBy = this.getAkunModel().getId();
		idlenewsModel.setModifiedBy(modifiedBy);
		idlenewsModel.setModifiedOn(new Date());
		
		this.idlenewsService.update(idlenewsModel);
		model.addAttribute("idlenewsModel", idlenewsModel);
		
		String jsp = "idle_news/category";
		return jsp;
	}
	@RequestMapping (value="idle_news/publish")
	public String publish(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		IdleNewsModel idlenewsModel = new IdleNewsModel();
		idlenewsModel = this.idlenewsService.searchById(Long.parseLong(id));
		model.addAttribute("idlenewsModel", idlenewsModel);
		String jsp = "idle_news/publish";
		return jsp;
	}
	
	@RequestMapping (value="idle_news/publish/save")
	public String publish(HttpServletRequest request) {
		String id = request.getParameter("id");
		IdleNewsModel idlenewsModel = new IdleNewsModel();
		idlenewsModel = this.idlenewsService.searchById(Long.parseLong(id));
		this.idlenewsService.publish(idlenewsModel);
		
		String jsp = "idle_news/idle_news";
		return jsp;
	}
}
