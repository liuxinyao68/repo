package com.example.demo.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUtils {

	/**
	 * 测试随机产生随机 
	 */
	@Test
	public void cartRandom() {
		String cartid = CartRandomUtil.getCart();
		System.out.println(cartid);
	}
	
	/**
	 * 测试随机产生一个32位的16进制数
	 */
	@Test
	public void getUUid() {
		String id = UUIDUtil.getUUid();
		System.out.println(id);
	}
	
	@Test
	public void getMD5() {
		String key = "123456";
		String KeyByMD5 ;
		KeyByMD5 = MD5Util.getMD5(key);
		System.out.println(KeyByMD5);
	}
	
	@Test
	public void getMyCode() {
		String myCode = UUIDUtil.getCode();
		System.out.println(myCode);
	}
	
	@Test
	public void sendPhoneCode() {
		String phone = "17369211645";
		String code = SMSSendUtil.getPhoneCode(phone);
		System.out.println(code);
		
	}
}
