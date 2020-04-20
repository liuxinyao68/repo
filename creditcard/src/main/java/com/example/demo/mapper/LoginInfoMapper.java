package com.example.demo.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.pojo.LoginInfo;



@Mapper
public interface LoginInfoMapper {
	
	/**
	 * 查询登入表LoginInfo信息
	 * @param condition
	 * @return
	 */
	public List<LoginInfo> queryLoginInfoByCondition(LoginInfo condition); 
	
	/**
	 * 插入登入信息
	 * @param condition
	 * @return
	 */
	public int insertLoginInfoByCondition(LoginInfo condition); 

	
}
