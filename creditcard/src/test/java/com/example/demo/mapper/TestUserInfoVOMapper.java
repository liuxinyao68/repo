package com.example.demo.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.vo.UserInfoVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserInfoVOMapper {

	@Autowired
	private UserInfoVOMapper userInfoVOMapper;
	
	@Test
	public void queryAllUserInfo() {
		List<UserInfoVO> list = userInfoVOMapper.queryCreditcardAndUserinfoByCondition(null);
		System.out.println(list);
	}
	
	@Test
	public void queryBillingDate() {
		List<UserInfoVO> list = userInfoVOMapper.queryBillingDateByCondition(null);
		System.out.println(list);
	}
	
	@Test
	public void queryBillingDateByCardId() {
		// 1000000015
		String cardId = "1000000015";
		UserInfoVO userInfoVO = new UserInfoVO();
		
		userInfoVO.setCardId(cardId);
		List<UserInfoVO> list = userInfoVOMapper.queryBillingDateByCondition(userInfoVO);
		System.out.println(list);
	}
	
	@Test
	public void queryUserInfoVOByCardnumber() {
		// 6230522080016251
		String cardnumber = "6230522080016251";
		// 张三
		String realname = "";
		// 441568199525521878
		String idcartnumber = "";
		UserInfoVO userInfoVO = new UserInfoVO();
		
		userInfoVO.setCardnumber(cardnumber);
		userInfoVO.setRealname(realname);
		userInfoVO.setIdcartnumber(idcartnumber);
		
		String cardId = "";
		
		List<UserInfoVO> list = userInfoVOMapper.queryCreditcardAndUserinfoByCondition(userInfoVO);
		cardId = list.get(0).getCardId();
		userInfoVO = (list == null || list.size() == 0) ? null :list.get(0);
		if(userInfoVO != null) {
			System.out.println(cardId);
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
		}else {
			System.out.println("没有该用户");
		}
		System.out.println(userInfoVO);
	}
	


	


}
