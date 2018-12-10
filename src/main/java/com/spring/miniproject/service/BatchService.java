package com.spring.miniproject.service;

import java.util.List;

import com.spring.miniproject.model.BatchModel;

public interface BatchService {
	public void create(BatchModel batchModel);
	public void edit(BatchModel batchModel);
	public List<BatchModel> showAll();
	public BatchModel searchById(Long idBatch);
	public List<BatchModel> searchBy(String nameTech);
}
