package com.example.demo.mapper;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.pojo.LoginInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestLoginInfoMapper {

	@Autowired
	private LoginInfoMapper loginInfoMapper ;
	
	@Autowired
	private DataSource  ds;
	@Autowired
	private JdbcTemplate  jdbcTemplate;

	
	@Test
	public void contextLoads() {
		System.out.println(ds.getClass());
		System.out.println(jdbcTemplate);
	}
	
	@Test
	public void fun() {
		Long id1 =  17369211645L;
		Long id2 = 17369211645L;
		if((id1).equals(id2)) {
			System.out.println("相等");
		}else {
			System.out.println("不等");
		}
	}
	
	@Test
	public void queryAllLogininfo() {
		List<LoginInfo> list = loginInfoMapper.queryLoginInfoByCondition(null);
		System.out.println(list);
	}
	
	@Test
	public void login() {
		Long id =  2L;
//		Long phone = 12312341234L;
		String password = "123456";
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setId(id);
		loginInfo.setPassword(password);
		List<LoginInfo> list = loginInfoMapper.queryLoginInfoByCondition(loginInfo);
		loginInfo = list == null || list.size() == 0 ? null : list.get(0);
		System.out.println(list);
		System.out.println(loginInfo);
	}

}
