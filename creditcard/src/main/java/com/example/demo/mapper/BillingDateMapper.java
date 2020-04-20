package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.pojo.BillingDate;

@Mapper
public interface BillingDateMapper {
	
	/**
	 * 查询BillingDate表信息
	 * @param billingDate
	 * @return
	 */
	public List<BillingDate> queryBillingDateByCondition(BillingDate billingDate);
	

}
