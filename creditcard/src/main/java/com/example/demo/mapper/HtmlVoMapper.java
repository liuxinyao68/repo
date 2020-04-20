package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.pojo.Count;
import com.example.demo.pojo.StageUserInfoVO;

@Mapper
public interface HtmlVoMapper {
	
	/**
	 * 查询分期视图信息
	 * @return
	 */
	public List<StageUserInfoVO> queryStageUserInfoVOByCondition();
	
	/**
	 * 查询bystages的数据数量
	 * @return
	 */
	public Count queryCount();

} 
