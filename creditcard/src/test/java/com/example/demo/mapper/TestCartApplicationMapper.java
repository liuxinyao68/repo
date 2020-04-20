package com.example.demo.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.pojo.ApplyInfo;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCartApplicationMapper {

	@Autowired
	private ApplyInfoMapper applyInfoMapper ;

	@Test
	public void queryAllLogininfo() {
		List<ApplyInfo> list = applyInfoMapper.queryApplyInfoByCondition(null);
		System.out.println(list);
		System.out.println("=====================");
		for(ApplyInfo info: list)
		{
			System.out.println(info.getId()+"------>"+info.getIfDelete());
		}
	}
	
	@Test
	public void queryApplyInfoById() {
		String id = "1000000005";
		ApplyInfo applyInfo = new ApplyInfo();
		applyInfo.setId(id);
		List<ApplyInfo> list = applyInfoMapper.queryApplyInfoByCondition(applyInfo);
		System.out.println(list);
	}
	
	@Test
	public void deleteApplyInfo() {
		String id = "1000000005";
		ApplyInfo applyInfo = new ApplyInfo();
		applyInfo.setId(id);
		int flag = applyInfoMapper.updateIfDelete(applyInfo);
		System.out.println(flag);
	}
	

}
