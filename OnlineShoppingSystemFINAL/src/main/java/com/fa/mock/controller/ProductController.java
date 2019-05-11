package com.fa.mock.controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fa.mock.common.Constant;
import com.fa.mock.model.Category;
import com.fa.mock.model.Manufacturer;
import com.fa.mock.model.Product;
import com.fa.mock.service.CategoryService;
import com.fa.mock.service.ManufacturerService;
import com.fa.mock.service.ProductService;
import com.fa.mock.utils.FileUtils;
import com.google.gson.Gson;

@Controller
public class ProductController {
	Logger log = Logger.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	ManufacturerService manufacturerService;

	List<Manufacturer> lstManufacturer;

	List<Category> lstCategory;

	/**
	 * @return ProductList Page Handle productList request
	 */
	@RequestMapping(value = { "/homePage", "/", "/index" })
	public String showProductList(Model model, HttpSession session) {
		List<Product> productList = productService.getAllProduct();
		lstCategory = getAllCategory();
		lstManufacturer = getAllManufacturer();
		session.setAttribute("productList", productList);
		session.setAttribute("lstCategory", lstCategory);
		session.setAttribute("lstManufacturer", lstManufacturer);
		return "home";
	}

	/**
	 * @return
	 */
	public List<Category> getAllCategory() {
		return categoryService.getAllCategory();
	}

	/**
	 * @return
	 */
	public List<Manufacturer> getAllManufacturer() {
		return manufacturerService.getAllManufacturer();
	}

	/**
	 * @param model
	 * @param request
	 * @return ProductDetails Page
	 */
	@RequestMapping(value = "/productDetails")
	public String showProductDetail(Model model, @RequestParam("id") int productId,
			@RequestParam("pageNumber") int pageNumber) {
		Product product = productService.findProductById(productId);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("product", product);
		return "ProductDetails";
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addproductPage")
	public String getAddProductPage(Model model) {
		model.addAttribute("product", new Product());
		return "AddProduct";
	}

	/**
	 * @param product
	 * @param model
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/postProduct", method = RequestMethod.POST)
	public String postProduct(@ModelAttribute("product") Product product, Model model, BindingResult result,
			HttpServletRequest request) {

		if (!product.getFile().getOriginalFilename().equals("")) {
			FileUtils.uploadFile(request, product.getFile(), product.getCode());

		}
		product.setProductImageFile(
				request.getSession().getServletContext().getRealPath("/resources/img/") + product.getCode());
		if (productService.insertProduct(product) != null) {
			log.info("successful");
		} else {
			log.info("fail");
		}
		return "redirect: addproductPage";
	}

	/**
	 * @param categoryId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/showProductByCategory", method = RequestMethod.GET)
	public String showProductByCategory(@RequestParam("categoryId") int categoryId, Model model) {
		List<Product> lstProduct = productService.getListProductByCategory(categoryId);
		model.addAttribute("lstProduct", lstProduct);
		return "ProductsCategory";
	}

	/**
	 * @param manufacturerId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/showProductByManufacturer", method = RequestMethod.GET)
	public String showProductByManufacturer(@RequestParam("manufacturerId") int manufacturerId, Model model) {
		List<Product> lstProduct = productService.getListProductByManufacturer(manufacturerId);
		model.addAttribute("lstProduct", lstProduct);
		return "ProductsCategory";
	}

	/**
	 * @param model
	 * @param pageNumber
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/productList", method = RequestMethod.GET)
	public String showProductListPage(Model model, @RequestParam("pageNumber") int pageNumber, HttpSession session) {
		List<Product> productList = productService.getAllProductPagination(Constant.MAX_RESULT_PER_PAGE, 0);
		Hashtable<Product, Integer> listOrderProduct = (Hashtable<Product, Integer>) session
				.getAttribute("listOrderProduct");
		session.setAttribute("listOrderProduct", listOrderProduct);
		long totalProduct = productService.countTotalProducts();
		long numberOfPage = totalProduct / Constant.MAX_RESULT_PER_PAGE + 1;
		session.setAttribute("totalProduct", totalProduct);
		session.setAttribute("numberOfPage", numberOfPage);
		if (productList != null) {
			model.addAttribute("totalProduct", totalProduct);
			model.addAttribute("pageNumber", pageNumber);
			model.addAttribute("productList", productList);
		}
		return "ProductList";
	}

	/**
	 * @param pageNumber
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/getListProduct")
	public String showPagePagination(@RequestParam("pageNumber") int pageNumber, Model model, HttpSession session) {
		List<Product> productList = new ArrayList<>();
		if (pageNumber <= 0) {
			return "redirect:/productList?pageNumber=1";
		} else if (pageNumber == 1) {
			productList = productService.getAllProductPagination(Constant.MAX_RESULT_PER_PAGE, Constant.OFFSET);
			model.addAttribute("pageNumber", pageNumber);
			model.addAttribute("productList", productList);

		} else {
			productList = productService.getAllProductPagination(Constant.MAX_RESULT_PER_PAGE,
					Constant.MAX_RESULT_PER_PAGE * (pageNumber - 1));
			model.addAttribute("pageNumber", pageNumber);
			model.addAttribute("productList", productList);
		}
		return "ProductList";
	}

	/**
	 * @param productName
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getProductListByName")
	public String getProductListByName(@RequestParam("productName") String productName, HttpSession session,
			Model model) {
		List<Product> lstProduct = productService.findProductByName(productName);
		if (lstProduct.size() > 0) {
			model.addAttribute("lstProduct", lstProduct);
		}
		return "ProductsCategory";
	}

	/**
	 * @param productName
	 * @return
	 */
	@RequestMapping(value = "findProductByName", method = RequestMethod.POST)
	@ResponseBody
	public String findProductByName(@RequestParam("productName") String productName) {
		String value = "";
		List<Product> listFindProductByName = productService.findProductByName(productName);
		if (listFindProductByName.size() > 0) {
			Gson gson = new Gson();
			value = gson.toJson(listFindProductByName);
		} else {
			value = "Fail Searching";
		}
		return value;
	}
}
