package com.example.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.service.impl.TestServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestFun {
	
	@Autowired
	private TestServiceImpl testServiceImpl;
	
	@Test
	public void fun() throws Exception {
		testServiceImpl.testfun();
	}

}
