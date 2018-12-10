package com.spring.miniproject.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.miniproject.model.BiodataModel;
import com.spring.miniproject.model.BootcampTestTypeModel;
import com.spring.miniproject.service.BiodataService;
import com.spring.miniproject.service.BootcampTestTypeService;

@Controller
public class BiodataController extends BaseController {

	@Autowired
	private BiodataService biodataService;

	@Autowired
	private BootcampTestTypeService bootcampTestTypeService;

	/* Menu Biodata */
	@RequestMapping(value = "biodata")
	public String biodata(Model model) {
		String jsp = "biodata/biodata";
		return jsp;
	}

	/* List Biodata */
	@RequestMapping(value = "biodata/list")
	public String listbiodata(Model model) {
		List<BiodataModel> biodataModelList = new ArrayList<BiodataModel>();
		biodataModelList = this.biodataService.searchAll();
		model.addAttribute("biodataModelList", biodataModelList);
		String jsp = "biodata/list";
		return jsp;
	}

	/* Popup Add Biodata */
	@RequestMapping(value = "biodata/tambah")
	public String tambahbiodata(Model model) {
		String jsp = "biodata/tambah";
		return jsp;
	}

	/* Create Biodata */
	@RequestMapping(value = "biodata/create")
	public String create(HttpServletRequest request, Model model) {

		/* Logged ID */
		Long createdBy = this.getAkunModel().getId();

		BiodataModel biodataModel = new BiodataModel();
		biodataModel.setName(request.getParameter("name"));
		biodataModel.setLastEducation(request.getParameter("lastEducation"));
		biodataModel.setEducationalLevel(request.getParameter("educationalLevel"));
		biodataModel.setGraduationYear(request.getParameter("graduationYear"));
		biodataModel.setMajors(request.getParameter("majors"));
		biodataModel.setGpa(request.getParameter("gpa"));
		biodataModel.setCreatedBy(createdBy);
		biodataModel.setCreatedOn(new Date());
		biodataModel.setActive(1);

		this.biodataService.create(biodataModel);
		model.addAttribute("biodataModel", biodataModel);

		String jsp = "biodata/biodata";
		return jsp;
	}

	/* Popup Edit Biodata */
	@RequestMapping(value = "biodata/edit")
	public String biodataEdit(HttpServletRequest request, Model model) {
		Long id = Long.valueOf(request.getParameter("id"));
		BiodataModel biodataModel = new BiodataModel();
		biodataModel = this.biodataService.searchById(id);
		model.addAttribute("biodataModel", biodataModel);

		/* Dropdown List */
		this.listbootcampTestType(model);

		String jsp = "biodata/edit";
		return jsp;
	}

	/* List BootcampTestType for BootcampTestType Dropdown */
	private void listbootcampTestType(Model model) {
		// TODO Auto-generated method stub
		List<BootcampTestTypeModel> bootcampTestTypeModelList = new ArrayList<BootcampTestTypeModel>();
		bootcampTestTypeModelList = this.bootcampTestTypeService.searchAll();
		model.addAttribute("bootcampTestTypeModelList", bootcampTestTypeModelList);
	}

	/* Edit Biodata */
	@RequestMapping(value = "biodata/edit/save")
	public String biodataEditSave(HttpServletRequest request, Model model) throws Exception {

		/* Logged ID */
		Long modifiedBy = this.getAkunModel().getId();

		/* biodataId */
		Long id = Long.valueOf(request.getParameter("id"));
		Long bootcampTestType = Long.valueOf(request.getParameter("bootcampTestType"));

		Integer iq = Integer.valueOf(request.getParameter("iq"));
		Integer nl = Integer.valueOf(request.getParameter("nl"));
		Integer jt = Integer.valueOf(request.getParameter("jt"));
		Integer arithmetic = Integer.valueOf(request.getParameter("arithmetic"));

		/* Get Old Value */
		String name = request.getParameter("name");
		String lastEducation = request.getParameter("lastEducation");
		String educationalLevel = request.getParameter("educationalLevel");
		String graduationYear = request.getParameter("graduationYear");
		String majors = request.getParameter("majors");
		String gpa = request.getParameter("gpa");

		/* New Model */
		BiodataModel biodataModelDB = new BiodataModel();
		biodataModelDB = this.biodataService.searchById(id);

		/* New Value */
		biodataModelDB.setName(name);
		biodataModelDB.setLastEducation(lastEducation);
		biodataModelDB.setEducationalLevel(educationalLevel);
		biodataModelDB.setGraduationYear(graduationYear);
		biodataModelDB.setMajors(majors);
		biodataModelDB.setGpa(gpa);

		biodataModelDB.setGender(request.getParameter("gender"));
		biodataModelDB.setBootcampTestType(bootcampTestType);
		biodataModelDB.setIq(iq);
		biodataModelDB.setDu(request.getParameter("du"));
		biodataModelDB.setNestedLogic(nl);
		biodataModelDB.setJoinTable(jt);
		biodataModelDB.setArithmetic(arithmetic);
		biodataModelDB.setTro(request.getParameter("tro"));
		biodataModelDB.setInterviewer(request.getParameter("interviewer"));
		biodataModelDB.setNotes(request.getParameter("notes"));

		biodataModelDB.setModifiedBy(modifiedBy);
		biodataModelDB.setModifiedOn(new Date());

		this.biodataService.update(biodataModelDB);
		model.addAttribute("biodataModelDB", biodataModelDB);

		String jsp = "biodata/biodata";
		return jsp;
	}

	/* Popup Deactivate Biodata */
	@RequestMapping(value = "biodata/deactivate")
	public String deactivate(HttpServletRequest request, Model model) {

		/* Biodata ID */
		String id = request.getParameter("id");

		BiodataModel biodataModel = new BiodataModel();
		biodataModel = this.biodataService.searchById(Long.parseLong(id));
		model.addAttribute("biodataModel", biodataModel);
		String jsp = "biodata/deactivate";
		return jsp;
	}

	/* Deactivate Biodata */
	@RequestMapping(value = "biodata/deactivate/save")
	public String deactivateSave(HttpServletRequest request) {

		/* Logged ID */
		Long modifiedBy = this.getAkunModel().getId();

		/* Biodata ID */
		String id = request.getParameter("id");

		BiodataModel biodataModel = new BiodataModel();
		biodataModel.setActive(0);
		biodataModel.setModifiedBy(modifiedBy);
		biodataModel.setModifiedOn(new Date());

		biodataModel = this.biodataService.searchById(Long.parseLong(id));
		this.biodataService.deactivate(biodataModel);

		String jsp = "biodata/biodata";
		return jsp;
	}

	/* Search Biodata */
	@RequestMapping(value = "biodata/search/name")
	public String biodataSearchName(HttpServletRequest request, Model model) {
		String name = request.getParameter("nameCari");
		List<BiodataModel> biodataModelList = new ArrayList<BiodataModel>();
		biodataModelList = this.biodataService.searchByLikeName(name);
		model.addAttribute("biodataModelList", biodataModelList);
		String jsp = "biodata/list";
		return jsp;
	}

}
