package com.example.demo.util;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * 上传工具类
 * @author Administrator
 *
 */
public class UploadUtil {
	static  Properties prop = new Properties();
	static{
		try {
			prop.load(UploadUtil.class.getClassLoader().getResourceAsStream("upload.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取保存路径
	 * @return
	 */
	public static String  getSavePath(){
		String path =  prop.getProperty("savepath");
		File file = new File(path);
		if(!file.exists()){ //exists()  true 存在,   false: 不存在
			//创建目录
			file.mkdirs();
		}
		
		return path;
	}
}
