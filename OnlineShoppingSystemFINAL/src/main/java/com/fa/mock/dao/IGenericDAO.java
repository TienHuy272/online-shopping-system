package com.fa.mock.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<E> {

	/**
	 * @param entity
	 * @return
	 */
	Serializable insert(E entity);

	/**
	 * @param enity
	 */
	void delete(E enity);

	/**
	 * @param entity
	 */
	void update(E entity);

	/**
	 * @return
	 */
	List<E> getAll();

	/**
	 * @param id
	 * @return
	 */
	E find(Serializable id);

	/**
	* Find all records matching provided entity
	* @param entity: entity object used for search
	* @return
	*/
	List<E> findAllByExample(E entity);

	/**
	 * Delete all records
	 */
	void deleteAll();
}
