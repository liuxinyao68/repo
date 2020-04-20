package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.UserInfoVO;

public interface SingleUserDealService {

	/**
	 * 
	 * 查询单个用户信息
	 * 三表联查用户表，信用卡表，分期情况表
	 *
	 */
	public UserInfoVO queryUserDetailInfo(String realname, String idcartnumber, String cardnumber);

	/**
	 * 查询用户信用卡的分期信息情况
	 */
	List<UserInfoVO> queryUserDetailInfoBy(String realname, String idcartnumber, String cardnumber);

}
