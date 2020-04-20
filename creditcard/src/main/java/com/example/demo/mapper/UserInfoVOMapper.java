package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.example.demo.vo.UserInfoVO;

@Mapper
public interface UserInfoVOMapper {
	
	/**
	 * 查询用户表和信用卡表的整合情况
	 * 用户表，信用卡表
	 * @param userInfoVO
	 * @return
	 */
	public List<UserInfoVO> queryCreditcardAndUserinfoByCondition(UserInfoVO userInfoVO);

	/**
	 * 三表联查
	 * 用户表，信用卡表，分期情况表
	 * @param userInfoVO
	 * @return
	 */
	public List<UserInfoVO> queryBillingDateByCondition(UserInfoVO userInfoVO);
	
}
