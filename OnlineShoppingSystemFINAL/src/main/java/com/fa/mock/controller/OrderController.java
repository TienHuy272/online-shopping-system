package com.fa.mock.controller;

import java.io.Serializable;
import java.util.Hashtable;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fa.mock.model.Customer;
import com.fa.mock.model.OrderDetails;
import com.fa.mock.model.Orders;
import com.fa.mock.model.Product;
import com.fa.mock.service.CustomerService;
import com.fa.mock.service.OrderDetailsService;
import com.fa.mock.service.OrderService;
import com.fa.mock.service.ProductService;
import com.fa.mock.utils.DateUtils;
import com.google.gson.Gson;

@SuppressWarnings("unchecked")
@Controller
public class OrderController {

	@Autowired
	OrderService orderService;

	@Autowired
	CustomerService customerService;

	@Autowired
	ProductService productService;

	@Autowired
	OrderDetailsService orderDetailsService;

	/**
	 * @return Checkout Page Handle re-checkout request
	 */
	@RequestMapping(value = "/re-checkout")
	public String showCheckout() {
		return "Checkout";
	}

	/**
	 * @return ProductList Page
	 */
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String checkout(@ModelAttribute("order") Orders order, HttpSession session) {
		int orderId = 0;
		Customer theCustomer = null;
		Serializable serializable = null;
		OrderDetails orderDetails = new OrderDetails();
		theCustomer = order.getCustomer();
		customerService.updateCustomer(theCustomer);

		order.setOrderDate(DateUtils.getDate());
		serializable = orderService.insertOrder(order);
		if (serializable != null) {
			orderId = (int) serializable;
		}

		Hashtable<Product, Integer> listOrderProduct = (Hashtable<Product, Integer>) session
				.getAttribute("listOrderProduct");
		orderDetails.setOrderId(orderId);
		orderService.checkout(listOrderProduct, orderDetails);

		listOrderProduct.clear();
		session.setAttribute("listOrderProduct", listOrderProduct);
		return "redirect:/homePage";
	}

	/**
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/productOrder", method = RequestMethod.POST)
	@ResponseBody
	public String addToCart(HttpSession session, @RequestParam("productId") int productId) {
		String value;
		Hashtable<Product, Integer> listOrderProduct = (Hashtable<Product, Integer>) session
				.getAttribute("listOrderProduct");
		if (listOrderProduct != null) {
			Product product = productService.findProductById(productId);
			listOrderProduct = orderService.addToCart(listOrderProduct, product);
			session.setAttribute("listOrderProduct", listOrderProduct);
			Gson gson = new Gson();
			value = gson.toJson(listOrderProduct);
		} else {
			value = "Fail Ordering";
		}
		return value;
	}

	/**
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/viewCart")
	public String viewCart(Model model, HttpSession session) {
		Hashtable<Product, Integer> listOrderProduct = (Hashtable<Product, Integer>) session
				.getAttribute("listOrderProduct");
		// int numberOfProduct = listOrderProduct.size();
		// float totalPrice = orderService.getTotalPrice(listOrderProduct);
		// session.setAttribute("numberOfProduct", numberOfProduct);
		// session.setAttribute("totalPrice", totalPrice);
		model.addAttribute("listOrderProduct", listOrderProduct);
		return "ViewCart";
	}

	/**
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/clearCart")
	public String clearCart(HttpSession session) {
		Hashtable<Product, Integer> listOrderProduct = (Hashtable<Product, Integer>) session
				.getAttribute("listOrderProduct");
		listOrderProduct.clear();
		session.setAttribute("listOrderProduct", listOrderProduct);
		return "ViewCart";
	}

	/**
	 * @param model
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/removeProduct", method = RequestMethod.POST)
	@ResponseBody
	public String removeProduct(Model model, HttpSession session, @RequestParam("productId") int productId) {
		System.out.println("Remove Product");
		Hashtable<Product, Integer> listOrderProduct = (Hashtable<Product, Integer>) session
				.getAttribute("listOrderProduct");
		listOrderProduct = orderService.removeProduct(listOrderProduct, productId);
		Gson gson = new Gson();
		return gson.toJson(listOrderProduct);
	}

	/**
	 * @param productId
	 * @param quantity
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
	@ResponseBody
	public String updateCart(@RequestParam int productId, @RequestParam int quantity, HttpSession session) {
		Product product = productService.findProductById(productId);
		Hashtable<Product, Integer> listOrderProduct = (Hashtable<Product, Integer>) session
				.getAttribute("listOrderProduct");
		listOrderProduct.put(product, quantity);
		session.setAttribute("listOrderProduct", listOrderProduct);
		Gson gson = new Gson();
		return gson.toJson(listOrderProduct);
	}


}
