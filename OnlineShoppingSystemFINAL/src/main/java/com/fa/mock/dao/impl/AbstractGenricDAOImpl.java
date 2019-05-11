package com.fa.mock.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fa.mock.dao.IGenericDAO;

@SuppressWarnings("unchecked")
@Repository("genericDAO ")
@Transactional
public abstract class AbstractGenricDAOImpl<E> implements IGenericDAO<E> {

	protected Class<E> entityClass;

	public AbstractGenricDAOImpl() {
		this.entityClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@Autowired
	private SessionFactory factory;

	@Override
	public Serializable insert(E entity) {
		return factory.getCurrentSession().save(entity);
	}

	@Override
	public void delete(E enity) {
		factory.getCurrentSession().delete(enity);
	}

	@Override
	public void update(E entity) {
		factory.getCurrentSession().update(entity);
	}

	@Override
	public List<E> getAll() {
		return factory.getCurrentSession().createCriteria(entityClass).list();
	}

	@Override
	public E find(Serializable id) {
		return (E) factory.getCurrentSession().get(entityClass, id);
	}

	@Override
	public void deleteAll() {
		List<E> entities = getAll();
		for (E entity : entities) {
			factory.getCurrentSession().delete(entity);
		}
	}

	@Override
	public List<E> findAllByExample(E entity) {
		Example example = Example.create(entity).ignoreCase().enableLike().excludeZeroes();
		return factory.getCurrentSession().createCriteria(this.entityClass).add(example).list();
	}

}
