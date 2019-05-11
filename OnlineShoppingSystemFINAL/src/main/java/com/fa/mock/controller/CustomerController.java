package com.fa.mock.controller;

import java.util.Hashtable;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.fa.mock.model.Customer;
import com.fa.mock.model.Product;
import com.fa.mock.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;

	/**
	 * @return Login Page Handle request login from customer
	 */
	@RequestMapping(value = "/customerLogin")
	public String showLogin() {
		return "Login";
	}

	/**
	 * @return Register Page Handle request register from customer
	 */
	@RequestMapping(value = "/customerRegister")
	public String showRegister() {
		return "Register";
	}

	/**
	 * @param customer
	 * @param session
	 * @return Product List if login success , and Login if login fail Handle login
	 *         request from customer
	 */
	@RequestMapping(value = "/customerLogin", method = RequestMethod.POST)
	public String login(@ModelAttribute("customer") Customer customer, HttpSession session, Model model) {
		Customer theCustomer = customerService.login(customer);
		if (theCustomer != null) {
			Hashtable<Product, Integer> listOrderProduct = new Hashtable<>();
			session.setAttribute("listOrderProduct", listOrderProduct);
			session.setAttribute("theCustomer", theCustomer);
			return "redirect:/customerProfile";
		} else {
			model.addAttribute("message", "Invalid Username or Password !");
			return "Login";
		}
	}

	/**
	 * @param customer
	 * @return Login Page Handle register request
	 */
	@RequestMapping(value = "/customerRegister", method = RequestMethod.POST)
	public String register(@ModelAttribute("customer") Customer customer) {
		customerService.register(customer);
		return "Login";
	}


	/**
	 * @param customer
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/customerProfile")
	public String showProfile(@SessionAttribute("theCustomer") Customer customer, Model model) {
		if (customer != null) {
			model.addAttribute("theCustomer", customer);
		} else {
			model.addAttribute("theCustomer", new Customer());
		}
		return "CustomerProfile";
	}

	
	/**
	 * @param session
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/homePage";
	}

	/**
	 * @param customer
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/updateProfile", method = RequestMethod.POST)
	public String updateProfile(@ModelAttribute("theCustomer") Customer customer, HttpSession session) {
		customerService.updateCustomer(customer);
		customer = customerService.login(customer);
		session.setAttribute("theCustomer", customer);
		return "redirect:/customerProfile";
	}
}
