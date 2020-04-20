package com.example.demo.pojo;

import java.util.Date;

import lombok.Data;

@Data
public class OverFlows {
	
	private String id;
	private Integer version;
	private Double totalinterest;
	private String username;
	private String idcard;   //身份证
	private String creditcardId;  //信用卡号
	private String phone;
	private String address;
	private Double repay;
	private Double needpay;
	private Date createtime;
	private Date updatetime;
	private Integer ifDelete;


}
