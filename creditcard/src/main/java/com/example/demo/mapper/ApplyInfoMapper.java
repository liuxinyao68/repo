package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.pojo.ApplyInfo;

@Mapper
public interface ApplyInfoMapper {
	
	/**
	 * 通过条件查询ApplyInfo(办卡申请表)信息
	 * @param applyInfo
	 * @return
	 */
	public List<ApplyInfo> queryApplyInfoByCondition(ApplyInfo applyInfo);
	
	/**
	 * 插入一条办卡申请信息
	 * @param applyInfo
	 * @return
	 */
	public int insertApplyInfoByCondition(ApplyInfo applyInfo);
	
	/**
	 * 删除已处理的办卡请求
	 * @param id
	 * @return
	 */
	public int updateIfDelete(ApplyInfo applyInfo);

}
