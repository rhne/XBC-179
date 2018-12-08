package com.spring.miniproject.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.miniproject.model.BatchModel;
import com.spring.miniproject.model.BootcampTypeModel;
import com.spring.miniproject.model.RoomModel;
import com.spring.miniproject.model.TechnologyModel;
import com.spring.miniproject.model.TrainerModel;
import com.spring.miniproject.service.BatchService;
import com.spring.miniproject.service.BootcampTypeService;
import com.spring.miniproject.service.RoomService;
import com.spring.miniproject.service.SequenceService;
import com.spring.miniproject.service.TechnologyService;
import com.spring.miniproject.service.TrainerService;

@Controller
public class BatchController {

	@Autowired
	private BatchService batchService;
	
	@Autowired
	private SequenceService sequenceService;
	
	@Autowired
	private TechnologyService technologyService;
	
	@Autowired
	private TrainerService trainerService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private BootcampTypeService bootcampTypeService;
	
	
	@RequestMapping(value="batch")
	public String homeBatch() {
		String jsp = "batch/batch";
		return jsp;
	}
	
	@RequestMapping(value="batch/listBatch")
	public String listBatch(Model model) {
		List<TechnologyModel> technologyModelList = new ArrayList<TechnologyModel>();
		List<TrainerModel> trainerModelList = new ArrayList<TrainerModel>();
		List<RoomModel> roomModelList = new ArrayList<RoomModel>();
		List<BootcampTypeModel> bootcampTypeModelList = new ArrayList<BootcampTypeModel>();
		
		technologyModelList = this.technologyService.showAll();
		trainerModelList = this.trainerService.showAll();
		roomModelList = this.roomService.searchAll();
		bootcampTypeModelList = this.bootcampTypeService.showAll();
		
		model.addAttribute("technologyModelList", technologyModelList);
		model.addAttribute("trainerModelList", trainerModelList);
		model.addAttribute("roomModelList", roomModelList);
		model.addAttribute("bootcampTypeModelList", bootcampTypeModelList);
		
		String jsp = "batch/listBatch";
		return jsp;
	}
	
	@RequestMapping(value="batch/addBatch")
	public String addBatch(Model model) {
		List<TechnologyModel> technologyModelList = new ArrayList<TechnologyModel>();
		List<TrainerModel> trainerModelList = new ArrayList<TrainerModel>();
		List<RoomModel> roomModelList = new ArrayList<RoomModel>();
		List<BootcampTypeModel> bootcampTypeModelList = new ArrayList<BootcampTypeModel>();
		
		technologyModelList = this.technologyService.showAll();
		trainerModelList = this.trainerService.showAll();
		roomModelList = this.roomService.searchAll();
		bootcampTypeModelList = this.bootcampTypeService.showAll();

		model.addAttribute("technologyModelList", technologyModelList);
		model.addAttribute("trainerModelList", trainerModelList);
		model.addAttribute("roomModelList", roomModelList);
		model.addAttribute("bootcampTypeModelList", bootcampTypeModelList);

		
		String jsp = "batch/addBatch";
		return jsp;
	}
	
//	@RequestMapping(value="batch/listBatch2")
//	public String listBatch2(Model model) {
//		List<BatchModel> batchModelList = new ArrayList<BatchModel>();
//		batchModelList = this.batchService.showAll();
//		model.addAttribute("batchModelList", batchModelList);
//		
//		String jsp = "batch/listBatch2";
//		return jsp;
//	}
	
	@RequestMapping(value="batch/addBatch/save")
	public String addSaveBatch(HttpServletRequest request, Model model) throws ParseException {
		Long idBatch = new Long(this.sequenceService.nextIdBatch());
		model.addAttribute("idBatch", idBatch);
		Long idTech = new Long(request.getParameter("idTechnology"));
		Long idTrainer = new Long(request.getParameter("idTrainer"));
		String name = request.getParameter("batchName");
		Date from = new SimpleDateFormat("DD-MM-YY").parse(request.getParameter("batchStart"));
		Date to = new SimpleDateFormat("DD-MM-YY").parse(request.getParameter("batchEnd"));
		Long idRoom = new Long(request.getParameter("idRoom"));
		Long idBootcamp = new Long(request.getParameter("idBootcamp"));
		String notes = request.getParameter("batchNotes");
		
		BatchModel batchModel = new BatchModel();
		batchModel.setBatchId(idBatch);
		batchModel.setTechnologyId(idTech);
		batchModel.setTrainerId(idTrainer);
		batchModel.setName(name);
		batchModel.setPeriodFrom(from);
		batchModel.setPeriodTo(to);
		batchModel.setRoomId(idRoom);
		batchModel.setBootcampId(idBootcamp);
		batchModel.setNotes(notes);
		
		this.batchService.create(batchModel);
		
		String jsp = "batch/batch";
		return jsp;
	}
	
	//LIST
	public void listTechnology(Model model) {
		List<TechnologyModel> technologyModelList = new ArrayList<TechnologyModel>();
		technologyModelList = this.technologyService.showAll();
		model.addAttribute("technologyModelList", technologyModelList);
	}
	
	public void listTrainer(Model model) {
		List<TrainerModel> trainerModelList = new ArrayList<TrainerModel>();
		trainerModelList = this.trainerService.showAll();
		model.addAttribute("trainerModelList", trainerModelList);
	}
	
	public void listRoom(Model model) {
		List<RoomModel> roomModelList = new ArrayList<RoomModel>();
		roomModelList = this.roomService.searchAll();
		model.addAttribute("roomModelList", roomModelList);
	}
	
	public void listBootcamp(Model model) {
		List<BootcampTypeModel> bootcampTypeModelList = new ArrayList<BootcampTypeModel>();
		bootcampTypeModelList = this.bootcampTypeService.showAll();
		model.addAttribute("bootcampTypeModelList", bootcampTypeModelList);
	}
	
}
