package com.spring.miniproject.service;

import java.util.List;

import com.spring.miniproject.model.IdleNewsModel;

public interface IdleNewsService {
	public void create(IdleNewsModel idlenewsModel);
	public List<IdleNewsModel> searchAll();

}
