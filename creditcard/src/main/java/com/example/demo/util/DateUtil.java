package com.example.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 日期工具类型
 * @author Administrator
 *
 */
public class DateUtil {
	static SimpleDateFormat[]  sdfs = {
		new SimpleDateFormat("yyyy-MM-dd"),
		new SimpleDateFormat("yyyy年MM月dd日"),
		new SimpleDateFormat("yyyy/MM/dd")
	};
	/**
	 * 把字符串转换为Date
	 * @param src    20191212
	 * @return
	 */
	public static Date parseDate(String src){
		if(src==null || src.trim().isEmpty()){
			//throw new RuntimeException("没有数据");
			return null;
		}
		for (SimpleDateFormat sdf : sdfs) {
			try {
				return sdf.parse(src);
			} catch (ParseException e) {
				//e.printStackTrace();
				continue;
			}
		}
		throw new RuntimeException(src+"的日期格式不对, 转换失败!");
	}
	
	
	/**
	 * 把java.util.Date转换为java.sql.Date
	 * @param date
	 * @return
	 */
	public static  java.sql.Date  convertDate(java.util.Date date){
		return new  java.sql.Date(date.getTime());
	}
}
