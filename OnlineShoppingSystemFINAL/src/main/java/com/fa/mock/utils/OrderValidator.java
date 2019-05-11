package com.fa.mock.utils;

import java.util.Hashtable;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import com.fa.mock.model.Product;
import com.fa.mock.service.ProductService;

public class OrderValidator {
	
	@Autowired
	static ProductService productService;

	public static boolean validateOrder(Hashtable<Product, Integer> listOrderProduct) {
		int quantity = 0;
		int unitInStock = 0;
		int productId = 0;
		boolean check = true;
		
		for (Entry<Product, Integer> s : listOrderProduct.entrySet()) {
			
			productId = s.getKey().getProductId();
			quantity = s.getValue();
//			unitInStock = productService.find(productId).getUnitInStock();
			if((unitInStock - quantity) < 0) {
				check = false;
			}
		}
		return check;
	}
}
