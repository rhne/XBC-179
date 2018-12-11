package com.spring.miniproject.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.spring.miniproject.model.CategoryModel;
import com.spring.miniproject.model.MenuModel;
import com.spring.miniproject.model.OfficeModel;
import com.spring.miniproject.model.RoomModel;
import com.spring.miniproject.service.MenuService;
import com.spring.miniproject.service.OfficeService;
import com.spring.miniproject.service.RoomService;

@Controller
public class OfficeController extends BaseController{

	@Autowired
	private MenuService menuService;
	
	@Autowired
	private OfficeService officeService;
	
	@Autowired
	private RoomService roomService;
	
	public void aksesLogin(Model model) {
		
		model.addAttribute("username", this.getAkunModel().getName());
		model.addAttribute("nameRole", this.getAkunModel().getRoleModel().getName());
		
		List<MenuModel> menuModelList = null;
		Long idRole = this.getAkunModel().getRoleModel().getId();
		menuModelList = this.menuService.selectMenuByRole(idRole);
		model.addAttribute("menuModelList", menuModelList);
	}
	
	@RequestMapping(value="office")
	public String user(Model model) {
		this.aksesLogin(model);
		String jsp = "office/office";
		return jsp;
	}
	
	@RequestMapping(value="office/tambah")
	public String tambahoffice(Model model) {
		
		String jsp = "office/tambah";
		return jsp;
	}	
		
	@RequestMapping(value="office/create")
	public String create(HttpServletRequest request, Model model) throws Exception{
		String jsonRoomString = request.getParameter("rooms");
		JsonParser jsonParser = new JsonParser();
		Object obj = jsonParser.parse(jsonRoomString);
		JsonArray roomArray = (JsonArray) obj;
		JsonObject jsonObject = new JsonObject();
		
		OfficeModel officeModel = new OfficeModel();
		officeModel.setName(request.getParameter("name"));		
		officeModel.setPhone(request.getParameter("phone"));
		officeModel.setEmail(request.getParameter("email"));
		officeModel.setAddress(request.getParameter("address"));
		officeModel.setNotes(request.getParameter("notes"));
		officeModel.setIsActive(1);
		Long createdBy = this.getAkunModel().getId();
		officeModel.setCreatedBy(createdBy);
		officeModel.setCreatedOn(new Date());
		
		this.officeService.create(officeModel);
		model.addAttribute("officeModel", officeModel);
		//create VersionDetail instances in table
			RoomModel roomModel;
			for(int i=0; i<roomArray.size(); i++) {
				jsonObject = (JsonObject) roomArray.get(i);
				roomModel = new RoomModel();
				String code = jsonObject.get("code").getAsString();
				String name = jsonObject.get("name").getAsString();
				Integer capacity = jsonObject.get("capacity").getAsInt();
				Integer projector = jsonObject.get("projector").getAsInt();
				String notes = jsonObject.get("notes").getAsString();
					
				roomModel = new RoomModel();
				roomModel.setCode(code);
				roomModel.setName(name);
				roomModel.setCapacity(capacity);
				roomModel.setProjector(projector);
				roomModel.setNotes(notes);
				roomModel.setIdOffice(officeModel.getId());
				roomModel.setCreatedBy(createdBy);
				roomModel.setCreatedOn(new Date());
				roomModel = this.roomService.create(roomModel);
					//versionModel.getVersionDetails().add(versionDetailModel);
				}
		
		String jsp = "office/office";
		return jsp;
	}
	
	@RequestMapping(value="office/list")
	public String listoffice(Model model) {
		List<OfficeModel> officeModelList = new ArrayList<OfficeModel>();
		officeModelList = this.officeService.searchAll();
		model.addAttribute("officeModelList", officeModelList);
		String jsp = "office/list";
		return jsp;
	}
	@RequestMapping(value="office/search/name")
	public String officeSearchName(HttpServletRequest request, Model model) {
		String name = request.getParameter("nameCari");
		List<OfficeModel> officeModelList = new ArrayList<OfficeModel>();
		officeModelList = this.officeService.searchByLikeName(name);
		model.addAttribute("officeModelList", officeModelList);
		String jsp = "office/list";
		return jsp;
	}
	@RequestMapping (value="office/delete")
	public String delete(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		OfficeModel officeModel = new OfficeModel();
		officeModel = this.officeService.searchById(Long.parseLong(id));
		model.addAttribute("officeModel", officeModel);
		String jsp = "office/delete";
		return jsp;
	}
	
	@RequestMapping (value="office/delete/save")
	public String delete(HttpServletRequest request) {
		String id = request.getParameter("id");
		OfficeModel officeModel = new OfficeModel();
		officeModel = this.officeService.searchById(Long.parseLong(id));
		this.officeService.delete(officeModel);
		
		String jsp = "office/office";
		return jsp;
	}
	//edit
	@RequestMapping(value="office/edit")
	public String Edit(HttpServletRequest request, Model model) {
		String id = (request.getParameter("id"));
		OfficeModel officeModel = new OfficeModel();
		officeModel = this.officeService.searchById(Long.parseLong(id));
		model.addAttribute("officeModel", officeModel);
		String jsp = "office/edit";
		return jsp;
	}
	
	
	@RequestMapping(value="office/edit/save")
	public String EditSave(HttpServletRequest request, Model model) throws Exception{
		String id = request.getParameter("id");
		OfficeModel officeModel = new OfficeModel();
		officeModel = this.officeService.searchById(Long.parseLong(id));		
		officeModel.setName(request.getParameter("office-name"));		
		officeModel.setPhone(request.getParameter("phone"));
		officeModel.setEmail(request.getParameter("email"));
		officeModel.setAddress(request.getParameter("address"));
		officeModel.setNotes(request.getParameter("office-notes"));
		Long modifiedBy = this.getAkunModel().getId();
		officeModel.setModifiedBy(modifiedBy);
		
		this.officeService.update(officeModel);
		model.addAttribute("officeModel", officeModel);
		
		String jsp = "office/office";
		return jsp;
	}
}
