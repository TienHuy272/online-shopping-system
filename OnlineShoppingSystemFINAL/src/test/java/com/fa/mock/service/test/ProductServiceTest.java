package com.fa.mock.service.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fa.mock.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class ProductServiceTest {
	
	@Autowired
	private ProductService productService;
	
	@Test
	public void testNotNull() {
		assertNotNull(productService);
	}
	
	@Test
	public void getAllProductPaginationTest() {
		assertNotNull(productService.getAllProductPagination(8, 8));
	}
}
