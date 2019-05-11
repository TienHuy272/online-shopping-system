package com.fa.mock.service.impl;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.mock.dao.OrderDAO;
import com.fa.mock.dao.OrderDetailsDAO;
import com.fa.mock.dao.ProductDAO;
import com.fa.mock.model.OrderDetails;
import com.fa.mock.model.Orders;
import com.fa.mock.model.Product;
import com.fa.mock.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private OrderDAO orderDAO;

	@Autowired
	private OrderDetailsDAO orderDetailsDAO;

	@Override
	public void checkout(Hashtable<Product, Integer> listOrderProduct, OrderDetails orderDetails) {
		int unitInStock = 0;
		int Quantity = 0;
		Product product = null;
		for (Entry<Product, Integer> s1 : listOrderProduct.entrySet()) {
			Quantity = s1.getValue();
			unitInStock = s1.getKey().getUnitInStock();
			product = s1.getKey();
			product.setUnitInStock(unitInStock - Quantity);
			productDAO.update(product);
		}

		for (Entry<Product, Integer> s : listOrderProduct.entrySet()) {
			orderDetails.setProductId(s.getKey().getProductId());
			orderDetails.setUnitPrice(s.getKey().getUnitPrice());
			orderDetails.setQuantity(s.getValue());
			orderDetailsDAO.insertOrderDetails(orderDetails);
		}
	}

	@Override
	public Serializable insertOrder(Orders orders) {
		return orderDAO.insert(orders);
	}

	@Override
	public Hashtable<Product, Integer> addToCart(Hashtable<Product, Integer> listOrderProduct, Product product) {
		boolean check = listOrderProduct.containsKey(product);
		if (!check) {
			listOrderProduct.put(product, 1);
		} else {
			int quantity = listOrderProduct.get(product);
			listOrderProduct.put(product, quantity + 1);
		}
		return listOrderProduct;
	}

	@Override
	public Hashtable<Product, Integer> removeProduct(Hashtable<Product, Integer> listOrderProduct, int productId) {
		Product product = new Product();
		product.setProductId(productId);
		listOrderProduct.remove(product);
		return listOrderProduct;
	}

	@Override
	public float getTotalPrice(Hashtable<Product, Integer> listOrderProduct) {
		float totalPrice = 0;
		for (Entry<Product, Integer> s1 : listOrderProduct.entrySet()) {
			totalPrice += s1.getKey().getUnitPrice() * s1.getValue();
		}
		return totalPrice;
	}
}
