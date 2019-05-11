package com.fa.mock.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OrderDetails")
public class OrderDetails implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "Order_Id")
	private int orderId;
	@Id
	@Column(name = "Product_Id")
	private int productId;
	@Column(name = "Quantity")
	private int quantity;
	@Column(name = "Unit_Price")
	private double unitPrice;
	
	@ManyToOne
    @JoinColumn(name="Order_Id")
    private Orders orders;
	
	@ManyToOne
    @JoinColumn(name="Product_Id")
    private Product product;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double d) {
		this.unitPrice = d;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public OrderDetails() {
		super();
	}
	
	
	
}
