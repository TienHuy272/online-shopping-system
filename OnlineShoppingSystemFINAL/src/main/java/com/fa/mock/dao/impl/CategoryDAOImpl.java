package com.fa.mock.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fa.mock.abstractdao.AbstractGenricDAOImpl;
import com.fa.mock.dao.CategoryDAO;
import com.fa.mock.model.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl extends AbstractGenricDAOImpl<Category> implements CategoryDAO{

}
