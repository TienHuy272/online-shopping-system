package com.fa.mock.service;

import java.io.Serializable;
import java.util.Hashtable;

import com.fa.mock.model.OrderDetails;
import com.fa.mock.model.Orders;
import com.fa.mock.model.Product;

public interface OrderService{
	
	public void checkout(Hashtable<Product, Integer> listOrderProduct, OrderDetails orderDetails);
	
	public Serializable insertOrder(Orders orders);
	
	public Hashtable<Product, Integer> addToCart(Hashtable<Product, Integer> listOrderProduct, Product product);

	public Hashtable<Product, Integer> removeProduct(Hashtable<Product, Integer> listOrderProduct, int productId);
	
	public float getTotalPrice(Hashtable<Product, Integer> listOrderProduct);
}
