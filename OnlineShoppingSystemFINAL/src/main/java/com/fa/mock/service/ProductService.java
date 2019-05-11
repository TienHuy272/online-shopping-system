package com.fa.mock.service;

import java.io.Serializable;
import java.util.List;

import com.fa.mock.model.Product;

public interface ProductService {
	
	public List<Product> searchProduct(Product product);

	public Product findProductById(int productId);

	public Serializable insertProduct(Product product);

	public List<Product> getAllProduct();
	
	public List<Product> getListProductByCategory(int id);
	
	public List<Product> getListProductByManufacturer(int id);
	
	public List<Product> getAllProductPagination(int maxResult, int offSet);
	
	public long countTotalProducts();
	
	public List<Product> findProductByName(String productName);
	
}
