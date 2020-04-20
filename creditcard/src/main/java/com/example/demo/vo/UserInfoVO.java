package com.example.demo.vo;

import java.util.Date;

import lombok.Data;

/**
 * 用户信息视图展示实体类
 * @author Administrator
 *
 */
@Data
public class UserInfoVO {
	
	private String cardId;
	private String userId;
	private String cardnumber;
	private String state;
	private Date createtime;
	private Double totalquota;
	private Double surplusquota;
	private Integer ifActivation;
	private Double temporaryquota;
	private Double surplustemporaryquota;
	private Double spending;
	private Double arrearage;
	private Double withdraw;
	private Double charge;
	private String realname;
	private Integer authscope;
	private Integer authgrade;
	private String idcartnumber;
	private String phone;
	private String applystate;
	private Integer ifBlackname;
	
}
