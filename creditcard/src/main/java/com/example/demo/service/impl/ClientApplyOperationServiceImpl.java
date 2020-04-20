package com.example.demo.service.impl;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.ApplyInfoMapper;
import com.example.demo.mapper.CreditCardMapper;
import com.example.demo.mapper.UserInfoMapper;
import com.example.demo.pojo.ApplyInfo;
import com.example.demo.pojo.CreditCard;
import com.example.demo.pojo.UserInfo;
import com.example.demo.service.ClientApplyOperationService;
import com.example.demo.util.CartRandomUtil;

/**
 * 信用卡处理操作
 * @author Administrator
 *
 */
@Service("clientApplyOperationService")
public class ClientApplyOperationServiceImpl implements ClientApplyOperationService {

	@Autowired
	private ApplyInfoMapper applyInfoMapper ;
	
	@Autowired
	private CreditCardMapper creditCardMapper;
	
	@Autowired
	private UserInfoMapper userInfoMapper;

	/**
	 * 根据用户id办理用户卡的办理或者不办理
	 * id可以多个
	 * Long[] applyid   用户id列表
	 * boolean method   处理方式，true办理卡，false不办理卡
	 */
	@Override
	public boolean handleCardRequest(Long[] applyid, boolean method) {
		if(method) {
			//同意办卡申请
			for(int i=0;i<applyid.length;i++)
			{
				String id = applyid[i] + "";
				String cardId = null;
				CreditCard creditCard = new CreditCard();
				List<CreditCard> list = null;
				do {
					cardId = CartRandomUtil.getCart();
					creditCard.setCardNumber(cardId);
					list = creditCardMapper.queryCreditCardByCondition(creditCard);
				}while(list == null);
				ApplyInfo applyInfo = new ApplyInfo();
				applyInfo.setId(id);
				UserInfo userInfo = new UserInfo();
				userInfo.setApplyinfoId(id);
				List<UserInfo> listUserInfo = userInfoMapper.queryUserInfoByCondition(userInfo);
				if( listUserInfo == null || listUserInfo.size() == 0) {
					System.out.println("用户信息不完整，无法办理信用卡");
					break;
				}
				String UserId = listUserInfo.get(0).getId();
				System.out.println("先得到用户id" + UserId);
				
				Date time= new Date(); 
				creditCard.setUserId(UserId);
				creditCard.setCreateTime(time);
				creditCard.setUpdateTime(time);
				creditCard.setReplaceCardNumber("");
				
				
				System.out.println("需要插入的卡信息" + creditCard);
				
				/**
				 * 加入一张新卡操作
				 */
				creditCardMapper.insertCreditCardByCondition(creditCard);
				/**
				 * 软删除请求纪录
				 */
				applyInfoMapper.updateIfDelete(applyInfo);
				
				
				System.out.println("新卡办理成功");
				System.out.println("用户id:" + UserId);
				System.out.println("卡号为：" + cardId);
			}
		}else {
			//驳回办卡申请
			for(int i=0;i<applyid.length;i++)
			{
				String id = applyid[i] + "";
				
				ApplyInfo applyInfo = new ApplyInfo();
				applyInfo.setId(id);
				System.out.println("办卡请求以被驳回，请核实信息后再次申请");
				System.out.println("用户名：" + id);
//				applyInfoMapper.updateIfDelete(applyInfo);
				
			}
			return false;
		}
		return true;
	}

}
