package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.CreditCardMapper;
import com.example.demo.pojo.CreditCard;
import com.example.demo.service.CreditCardService;

@Service("creditCardService")
public class CreditCardServiceImpl implements CreditCardService {

	@Autowired
	private CreditCardMapper creditCardMapper;

	/**
	 * 查询信用卡 信息
	 */
	@Override
	public List<CreditCard> queryCreditCardByCondition(String id) {
		CreditCard creditCard = new CreditCard();
		creditCard.setId(id);
		return creditCardMapper.queryCreditCardByCondition(creditCard);
	}

	/**
	 * 插入信用卡
	 */
	@Override
	public int insertCreditCardByCondition(CreditCard creditCard) {
		creditCard.setUpdateTime(new Date());
		return creditCardMapper.insertCreditCardByCondition(creditCard);
	}

	/**
	 * 更新信用卡信息
	 */
	@Override
	public int updateCreditCartByCondition(CreditCard creditCard) {
		creditCard.setUpdateTime(new Date());
		return creditCardMapper.updateCreditCartByCondition(creditCard);
	}

	/**
	 * 检查用户支付密码是否正确
	 */
	@Override
	public boolean checkPayPassword(String id,String payPassword) {
		CreditCard creditCard = new CreditCard();
		creditCard.setId(id);
		creditCard.setPayPassword(payPassword);
		List<CreditCard> list = creditCardMapper.queryCreditCardByCondition(creditCard);
		if( list == null || list.size() == 0 )
		{
			return false;
		}
		return true;
	}

	/**
	 * 通过用户id查询信用卡号集合
	 */
	@Override
	public List<String> queryCreditByUid(String id) {
		CreditCard creditCard = new CreditCard();
		creditCard.setUserId(id);

		List<String> list = new ArrayList<>();
		List<CreditCard> creditCardList = creditCardMapper.queryCreditCardByCondition(creditCard);
		for(CreditCard credit:creditCardList) {
			list.add(credit.getCardNumber());
		}
		return list;
	}

}
