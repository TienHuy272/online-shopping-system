package com.fa.mock.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.mock.dao.ManufacturerDAO;
import com.fa.mock.model.Manufacturer;
import com.fa.mock.service.ManufacturerService;

@Service("manufacturerService")
public class ManufacturerServiceImpl implements ManufacturerService{

	@Autowired
	private ManufacturerDAO manufacturerDAO;
	
	@Override
	public List<Manufacturer> getAllManufacturer() {
		return manufacturerDAO.getAll();
	}

}
