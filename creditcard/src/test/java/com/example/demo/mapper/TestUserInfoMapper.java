package com.example.demo.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.pojo.Count;
import com.example.demo.pojo.Page;
import com.example.demo.pojo.UserInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserInfoMapper {

	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Test
	public void queryAllUserInfo() {
		List<UserInfo> list = userInfoMapper.queryUserInfoByCondition(null);
		System.out.println(list);
	}
	
	@Test
	public void queryCountOfUserInfo() {
		Count count = userInfoMapper.queryCountOfUserInfo(0);
		int col = count.getCount();
//		int col = userInfoMapper.queryCountOfUserInfo();
		System.out.println(col);
	}
	
	@Test
	public void queryUserInfoByPage() {
		Page<UserInfo> page = new Page<UserInfo>();
		//  1
		//  5
		//(currectPage - 1) * sizePage + 1
		//currectPage*sizePage
		int currectPage = 2;
		int sizePage = 5;
		int startNO = (currectPage - 1) * sizePage + 1;
		int endNo = currectPage*sizePage;
		
		page.setStartNo(startNO);
		page.setEndNo(endNo);

		
		List<UserInfo> list = userInfoMapper.queryBalckUserInfoByPage(page);

//		System.out.println(list);
		
		for (UserInfo userInfo : list) {
			System.out.println(userInfo);
		}
	}
	
	@Test
	public void queryUserInfoByApplyInfoId() {
		String applyinfoId = "1000000004";
		
		UserInfo userInfo = new UserInfo();
		userInfo.setApplyinfoId(applyinfoId);
		List<UserInfo> list = userInfoMapper.queryUserInfoByCondition(userInfo);
		System.out.println(list);
	}
	
	@Test
	public void insertUserInfo() {
		String realName = "bigmom";
		String idCardNumber = "123456144523231234";
		String phone = "12345678909";
		Date time = new Date();
		String citynow = "广东深圳";
		
		UserInfo userInfo = new UserInfo();
		userInfo.setRealname(realName);
		userInfo.setIdcardnumber(idCardNumber);
		userInfo.setPhone(phone);
		userInfo.setCreatetime(time);
		userInfo.setUpdatetime(time);
		userInfo.setCitynow(citynow);
		
		int flag = userInfoMapper.insertUserInfoByCondition(userInfo);
		System.out.println(flag);
	}
	

	@Test
	public void updateUserInfo() {
		String id = "1200000026";
		String ifBlackname = "1";
		Date time = new Date();
		
		UserInfo userInfo = new UserInfo();
		userInfo.setId(id);
		userInfo.setIfBlackname(ifBlackname);
		userInfo.setUpdatetime(time);
		
		userInfoMapper.updateUserInfoByCondition(userInfo);
	}

}
