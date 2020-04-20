package com.example.demo.pojo;

import java.util.Date;

import lombok.Data;

/**
 * 前端展示字段
 * 用户表+信用卡表信息展示
 * @author Administrator
 *
 */
@Data
public class CartApplication {

	/** 序列号 */
	private Long id;
	/** 申请序列  */
	private Long applyid;
	/** 用户名  */
	private String name;
	/** 真实姓名  */
	private String realname;
	/**  联系方式 */
	private String phone;
	/**  身份证号码 */
	private String cartnumber;
	/**  邮箱 */
	private String email;
	/**  家庭地址 */
	private String address;
	/**  寄卡地址 */
	private String sendaddress;
	/**  学历 */
	private String education;
	/**  婚姻 */
	private String marriage;
	/**  房产 */
	private String ifhaveroom;
	/**  公司 */
	private String unitname;
	/**  任职 */
	private String job;
	/**  公司地址 */
	private String companyaddress;
	/**  申请时间 */
	private Date createtime;
	
}
