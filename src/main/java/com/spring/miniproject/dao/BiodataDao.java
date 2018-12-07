package com.spring.miniproject.dao;

import java.util.List;

import com.spring.miniproject.model.BiodataModel;
import com.spring.miniproject.model.BiodataModel;

public interface BiodataDao {
	
	/*Biodata Add*/
	public void create(BiodataModel biodataModel);
	
	/*Biodata List*/
	public List<BiodataModel> searchAll();
	
	/*Select Biodata to Modify*/
	public BiodataModel searchById(Long id);
	
	/*Biodata Edit*/
	public void update(BiodataModel biodataModel);
	
	/*Biodata Search*/
	public List<BiodataModel> searchByLikeName(String name);
	
	/*Biodata Deactivate*/
	public void deactivate(BiodataModel biodataModel);
	
}
