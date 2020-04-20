package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.pojo.OverFlows;

@Mapper
public interface OverFlowsMapper {
	
	/**
	 * 通过条件查询ApplyInfo(办卡申请表)信息
	 * @param applyInfo
	 * @return
	 */
	public List<OverFlows> queryAOverFlowsByCondition();
	
	

}
