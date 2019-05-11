package com.fa.mock.utils;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.fa.mock.model.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		if (product.getFile() == null || product.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "Please select a file to upload!");
			return;
		}
		if (!(product.getFile().getContentType().equals("img/jpeg")
				|| product.getFile().getContentType().equals("img/png")
				|| product.getFile().getContentType().equals("img/gif"))) {
			errors.rejectValue("file", null, "Please select an image file to upload!");
			return;
		}
	}

}
