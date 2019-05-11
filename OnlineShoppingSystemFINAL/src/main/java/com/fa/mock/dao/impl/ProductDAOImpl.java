package com.fa.mock.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fa.mock.abstractdao.AbstractGenricDAOImpl;
import com.fa.mock.common.Constant;
import com.fa.mock.dao.CategoryDAO;
import com.fa.mock.dao.ManufacturerDAO;
import com.fa.mock.dao.ProductDAO;
import com.fa.mock.model.Product;

@Repository("productDAO")
@Transactional
@SuppressWarnings("unchecked")
public class ProductDAOImpl extends AbstractGenricDAOImpl<Product> implements ProductDAO {
	Logger logger = Logger.getLogger(ProductDAOImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	ManufacturerDAO manufacturerDAO;


	@Override
	public List<Product> getListProductByCategory(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(Constant.GET_LIST_PRODUCT_BY_CATEGORY);
		query.setInteger("Category_Id", id);
		return query.list();
	}

	@Override
	public List<Product> getListProductByManufacturer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(Constant.GET_LIST_PRODUCT_BY_MANUFACTURER);
		query.setInteger("Manufacturer_Id", id);
		return query.list();
	}

	@Override
	public List<Product> getAllProductPagination(int maxResult, int offSet) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Product");

		ScrollableResults resultScroll = query.scroll(ScrollMode.SCROLL_INSENSITIVE);
		resultScroll.setRowNumber(offSet);
		resultScroll.scroll(0);
		List<Product> listProduct = new ArrayList<>();
		int i = 0;
		while (maxResult > i) {
			listProduct.add((Product) resultScroll.get(0));
			if (!resultScroll.next()) {
				break;
			}
			i++;
		}
		return listProduct;
	}

	@Override
	public long countTotalProducts() {
		Session session = sessionFactory.getCurrentSession();
		Long count = (Long) session.createQuery(Constant.COUNT_TOTAL_PRODUCT).uniqueResult();
		return count;
	}

	@Override
	public List<Product> findProductByName(String productName) {
		productName = "%" + productName + "%";
		List<Product> listFindProductByName = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(Constant.FIND_PRODUCT_BY_NAME);
			query.setParameter("productName", productName);
			listFindProductByName = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return listFindProductByName;
	}

	@Override
	public List<Product> searchProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}
}
