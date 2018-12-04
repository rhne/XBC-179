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
		Integer idTrainer = this.sequenceService.nextIdTrainer();
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
}