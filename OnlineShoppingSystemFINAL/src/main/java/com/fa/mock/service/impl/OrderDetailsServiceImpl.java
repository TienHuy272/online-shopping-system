package com.fa.mock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fa.mock.dao.OrderDetailsDAO;
import com.fa.mock.model.OrderDetails;
import com.fa.mock.service.OrderDetailsService;

@Service("orderDetailsService")
public class OrderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	OrderDetailsDAO orderDetailsDAO;
	
	@Override
	public boolean insertOrderDetails(OrderDetails orderDetails) {
		return orderDetailsDAO.insertOrderDetails(orderDetails);
	}

}
