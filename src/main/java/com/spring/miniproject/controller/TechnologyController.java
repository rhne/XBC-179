package com.spring.miniproject.controller;

import java.util.ArrayList;
import java.util.List;

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
	public String addTechnology(Model model) {
		Integer idTech = 0;
		idTech = this.sequenceService.nextIdTechnology();
		model.addAttribute("idTech", idTech);
		
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
}
