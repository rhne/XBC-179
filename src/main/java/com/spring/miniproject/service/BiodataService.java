package com.spring.miniproject.service;

import java.util.List;

import com.spring.miniproject.model.BiodataModel;

public interface BiodataService {
	
	/* Biodata Add */
	public void create(BiodataModel biodataModel);
	
	/* Biodata List */
	public List<BiodataModel> searchAll();
	
	/* Select Biodata ID to Modify */
	public BiodataModel searchById(Long id);
	
	/* Biodata Edit */
	public void update(BiodataModel biodataModel);
	
	/* Biodata Search */
	public List<BiodataModel> searchByLikeName(String name);
	
	/* Biodata Deactivate */
	public void deactivate(BiodataModel biodataModel);
	
}
