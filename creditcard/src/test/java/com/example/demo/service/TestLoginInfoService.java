package com.example.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestLoginInfoService {

	@Autowired
	private LoginInfoService loginInfoService;
	
	@Test
	public void login() {
		Long id = 8L;
		String password = "123456";
		Long phone = 123L;
		int flag = loginInfoService.loginAdmin(id, password,phone);
		if(flag == 0) {
			System.out.println("登入成功");
		}else {
			System.out.println("登入失败");
		}
	}
}
