package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.CartApplication;
import com.example.demo.pojo.OverFlows;
import com.example.demo.pojo.StageUserInfoVO;

public interface HtmlVOService {
	
	/**
	 *  查询办卡申请列表
	 */
	public List<CartApplication> queryCartApplication() ;
	
	/**
	 * 查询用户分期列表
	 */
	public List<StageUserInfoVO> queryStageUserInfoVOByCondition();
	
	
	/**
	 * 查询逾期用户列表
	 * @return
	 */
	public List<OverFlows> queryAOverFlowsByCondition();

}
