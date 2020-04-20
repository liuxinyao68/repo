package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.pojo.CartApplication;

@Mapper
public interface CartApplicationMapper {
	
	/**
	 * 查询办卡请求信息
	 * @return
	 */
	public List<CartApplication> queryCartApplicationByCondition();
	

}
