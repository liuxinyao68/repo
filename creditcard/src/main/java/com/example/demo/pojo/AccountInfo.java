package com.example.demo.pojo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
/**
 * 账户信息表
 * @author Administrator
 *
 */
public class AccountInfo {

	/** 账户表主键 */
	private String id;
	/** 版本号，乐观锁 */
	private String version;
	/** 总额度 */
	private String allquota;
	/** 可用额度 */
	private String canusequota;
	/** 冻结额度 */
	private String frozenquota;
	/** 每月应还金额 */
	private String monthsend;
	/** 支付密码 */
	private String paypassword;
	/** 创建时间 */
	private Date createtime;
	/** 更新时间 */
	private Date updatetime;
	/** 是否删除 */
	private String ifDelete;

}
