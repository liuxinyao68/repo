package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.UserInfoVOMapper;
import com.example.demo.service.SingleUserDealService;
import com.example.demo.vo.UserInfoVO;

@Service("singleUserDealService")
public class SingleUserDealServiceImpl implements SingleUserDealService {
	
	@Autowired
	private UserInfoVOMapper userInfoVOMapper;

	
	/**
	 * 
	 * 查询单个用户信息
	 * 三表联查用户表，信用卡表，分期情况表
	 *
	 */
	@Override
	public UserInfoVO queryUserDetailInfo(String realname, String idcartnumber, String cardnumber) {
		
		UserInfoVO userInfoVO = new UserInfoVO();
		
		userInfoVO.setCardnumber(cardnumber);
		userInfoVO.setRealname(realname);
		userInfoVO.setIdcartnumber(idcartnumber);
		
		List<UserInfoVO> list = userInfoVOMapper.queryCreditcardAndUserinfoByCondition(userInfoVO);
		userInfoVO = (list == null || list.size() == 0) ? null :list.get(0);
		if(userInfoVO != null) {
			List<UserInfoVO> list2 = userInfoVOMapper.queryBillingDateByCondition(list.get(0));
			UserInfoVO userInfoVO2 = new UserInfoVO();
			userInfoVO2 = (list2 == null || list2.size() == 0) ? null :list2.get(0);
			if(userInfoVO2 != null) {
				userInfoVO.setTemporaryquota(userInfoVO2.getTemporaryquota());
				userInfoVO.setSurplustemporaryquota(userInfoVO2.getSurplustemporaryquota());
				userInfoVO.setSurplusquota(userInfoVO2.getSurplusquota());		
				userInfoVO.setSpending(userInfoVO2.getSpending());
				userInfoVO.setArrearage(userInfoVO2.getArrearage());
				userInfoVO.setWithdraw(userInfoVO2.getWithdraw());
				userInfoVO.setCharge(userInfoVO2.getCharge());
			}
			System.out.println(userInfoVO);
			return userInfoVO;
		}else {
			System.out.println("没有该用户");
			return null;
		}
	}
	
	/**
	 * 查询用户信用卡的分期信息情况
	 */
	@Override
	public List<UserInfoVO> queryUserDetailInfoBy(String realname, String idcartnumber, String cardnumber) {
		
		UserInfoVO userInfoVO = new UserInfoVO();
		
		userInfoVO.setCardnumber(cardnumber);
		userInfoVO.setRealname(realname);
		userInfoVO.setIdcartnumber(idcartnumber);
		
		List<UserInfoVO> list = userInfoVOMapper.queryCreditcardAndUserinfoByCondition(userInfoVO);
		return list;
	}

}
