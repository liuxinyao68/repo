package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.CreditCard;

public interface CreditCardService {
	
	/**
	 * 查询信用卡 信息
	 */
	public List<CreditCard> queryCreditCardByCondition(String id);
	
	/**
	 * 插入信用卡
	 */
	public int insertCreditCardByCondition(CreditCard creditCard);
	
	/**
	 * 更新信用卡信息
	 */
	public int updateCreditCartByCondition(CreditCard creditCard);

	/**
	 * 检查用户支付密码是否正确
	 */
	public boolean checkPayPassword(String id, String payPassword);

	/**
	 * 通过用户id查询信用卡号集合
	 */
	public List<String> queryCreditByUid(String id);

}
