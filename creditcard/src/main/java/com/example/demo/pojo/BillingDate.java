package com.example.demo.pojo;

import java.util.Date;

import lombok.Data;

@Data
/**
 * 用户额度管理表
 * @author Administrator
 *
 */
public class BillingDate {
	
	private String id;
	private String version;
	private String state;
	private String cardId;
	private Date tixiantime;
	private Double surplusQuota;    //剩余额度
	private Double temporaryQuota;       //临时额度
	private Double surplusTemporaryQuota;//剩余临时额度	  
	private Double spending;             //本期消费额度
	private Double arrearage;            //上月剩余账单金额
	private Double withdraw;             //本期提现金额
	private Double charge;               //本期提现手续费
}
