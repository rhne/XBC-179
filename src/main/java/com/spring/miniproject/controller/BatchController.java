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
import com.spring.miniproject.model.BiodataModel;
import com.spring.miniproject.model.BootcampTypeModel;
import com.spring.miniproject.model.ClazzModel;
import com.spring.miniproject.model.RoomModel;
import com.spring.miniproject.model.TechnologyModel;
import com.spring.miniproject.model.TrainerModel;
import com.spring.miniproject.service.BatchService;
import com.spring.miniproject.service.BiodataService;
import com.spring.miniproject.service.BootcampTypeService;
import com.spring.miniproject.service.ClazzService;
import com.spring.miniproject.service.RoomService;
import com.spring.miniproject.service.SequenceService;
import com.spring.miniproject.service.TechnologyService;
import com.spring.miniproject.service.TrainerService;

@Controller
public class BatchController extends BaseController {

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
	
	@Autowired
	private BiodataService biodataService;
	
	@Autowired
	private ClazzService clazzService;
	
	@RequestMapping(value="batch")
	public String homeBatch() {
		String jsp = "batch/batch";
		return jsp;
	}
	
	@RequestMapping(value="batch/listBatch")
	public String listBatch(Model model) {
		List<BatchModel> batchModelList = new ArrayList<BatchModel>();
		batchModelList = this.batchService.showAll();
		model.addAttribute("batchModelList", batchModelList);
		
		String jsp = "batch/listBatch";
		return jsp;
	}
	
	@RequestMapping(value="batch/addBatch")
	public String addBatch(Model model) {
		this.listTechnology(model);
		this.listTrainer(model);
		this.listRoom(model);
		this.listBootcamp(model);
		
		String jsp = "batch/addBatch";
		return jsp;
	}
	
	@RequestMapping(value="batch/editBatch")
	public String editBatch2(HttpServletRequest request, Model model) {
		Long idBatch = new Long(request.getParameter("idEdit"));
		BatchModel batchModel = new BatchModel();
		batchModel = this.batchService.searchById(idBatch);
		model.addAttribute("batchModel", batchModel);
		
		this.listBatch(model);
		this.listTechnology(model);
		this.listTrainer(model);
		this.listRoom(model);
		this.listBootcamp(model);
		
		
		String jsp = "batch/editBatch";
		return jsp;
	}
	
	@RequestMapping(value="batch/addBatch/save")
	public String addSaveBatch(HttpServletRequest request, Model model) throws ParseException {
		Long idTech = new Long(request.getParameter("idTechnology"));
		Long idTrainer = new Long(request.getParameter("idTrainer"));
		String name = request.getParameter("batchName");
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd");
		Date from = dateformat.parse(request.getParameter("batchStart")); 
		Date to = dateformat.parse(request.getParameter("batchEnd"));
		Long idRoom = new Long(request.getParameter("idRoom"));
		Long idBootcamp = new Long(request.getParameter("idBootcamp"));
		String notes = request.getParameter("batchNotes");
		
		Long idUser = this.getAkunModel().getId();
		
		BatchModel batchModel = new BatchModel();
		batchModel.setCreatedOn(new Date());
		batchModel.setCreatedBy(idUser);
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
	
	@RequestMapping(value="batch/editBatch/save")
	public String editSaveBatch(HttpServletRequest request, Model model) throws ParseException {
		Long idBatch = new Long(request.getParameter("idBatch"));
		BatchModel batchModel = new BatchModel();
		batchModel = this.batchService.searchById(idBatch);
		model.addAttribute("batchModel", batchModel);
		
		Long idTech = new Long(request.getParameter("idTechnology"));
		Long idTrainer = new Long(request.getParameter("idTrainer"));
		String name = request.getParameter("batchName");
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd");
		Date from = dateformat.parse(request.getParameter("batchStart")); 
		Date to = dateformat.parse(request.getParameter("batchEnd"));
		Long idRoom = new Long(request.getParameter("idRoom"));
		Long idBootcamp = new Long(request.getParameter("idBootcamp"));
		String notes = request.getParameter("batchNotes");
		Long idUser = this.getAkunModel().getId();
		
		batchModel.setModifiedBy(idUser);
		batchModel.setModifiedOn(new Date());
		batchModel.setBatchId(idBatch);
		batchModel.setTechnologyId(idTech);
		batchModel.setTrainerId(idTrainer);
		batchModel.setName(name);
		batchModel.setPeriodFrom(from);
		batchModel.setPeriodTo(to);
		batchModel.setRoomId(idRoom);
		batchModel.setBootcampId(idBootcamp);
		batchModel.setNotes(notes);
		
		this.batchService.edit(batchModel);
		
		String jsp = "batch/batch";
		return jsp;
	}
	
	@RequestMapping(value="batch/searchBatch/nameTech")
	public String searchBatch(HttpServletRequest request, Model model) {
		String search = request.getParameter("searchnameTech");
		
		List<BatchModel> batchModelList = new ArrayList<BatchModel>();
		batchModelList = this.batchService.searchBy(search);
		model.addAttribute("batchModelList", batchModelList);
		
		String jsp = "batch/listBatch";
		return jsp;
	}
	
	@RequestMapping(value="batch/addParticipant")
	public String addParticipant(HttpServletRequest request, Model model) {
		Long idBatch = new Long(request.getParameter("idAdd"));
		BatchModel batchModel = new BatchModel();
		batchModel = this.batchService.searchById(idBatch);
		model.addAttribute("batchModel", batchModel);
		
		this.listParticipant(model);
		
		String jsp = "batch/addParticipant";
		return jsp;
	}
	
	@RequestMapping(value="batch/addParticipant/save")
	public String addSaveParticipant(HttpServletRequest request, Model model) {
		Long idClazz = new Long(this.sequenceService.nextIdClazz());
		model.addAttribute("idClazz", idClazz);
		Long idBatch = new Long(request.getParameter("idBatch"));
		Long idBiodata = new Long(request.getParameter("idParticipant"));
		Long idUser = this.getAkunModel().getId();
		
		ClazzModel clazzModel = new ClazzModel();
		clazzModel.setClazzId(idClazz);
		clazzModel.setBatchId(idBatch);
		clazzModel.setBiodataId(idBiodata);
		clazzModel.setIsDeleted(0);
		clazzModel.setCreatedBy(idUser);
		clazzModel.setCreatedOn(new Date());
		
		this.clazzService.create(clazzModel);
		
		String jsp = "batch/batch";
		return jsp;
	}
	
	//LIST METHOD
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
	
	public void listParticipant(Model model) {
		List<BiodataModel> biodataModelList = new ArrayList<BiodataModel>();
		biodataModelList = this.biodataService.searchAll();
		model.addAttribute("biodataModelList", biodataModelList);
	}
	
}
