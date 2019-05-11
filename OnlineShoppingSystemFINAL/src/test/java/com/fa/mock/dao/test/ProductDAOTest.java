package com.fa.mock.dao.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fa.mock.model.Product;
import com.fa.mock.service.CategoryService;
import com.fa.mock.service.ProductService;
import com.fa.mock.utils.FileUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class ProductDAOTest {

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@Test
	public void categoryServiceTest() {
		assertNotNull(categoryService);
	}

	@Test
	public void getAllCategory() {
		assertTrue(categoryService.getAllCategory().size() > 0);
	}
	
	@Test
	public void getProductByCategoryTest() {
		assertTrue(productService.getListProductByCategory(1).size() > 0);
	}

	@Test
	public void testNotNull() {
		assertNotNull(productService);
	}

	@Test
	public void getAllProductTest() {
		assertNotNull(productService.getAllProduct());
	}
	//
	// @Test
	// public void getProductTest() {
	// assertNotNull(productService.getProduct(1));
	// }
	//
	// @Test
	// public void getAllCategoryTest() {
	// assertTrue(productService.getAllManufacturer().size() > 0);
	// }

	@Test
	public void uploadFileTest() {
		HttpServletRequest request = null;
		Product product = new Product();
		request.setAttribute("123.jpg", product.getFile());
		assertTrue(FileUtils.uploadFile(request, product.getFile(), product.getCode()));
	}
}
