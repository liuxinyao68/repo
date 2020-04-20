package com.example.demo.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.pojo.CartApplication;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplyInfoMapper {

	@Autowired
	private CartApplicationMapper cartApplicationMapper ;
	
	
	@Test
	public void queryAllLogininfo() {
		List<CartApplication> list = cartApplicationMapper.queryCartApplicationByCondition();
		System.out.println(list);
	}
	

}
