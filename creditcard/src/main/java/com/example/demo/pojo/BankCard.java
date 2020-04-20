package com.example.demo.pojo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
/**
 * 银行卡管理表
 * @author Administrator
 *
 */
public class BankCard {

	/** 主键 */
	private String id;
	/** 银行卡号 */
	private String cardnumber;
	/** 银行类型 */
	private String banktype;
	/** 银行卡类别 */
	private String cardtype;
	/** 预留手机号 */
	private String cradphone;
	/**  */
	private Date createtime;
	/**  */
	private Date updatetime;
	/**  */
	private String ifDelete;
	/**  */
	private String defaultcard;

}
