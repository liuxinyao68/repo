package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.pojo.UserInfo;
import com.example.demo.service.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoMapper userInfoMapper;

	/**
	 * 通过用户id查询用户信息
	 */
	@Override
	public UserInfo queryUserInfoById(String userId) {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(userId);
		List<UserInfo> list = userInfoMapper.queryUserInfoByCondition(userInfo);
		if(list == null || list.size() == 0) {
			return null;
		}
		userInfo = list.get(0);
		return userInfo;
	}

	/**
	 * 将用户id的用户移出黑名单
	 * @param id
	 */
	@Override
	public void removeBlackList(String[] id) {
		for(int i=0;i<id.length;i++)
		{
			String userid = id[i];
			String ifBlackname = "0";
			Date time = new Date();
			
			UserInfo userInfo = new UserInfo();
			userInfo.setId(userid);
			userInfo.setIfBlackname(ifBlackname);
			userInfo.setUpdatetime(time);

			userInfoMapper.updateUserInfoByCondition(userInfo);
		}	
	}

	/**
	 * 将用户id的用户加入黑名单
	 * @param id
	 */
	@Override
	public void addToBlackList(String[] id) {
		for(int i=0;i<id.length;i++)
		{
			String userid = id[i];
			String ifBlackname = "1";
			Date time = new Date();
			
			UserInfo userInfo = new UserInfo();
			userInfo.setId(userid);
			userInfo.setIfBlackname(ifBlackname);
			userInfo.setUpdatetime(time);

			userInfoMapper.updateUserInfoByCondition(userInfo);
		}
		
	}

	@Override
	public void addToBlackListByIdCard(String[] id, String op) {
		for(int i=0;i<id.length;i++)
		{
			String idcard = id[i];
			String ifBlackname = op;
			Date time = new Date();
			
			UserInfo userInfo = new UserInfo();
			userInfo.setIdcardnumber(idcard);
			userInfo.setIfBlackname(ifBlackname);
			userInfo.setUpdatetime(time);
			
			System.out.println(userInfo);

			userInfoMapper.updateUserInfoByCondition(userInfo);
		}
		
	}
	
	
	@Override
	public void addToBlackListByUserId(String[] id, String op) {
		for(int i=0;i<id.length;i++)
		{
			String idcard = id[i];
			String ifBlackname = op;
			Date time = new Date();
			
			UserInfo userInfo = new UserInfo();
			userInfo.setId(idcard);
			userInfo.setIfBlackname(ifBlackname);
			userInfo.setUpdatetime(time);
			
			System.out.println(userInfo);

			userInfoMapper.updateUserInfoByCondition(userInfo);
		}
		
	}

}
