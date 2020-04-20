package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.CartApplicationMapper;
import com.example.demo.mapper.HtmlVoMapper;
import com.example.demo.mapper.OverFlowsMapper;
import com.example.demo.pojo.CartApplication;
import com.example.demo.pojo.OverFlows;
import com.example.demo.pojo.StageUserInfoVO;
import com.example.demo.service.HtmlVOService;
import com.example.demo.util.SessionUtil;
@Service("htmlVOService")
public class HtmlVOServiceImpl implements HtmlVOService {
	
	@Autowired
	private CartApplicationMapper cartApplicationMapper;
	
	@Autowired
	private HtmlVoMapper htmlVoMapper;
	
	@Autowired
	private OverFlowsMapper overFlowsMapper;

	/**
	 *  查询办卡申请列表
	 */
	@Override
	public List<CartApplication> queryCartApplication() {
		List<CartApplication> list = cartApplicationMapper.queryCartApplicationByCondition();
		SessionUtil.setCurrent("cartapplication", list);
		System.out.println(list);
		return list;
	}
	
	/**
	 * 查询用户分期列表
	 */
	public List<StageUserInfoVO> queryStageUserInfoVOByCondition(){
		return htmlVoMapper.queryStageUserInfoVOByCondition();
	}

	@Override
	public List<OverFlows> queryAOverFlowsByCondition() {
		
		return overFlowsMapper.queryAOverFlowsByCondition();
	}

}
