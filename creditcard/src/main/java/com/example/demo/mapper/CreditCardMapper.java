package com.example.demo.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.pojo.CreditCard;


@Mapper
public interface CreditCardMapper {
	
	/**
	 * 查询信用卡信息
	 * @param creditCard
	 * @return
	 */
	public List<CreditCard> queryCreditCardByCondition(CreditCard creditCard);
	
	/**
	 * 插入新的信用卡信息
	 * @param creditCard
	 * @return
	 */
	public int insertCreditCardByCondition(CreditCard creditCard);
	
	/**
	 * 更新信用卡信息
	 */
	public int updateCreditCartByCondition(CreditCard creditCard);

}
