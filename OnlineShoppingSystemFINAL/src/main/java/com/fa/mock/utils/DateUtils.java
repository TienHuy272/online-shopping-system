package com.fa.mock.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fa.mock.common.Constant;

public class DateUtils {
	public static String getDate() {
		Date date = new Date();
		String dateTime = (new SimpleDateFormat(Constant.DATE_FORMATE).format(date)); 
		return dateTime;
	}
}
