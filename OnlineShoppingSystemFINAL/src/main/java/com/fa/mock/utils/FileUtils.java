package com.fa.mock.utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

public class FileUtils {
	private static Logger logger = Logger.getLogger(FileUtils.class);

	public static boolean uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		String realPath = request.getSession().getServletContext().getRealPath("/resources/img/product/");
		String absPath = "E:\\Fresher Academy\\Git Repo - Copy\\online-shopping-system\\OnlineShoppingSystem\\src\\main\\webapp\\resources\\img\\";
		logger.info(absPath);
		if (!new File(realPath).exists()) {
			new File(realPath).mkdirs();
		}
		if (!new File(absPath).exists()) {
			new File(absPath).mkdirs();
		}
		try {
			file.transferTo(new File(realPath + code + ".jpg"));
			file.transferTo(new File(absPath + code + ".jpg"));
		} catch (IOException io) {
			logger.info(io);
		}
		return true;
	}

}
