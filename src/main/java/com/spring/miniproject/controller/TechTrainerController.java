package com.spring.miniproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.spring.miniproject.model.TechnologyTrainerModel;
import com.spring.miniproject.model.TrainerModel;
import com.spring.miniproject.service.SequenceService;
import com.spring.miniproject.service.TechnologyTrainerService;
import com.spring.miniproject.service.TrainerService;

@Controller
public class TechTrainerController {
	
	@Autowired
	private TechnologyTrainerService technologyTrainerService;
	
	@Autowired
	private SequenceService sequenceService;
	
	@Autowired
	private TrainerService trainerService;
	
	@RequestMapping(value="technology/addTechTrainer")
	public String addTechTrainer(Model model) {
		this.listTrainer(model);
		
		String jsp="technology/addTechTrainer";
		return jsp;
	}
	
	public void listTrainer(Model model) {
		List<TrainerModel> trainerModelList = new ArrayList<TrainerModel>();
		trainerModelList = this.trainerService.showAll();
		model.addAttribute("trainerModelList", trainerModelList);
	}
	
	@RequestMapping(value="technology/listTechTrainer")
	public String listTechTrainer(Model model) {
		List<TechnologyTrainerModel> technologyTrainerModelList = new ArrayList<TechnologyTrainerModel>();
		technologyTrainerModelList = this.technologyTrainerService.showAll();
		model.addAttribute("technologyTrainerModelList", technologyTrainerModelList);
		
		String jsp = "technology/listTechTrainer";
		return jsp;
	}
}
