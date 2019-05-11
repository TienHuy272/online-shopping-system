package com.fa.mock.dao;

import java.util.List;

import com.fa.mock.genericdao.IGenericDAO;
import com.fa.mock.model.Product;

public interface ProductDAO extends IGenericDAO<Product> {

	public List<Product> searchProduct(Product product);

	public List<Product> getListProductByCategory(int id);

	public List<Product> getListProductByManufacturer(int id);

	public List<Product> getAllProductPagination(int maxResult, int offSet);

	public long countTotalProducts();

	public List<Product> findProductByName(String productName);
}
