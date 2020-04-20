package com.example.demo.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.pojo.OverFlows;
import com.example.demo.pojo.StageUserInfoVO;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestOverFlowsMapper {

	@Autowired
	private OverFlowsMapper overFlowsMapper ;

	@Test
	public void queryAllLogininfo() {
		List<OverFlows> list = overFlowsMapper.queryAOverFlowsByCondition();

		for(OverFlows info: list)
		{
			System.out.println(info);
		}
	}
	

}
