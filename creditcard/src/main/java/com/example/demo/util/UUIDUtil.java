package com.example.demo.util;

import java.util.UUID;

public class UUIDUtil {
	
	/**
	 * 获得一个32位的16进制数。其中字母均为大写
	 * @return
	 */
	public static String getUUid() {
		return (UUID.randomUUID()+"").replace("-", "").toUpperCase();
	}
	
	
	/**
	 * 获取一个6位的十进制验证码
	 * @return
	 */
	public static String getCode() {
		int a[] = new int[6];		
		String myCode = "";
		for(int i=0;i < 6;i ++ ) {
			myCode = myCode + (int)(10*(Math.random()));
		}		
		return myCode;
	}

}
