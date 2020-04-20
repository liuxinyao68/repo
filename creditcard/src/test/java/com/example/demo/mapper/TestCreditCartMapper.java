package com.example.demo.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.pojo.CreditCard;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCreditCartMapper {

	@Autowired
	private CreditCardMapper creditCardMapper;
	
	@Test
	public void queryCreditCard() {
		List<CreditCard> list = creditCardMapper.queryCreditCardByCondition(null);
		System.out.println(list);
	}
	
	@Test
	public void queryCreditCardByUserId() {
//		String UserId = "1000000001";
		
		String cardNumber = "6230522080016253";
		
		CreditCard creditCard = new CreditCard();
//		creditCard.setUserId(UserId);
		creditCard.setCardNumber(cardNumber);
		List<CreditCard> list = creditCardMapper.queryCreditCardByCondition(creditCard);
		System.out.println(list);
	}
	
	
	@Test
	public void insertCreditCard() {
		String cardNumber = "6222371310165581";
		String oldcard = "1000000045";
		String UserId = "1000000023";
		Date time= new Date(); 
		
		CreditCard creditCard = new CreditCard();
		creditCard.setCardNumber(cardNumber);
		creditCard.setUserId(UserId);
		creditCard.setCreateTime(time);
		creditCard.setUpdateTime(time);
		creditCard.setReplaceCardNumber(oldcard);
		int flag = creditCardMapper.insertCreditCardByCondition(creditCard);
		System.out.println(flag);
	}
	
	@Test
	public void updateCreditcart() {
		String id = null;
		String cardNumber = "6222371310165581";
		String userId = null;
		
		Integer ifMain = 1;
		Integer state = 1;
		Date updateTime = new Date();
		Double totalQuota = 10000.0; 
		String payPassword = "123456";
		Integer ifActivation = 1;
		String replaceCardNumber = "6230522080016251"; 
		Integer ifDelete = 1;
		
		
		CreditCard creditCard = new CreditCard();
		
		creditCard.setId(id);
		creditCard.setCardNumber(cardNumber);
		creditCard.setUserId(userId);
		creditCard.setIfMain(ifMain);
		creditCard.setState(state);
		creditCard.setUpdateTime(updateTime);
		creditCard.setTotalQuota(totalQuota);
		creditCard.setPayPassword(payPassword);
		creditCard.setIfActivation(ifActivation);
		creditCard.setReplaceCardNumber(replaceCardNumber);
		creditCard.setIfDelete(ifDelete);
		
		int flag = creditCardMapper.updateCreditCartByCondition(creditCard);
		System.out.println(flag);
	}
	

}
