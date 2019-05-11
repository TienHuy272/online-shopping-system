package com.fa.mock.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fa.mock.dao.IGenericDAO;
import com.fa.mock.service.IGenericService;

@Service
public abstract class AbstractGenericServiceImpl<E> implements IGenericService<E> {
	
	@Autowired
	private IGenericDAO<E> genericDAO;

	@Override
	public Serializable insert(E entity) {
		return genericDAO.insert(entity);
	}

	@Override
	public void delete(E enity) {
		genericDAO.delete(enity);
	}

	@Override
	public void update(E entity) {
		genericDAO.update(entity);
	}

	@Override
	public List<E> getAll() {
		return genericDAO.getAll();
	}

	@Override
	public E find(Serializable id) {
		return genericDAO.find(id);
	}


	public List<E> findAllByExample(E entity){
		return genericDAO.findAllByExample(entity);
	}


	public void deleteAll() {
		genericDAO.deleteAll();
	}
	
}
