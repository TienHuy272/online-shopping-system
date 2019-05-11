package com.fa.mock.dao;

import com.fa.mock.genericdao.IGenericDAO;
import com.fa.mock.model.OrderDetails;

public interface OrderDetailsDAO extends IGenericDAO<OrderDetails>{
	public boolean insertOrderDetails(OrderDetails orderDetails);
}
