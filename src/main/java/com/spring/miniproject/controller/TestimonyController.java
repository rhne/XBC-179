package com.spring.miniproject.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.miniproject.model.TestimonyModel;
//import com.spring.miniproject.service.SequenceService;
import com.spring.miniproject.service.TestimonyService;

@Controller
public class TestimonyController extends BaseController{

	@Autowired
	private TestimonyService testimonyService;
	
//	@Autowired
//	private SequenceService sequenceService;
	
	@RequestMapping(value="testimony")
	public String homeTestimony() {
		String jsp = "testimony/testimony";
		return jsp;
	}
	
	@RequestMapping(value="testimony/addTestimony")
	public String addTestimony() {
		String jsp = "testimony/addTestimony";
		return jsp;
	}
	
	@RequestMapping(value="testimony/listTestimony")
	public String listTestimony(Model model) {
		List<TestimonyModel> testimonyModelList = new ArrayList<TestimonyModel>();
		testimonyModelList = this.testimonyService.showAll();
		model.addAttribute("testimonyModelList", testimonyModelList);
		
		String jsp = "testimony/listTestimony";
		return jsp;
	}
	
	@RequestMapping(value="testimony/addTestimony/save")
	public String addSaveTestimony(HttpServletRequest request, Model model) {
		Long idUser = this.getAkunModel().getId();
		String title = request.getParameter("testimonyTitle");
		String content = request.getParameter("testimonyContent");
		Integer isDeleted = 0;
		
		TestimonyModel testimonyModel = new TestimonyModel();
		testimonyModel.setCreatedBy(idUser);
		testimonyModel.setCreatedOn(new Date());
		testimonyModel.setTitle(title);
		testimonyModel.setContent(content);
		testimonyModel.setIsDeleted(isDeleted);
		
		this.testimonyService.create(testimonyModel);
		
		String jsp = "testimony/testimony";
		return jsp;
	}
	
	@RequestMapping(value="testimony/editTestimony")
	public String editTestimony(HttpServletRequest request, Model model) {
		Long id = new Long(request.getParameter("idEdit"));
		TestimonyModel testimonyModel = new TestimonyModel();
		testimonyModel = this.testimonyService.searchById(id);
		
		model.addAttribute("testimonyModel", testimonyModel);
		
		List<TestimonyModel> testimonyModelList = new ArrayList<TestimonyModel>();
		testimonyModelList = this.testimonyService.showAll();
		model.addAttribute("testimonyModelList", testimonyModelList);
		
		String jsp = "testimony/editTestimony";
		return jsp;
	}
	
	@RequestMapping(value="testimony/editTestimony/save")
	public String editSaveTestimony(HttpServletRequest request) {
		Long idTestimony = new Long(request.getParameter("idTestimony"));
		String title = request.getParameter("testimonyTitle");
		String content = request.getParameter("testimonyContent");
		Integer isDeleted = 0;
		Long idUser = this.getAkunModel().getId();
		
		TestimonyModel testimonyModel = new TestimonyModel();
		testimonyModel = this.testimonyService.searchById(idTestimony);
		
		testimonyModel.setIdTestimony(idTestimony);
		testimonyModel.setModifiedBy(idUser);
		testimonyModel.setModifiedOn(new Date());
		testimonyModel.setTitle(title);
		testimonyModel.setContent(content);
		testimonyModel.setIsDeleted(isDeleted);
		
		this.testimonyService.edit(testimonyModel);
		
		String jsp = "testimony/testimony";
		return jsp;
	}
	
	@RequestMapping(value="testimony/searchTestimony/title")
	public String searchTestimony(HttpServletRequest request, Model model) {
		String title = request.getParameter("searchTitle");
		List<TestimonyModel> testimonyModelList = new ArrayList<TestimonyModel>();
		testimonyModelList = this.testimonyService.searchBy(title);
		model.addAttribute("testimonyModelList", testimonyModelList);
		
		String jsp = "testimony/listTestimony";
		return jsp;
	}
	
	@RequestMapping(value="testimony/deleteTestimony")
	public String deleteTestimony(HttpServletRequest request, Model model) {
		Long id = new Long(request.getParameter("idDelete"));
		TestimonyModel testimonyModel = new TestimonyModel();
		testimonyModel = this.testimonyService.searchById(id);
		
		model.addAttribute("testimonyModel", testimonyModel);
		
		List<TestimonyModel> testimonyModelList = new ArrayList<TestimonyModel>();
		testimonyModelList = this.testimonyService.showAll();
		model.addAttribute("testimonyModelList", testimonyModelList);
		
		String jsp = "testimony/deleteTestimony";
		return jsp;
	}
	
	@RequestMapping(value="testimony/deleteTestimony/save")
	public String deleteSaveTestimony(HttpServletRequest request, Model model) {
		Long idTestimony = new Long(request.getParameter("idTestimony"));
		String title = request.getParameter("testimonyTitle");
		String content = request.getParameter("testimonyContent");
		Integer isDeleted = 1;
		Long idUser = this.getAkunModel().getId();
		
		TestimonyModel testimonyModel = new TestimonyModel();
		testimonyModel = this.testimonyService.searchById(idTestimony);
		model.addAttribute("testimonyModel", testimonyModel);
		
		testimonyModel.setIdTestimony(idTestimony);
		testimonyModel.setDeletedBy(idUser);
		testimonyModel.setDeletedOn(new Date());
		testimonyModel.setTitle(title);
		testimonyModel.setContent(content);
		testimonyModel.setIsDeleted(isDeleted);
		testimonyModel.setDeletedOn(new Date());
		
		this.testimonyService.edit(testimonyModel);
		
		String jsp = "testimony/testimony";
		return jsp;
	}
}
