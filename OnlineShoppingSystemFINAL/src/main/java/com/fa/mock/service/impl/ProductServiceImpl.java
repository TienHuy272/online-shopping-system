package com.fa.mock.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.mock.dao.ProductDAO;
import com.fa.mock.model.Product;
import com.fa.mock.service.ProductService;
@Service("productService")
public class ProductServiceImpl implements ProductService{
		
	@Autowired
	ProductDAO productDAO;

	@Override
	public List<Product> searchProduct(Product product) {
		return productDAO.searchProduct(product);
	}

	@Override
	public Product findProductById(int productId) {
		return productDAO.find(productId);
	}

	@Override
	public Serializable insertProduct(Product product) {
		return productDAO.insert(product);
	}

	@Override
	public List<Product> getAllProduct() {
		return productDAO.getAll();
	}

	@Override
	public List<Product> getListProductByCategory(int id) {
		return productDAO.getListProductByCategory(id);
	}
	
	
	@Override
	public List<Product> getListProductByManufacturer(int id) {
		return productDAO.getListProductByManufacturer(id);
	}
	
	@Override
	public List<Product> getAllProductPagination(int maxResult, int offSet) {
		return productDAO.getAllProductPagination(maxResult, offSet);
	}

	@Override
	public long countTotalProducts() {
		return productDAO.countTotalProducts();
	}
	
	@Override
	public List<Product> findProductByName(String productName) {
		return productDAO.findProductByName(productName);
	}
}
