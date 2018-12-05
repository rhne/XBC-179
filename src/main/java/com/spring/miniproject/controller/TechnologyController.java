package com.spring.miniproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.miniproject.model.TechnologyModel;
import com.spring.miniproject.service.SequenceService;
import com.spring.miniproject.service.TechnologyService;

@Controller
public class TechnologyController {
	
	@Autowired
	private TechnologyService technologyService;
	
	@Autowired
	private SequenceService sequenceService;
	
	
	@RequestMapping(value="technology")
	public String homeTechnology() {
		String jsp = "technology/technology";
		return jsp;
	}
	
	@RequestMapping(value="technology/addTechnology")
	public String addTechnology() {
		String jsp="technology/addTechnology";
		return jsp;
	}
	
	@RequestMapping(value="technology/listTechnology")
	public String listTechnology(Model model) {
		List<TechnologyModel> technologyModelList = new ArrayList<TechnologyModel>();
		technologyModelList = this.technologyService.showAll();
		
		model.addAttribute("technologyModelList", technologyModelList);
		
		String jsp = "technology/listTechnology";
		return jsp;
	}
	
	@RequestMapping(value="technology/addTechnology/save")
	public String addSaveTechnology(HttpServletRequest request, Model model) {
		Long idTech = new Long(this.sequenceService.nextIdTechnology());
		model.addAttribute("idTech", idTech);
		String name = request.getParameter("techName");
		String notes = request.getParameter("techNote");
		String createdBy = request.getParameter("createdBy");
		Integer active = Integer.valueOf(request.getParameter("techStatus"));
		
		TechnologyModel technologyModel = new TechnologyModel();
		technologyModel.setIdTech(idTech);
		technologyModel.setName(name);
		technologyModel.setNotes(notes);
		technologyModel.setCreatedBy(createdBy);
		technologyModel.setActive(active);
		
		this.technologyService.create(technologyModel);
		
		String jsp = "technology/technology";
		return jsp;
	}
	
	@RequestMapping(value="technology/searchTechnology/text")
	public String searchTechnology(HttpServletRequest request, Model model) {
		String text = request.getParameter("text");
		List<TechnologyModel> technologyModelList = new ArrayList<TechnologyModel>();
		technologyModelList = this.technologyService.searchBy(text);
		model.addAttribute("technologyModelList", technologyModelList);
		
		String jsp = "technology/listTechnology";
		return jsp;
	}
}
