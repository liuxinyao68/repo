package com.example.demo.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.pojo.Count;
import com.example.demo.pojo.StageUserInfoVO;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestHtmlVoMapper {

	@Autowired
	private HtmlVoMapper htmlVoMapper ;

	@Test
	public void queryAllLogininfo() {
		List<StageUserInfoVO> list = htmlVoMapper.queryStageUserInfoVOByCondition();

		for(StageUserInfoVO info: list)
		{
			System.out.println(info);
		}
	}
	
	@Test
	public void queryCount() {
		Count count = htmlVoMapper.queryCount();
		System.out.println(count.getCount());
	}

}
