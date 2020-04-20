package com.example.demo.pojo;

import java.util.Date;

import lombok.Data;

@Data
/**
 * 分期表展示
 * 用户表+信用卡表+分期表
 * @author Administrator
 *
 */
public class StageUserInfoVO {
	
	private String stageId;
	private Double totalmoney;
	private Integer totalmonth;
	private Double rate;
	private Double monthsend;
	private Integer endsendMonthnum;
	private Integer remindnum;
	private Date createtime;
	private Date updatetime;
	private String cardId;
	
	private String idcardnumber;
	private String realname;
	private String phone;
	private Integer ifBlackname;
	private String cardnumber;


}
