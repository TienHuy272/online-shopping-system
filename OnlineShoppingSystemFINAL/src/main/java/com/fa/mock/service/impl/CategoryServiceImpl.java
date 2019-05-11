package com.fa.mock.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.mock.dao.CategoryDAO;
import com.fa.mock.model.Category;
import com.fa.mock.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Override
	public List<Category> getAllCategory() {
		return categoryDAO.getAll();
	}

}
