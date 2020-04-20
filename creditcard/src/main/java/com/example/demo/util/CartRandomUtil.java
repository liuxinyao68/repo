package com.example.demo.util;


public class CartRandomUtil {

	/**
	 * 获取一个以622237开头的19位的数字字符串
	 * @return
	 */
	public static String getCart() {
		int a[] = new int[10];		
		Long cart = 0L;
		for(int i=0;i<a.length;i ++ ) {
			a[i] = (int)(10*(Math.random()));
		}		
		for(int i=0;i<a.length;i ++ ) {
			cart = cart*10 + a[i];
		}
		String cartprefix = "622237";
		String cartid = "";
		cartid = cartprefix + cart;
		return cartid;
	}

}
