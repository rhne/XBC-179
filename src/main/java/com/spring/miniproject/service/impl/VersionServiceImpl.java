package com.spring.miniproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.miniproject.dao.VersionDao;
import com.spring.miniproject.model.VersionModel;
import com.spring.miniproject.service.VersionService;

@Service
@Transactional
public class VersionServiceImpl implements VersionService {

	@Autowired
	private VersionDao versionDao;
	
	@Override
	public List<VersionModel> searchAll() {
		return this.versionDao.searchAll();
	}

	@Override
	public VersionModel create(VersionModel versionModel) {
		return this.versionDao.create(versionModel);
	}

	@Override
	public VersionModel searchById(Long id) {
		return this.versionDao.searchById(id);
	}

	@Override
	public void update(VersionModel versionModel) {
		this.versionDao.update(versionModel);
	}

	@Override
	public void delete(VersionModel versionModel) {
		this.versionDao.delete(versionModel);
	}

	@Override
	public Integer getLatestVersion() {
		return this.versionDao.getLatestVersion();
	}

	@Override
	public VersionModel getLatestVersionModel() {
		return this.versionDao.getLatestVersionModel();
	}

}
