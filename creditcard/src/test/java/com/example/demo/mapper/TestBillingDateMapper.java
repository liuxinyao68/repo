package com.example.demo.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.pojo.BillingDate;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBillingDateMapper {

	@Autowired
	private BillingDateMapper billingDateMapper ;
	
	
	@Test
	public void queryAllLogininfo() {
		String cardId = "1000000017";
		BillingDate billingDate = new BillingDate();
		billingDate.setCardId(cardId);
		List<BillingDate> list = billingDateMapper.queryBillingDateByCondition(null);
		System.out.println(list);
	}
	

}
