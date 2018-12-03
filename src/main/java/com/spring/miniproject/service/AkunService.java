package com.spring.miniproject.service;

import java.util.List;  

import com.spring.miniproject.model.AkunModel;

public interface AkunService {
	public void create(AkunModel akunModel);
	public List<AkunModel> searchAll();
}
