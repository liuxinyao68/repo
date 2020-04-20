package com.example.demo.service;

import com.example.demo.pojo.UserInfo;

public interface UserInfoService {

	/**
	 * 通过用户id查询用户信息
	 */
	UserInfo queryUserInfoById(String userId);

	/**
	 * 将用户id的用户移出黑名单
	 * @param id
	 */
	void removeBlackList(String[] id);

	/**
	 * 将用户id的用户加入黑名单
	 * @param id
	 */
	void addToBlackList(String[] userid);

	/**
	 * 加入或者移出黑名单
	 * @param idcard  用户身份证
	 * @param op  移出（0）或者加入（1） 
	 */
	void addToBlackListByIdCard(String[] idcard, String  op);

	
	/**
	 * 加入或者移出黑名单
	 * @param userid  用户id
	 * @param op  移出（0）或者加入（1） 
	 */
	void addToBlackListByUserId(String[] userid, String op);

}
