package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.pojo.Page;
import com.example.demo.pojo.UserInfo;
import com.example.demo.service.BatchService;

@Service("batchService")
public class BatchServiceImpl implements BatchService{
	
	@Autowired
	private UserInfoMapper userInfoMapper;

	/**
	 * 分页查询黑名单用户
	 */
	@Override
	public List<UserInfo> queryBlackListPage(Page<UserInfo> page) {
		List<UserInfo> list = userInfoMapper.queryBalckUserInfoByPage(page);
		return list;
	}
	
	/**
	 * 处理分页信息，通过当前页和页容量完善该实体类中的其他属性
	 */
	@Override
	public Page<UserInfo> dealPage(Page<UserInfo> page,Integer ifdelete) {
		
		Integer currectPage = page.getCurrectPage();
		Integer sizePage = page.getSizePage();
		Integer pages = page.getPages();
		if( pages == null ) {
			pages = 3;
		}
		if( currectPage == null ) {
			currectPage = 1;
		}
		if( sizePage == null ) {
			sizePage = 5;
		}
		Integer count = userInfoMapper.queryCountOfUserInfo(ifdelete).getCount();
		Integer totalPage = count%sizePage == 0 ? count/sizePage : count/sizePage + 1;
		if(currectPage <= 0 ) {
			currectPage = 1;
		}
		if(currectPage >= totalPage) {
			currectPage = totalPage;
		}
		Integer startPage = currectPage - pages/2;
		Integer endPage = currectPage + pages/2;
		if(startPage <= 0 ) {
			startPage = 1;
			endPage = pages;
		}
		if(endPage >= totalPage ) {
			startPage = totalPage - pages + 1;
			endPage = totalPage;
		}
		Integer startNo = (currectPage - 1) * sizePage + 1 ;
		Integer endNo = currectPage*sizePage;

		page.setCurrectPage(currectPage);
		page.setSizePage(sizePage);
		page.setCount(count);
		page.setTotalPage(totalPage);
		page.setStartPage(startPage);
		page.setEndPage(endPage);
		page.setStartNo(startNo);
		page.setEndNo(endNo);
		return page;
	}

	
	/**
	 * 分页查询所有用户信息
	 */
	@Override
	public List<UserInfo> queryAllUserInfoByPage(Page<UserInfo> page) {
		
		return userInfoMapper.queryAllUserInfoByPage(page);
	}

	/**
	 * 向用户id的用户发送message短信
	 */
	@Override
	public void sendShortMessage(String[] userid,String send) {
		for(int i=0;i<userid.length;i++)
		{
			System.out.println(userid[i]);
			String id = userid[i]+"";
			UserInfo userInfo = new UserInfo();
			userInfo.setId(id);
			List<UserInfo> list = userInfoMapper.queryUserInfoByCondition(userInfo);
			userInfo = (list == null || list.size() == 0) ? null : list.get(0);
			if(userInfo == null) {
				System.out.println("用户id为" + id + "的用户不存在");
				continue;
			}
			String phone = userInfo.getPhone();
			//发送短信
			System.out.println("发送短信给用户id为 " + id + ",手机号为" + phone + "的用户");
			System.out.println("短信内容为:" + send);
		}
		
	}
	
	

}
