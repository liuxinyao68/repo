package com.example.demo.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.pojo.CartApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCartApplicationService {

	@Autowired
	private HtmlVOService htmlVOService;
	
	@Test
	public void login() {
		List<CartApplication> list = htmlVOService.queryCartApplication();
		System.out.println(list.size());
	}
}
