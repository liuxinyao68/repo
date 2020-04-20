package com.example.demo.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.pojo.Page;
import com.example.demo.pojo.UserInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserInfoService {
	
	@Autowired
	private BatchService batchService;
	
	@Test
	public void queryBlack() {
		Page<UserInfo> page = new Page<UserInfo>();
		int currectPage = 1;
		int sizePage = 5;
		page.setCurrectPage(currectPage);
		page.setSizePage(sizePage);
		page = batchService.dealPage(page,0);
		System.out.println(page);
		List<UserInfo> list = batchService.queryBlackListPage(page);
		for (UserInfo userInfo : list) {
			System.out.println(userInfo);
		}
		
	}

}
