package com.spring.miniproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.miniproject.model.TrainerModel;
import com.spring.miniproject.service.SequenceService;
import com.spring.miniproject.service.TrainerService;

@Controller
public class TrainerController {

	@Autowired
	private TrainerService trainerService;
	
	@Autowired
	private SequenceService sequenceService;
	
	@RequestMapping(value="trainer")
	public String homeTrainer() {
		String jsp = "trainer/trainer";
		return jsp;
	}
	
	@RequestMapping(value="trainer/addTrainer")
	public String addTrainer() {
		String jsp = "trainer/addTrainer";
		return jsp;
	}
	
	@RequestMapping(value="trainer/addTrainer/save")
	public String addSaveTrainer(HttpServletRequest request, Model model) {
		Long idTrainer = new Long(this.sequenceService.nextIdTrainer());
		model.addAttribute("idTrainer", idTrainer);
		
		String name = request.getParameter("trainerName");
		String notes = request.getParameter("trainerNote");	
		String createdBy = request.getParameter("createdBy");
		Integer active = Integer.valueOf(request.getParameter("trainerStatus"));
		
		TrainerModel trainerModel = new TrainerModel();
		trainerModel.setIdTrainer(idTrainer);
		trainerModel.setName(name);
		trainerModel.setNotes(notes);
		trainerModel.setCreatedBy(createdBy);
		trainerModel.setActive(active);
		
		this.trainerService.create(trainerModel);
		
		String jsp = "trainer/trainer";
		return jsp;
	}
	
	@RequestMapping(value="trainer/listTrainer")
	public String listTrainer(Model model) {
		List<TrainerModel> trainerModelList = new ArrayList<TrainerModel>();
		trainerModelList = this.trainerService.showAll();
		
		model.addAttribute("trainerModelList", trainerModelList);
		
		String jsp = "trainer/listTrainer";
		return jsp;
	}
	
	@RequestMapping(value="trainer/searchTrainer/name")
	public String searchTrainer(HttpServletRequest request, Model model) {
		String name = request.getParameter("searchName");
		List<TrainerModel> trainerModelList = new ArrayList<TrainerModel>();
		trainerModelList = this.trainerService.searchBy(name);
		model.addAttribute("trainerModelList", trainerModelList);
		
		String jsp = "trainer/listTrainer";
		return jsp;
	}
	
	@RequestMapping(value="trainer/editTrainer")
	public String editTrainer(HttpServletRequest request, Model model) {
		Long id = new Long(request.getParameter("idEdit"));
		TrainerModel trainerModel = new TrainerModel();
		trainerModel = this.trainerService.searchById(id);
		
		model.addAttribute("trainerModel", trainerModel);
		
		List<TrainerModel> trainerModelList = new ArrayList<TrainerModel>();
		trainerModelList = this.trainerService.showAll();
		model.addAttribute("trainerModelList", trainerModelList);
		
		String jsp = "trainer/editTrainer";
		return jsp;
	}
	
	@RequestMapping(value="trainer/editTrainer/save")
	public String editSaveTrainer(HttpServletRequest request, Model model) {
		Long idTrainer = new Long(this.sequenceService.nextIdTrainer());
		model.addAttribute("idTrainer", idTrainer);
		
		String name = request.getParameter("trainerName");
		String notes = request.getParameter("trainerNote");	
		String modifiedBy = request.getParameter("modifiedBy");
		Integer active = Integer.valueOf(request.getParameter("trainerStatus"));
		
		TrainerModel trainerModel = new TrainerModel();
		trainerModel.setIdTrainer(idTrainer);
		trainerModel.setName(name);
		trainerModel.setNotes(notes);
		trainerModel.setModifiedBy(modifiedBy);
		trainerModel.setActive(active);
		
		this.trainerService.edit(trainerModel);
		
		String jsp = "trainer/trainer";
		return jsp;
	}
}
