package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.ApplyInfoMapper;
import com.example.demo.pojo.ApplyInfo;

@Service("TestService")
public class TestServiceImpl {
	@Autowired
	private ApplyInfoMapper applyInfoMapper;
	
	
	@Transactional(rollbackFor = Exception.class)
	public void testfun() throws Exception{

			ApplyInfo applyInfo = new ApplyInfo();
			applyInfo.setId("1000000002");

			applyInfoMapper.updateIfDelete(applyInfo);
			int a = 21/0;
			System.out.println(a);
	}

}
