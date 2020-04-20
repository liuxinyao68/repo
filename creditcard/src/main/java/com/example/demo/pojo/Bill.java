package com.example.demo.pojo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
/**
 * 账单流水表
 * @author Administrator
 *
 */
public class Bill {

	/**  */
	private String id;
	private String version;
	/** 收款用户 */
	private String receivepeople;
	/** 收款金额 */
	private String receivemoney;
	/**  */
	private String billtype;
	private String sendcardtype;
	/** 付款卡id */
	private String sendcardid;
	/** 用户id */
	private String userId;
	private Date createtime;
	private Date updatetime;
	private String ifDelete;


}
