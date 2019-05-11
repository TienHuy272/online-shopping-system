package com.fa.mock.abstractdao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fa.mock.genericdao.IGenericDAO;

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

	public Serializable insert(E entity) {
		return factory.getCurrentSession().save(entity);
	}

	@Override
	public boolean delete(E enity) {
		boolean result = false;
		try {
			factory.getCurrentSession().delete(enity) ;
			result = true;
		} catch(HibernateException e) {
			result = false;
		}
		return result;
	}

	@Override
	public boolean update(E entity) {
		boolean result = false;
		try {
			factory.getCurrentSession().update(entity);
			result = true;
		} catch(HibernateException e) {
			result = false;
		}
		return result;
		
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
	public boolean deleteAll() {
		boolean result = false;
		List<E> entities = getAll();
		try {
			for (E entity : entities) {
				factory.getCurrentSession().delete(entity);
			}
			result = true;
		} catch(HibernateException e) {
			result = false;
		}
		return result;
	}

	@Override
	public List<E> findAllByExample(E entity) {
		Example example = Example.create(entity).ignoreCase().enableLike().excludeZeroes();
		return factory.getCurrentSession().createCriteria(this.entityClass).add(example).list();
	}

}
