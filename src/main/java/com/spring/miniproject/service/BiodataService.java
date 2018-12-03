package com.spring.miniproject.service;

import java.util.List;

import com.spring.miniproject.model.BiodataModel;

public interface BiodataService {
	public void create(BiodataModel biodataModel);
	public List<BiodataModel> searchAll();
}
