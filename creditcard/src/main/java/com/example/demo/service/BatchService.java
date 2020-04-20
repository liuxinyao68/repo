package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.Page;
import com.example.demo.pojo.UserInfo;

public interface BatchService {

	/**
	 * 分页查询黑名单用户
	 * @param page
	 * @return
	 */
	List<UserInfo> queryBlackListPage(Page<UserInfo> page);

	/**
	 * 处理分页信息，通过当前页和页容量完善该实体类中的其他属性
	 */
	Page<UserInfo> dealPage(Page<UserInfo> page,Integer ifdelete);

	/**
	 * 分页查询所有用户信息
	 * @param page
	 * @return
	 */
	List<UserInfo> queryAllUserInfoByPage(Page<UserInfo> page);

	/**
	 * 向用户id的用户发送短信
	 * @param userid
	 */
	void sendShortMessage(String[] userid,String message);
	

}
