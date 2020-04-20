package com.example.demo.pojo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
/**
 * 信用卡申请申请表
 * 用户的详细信息存储表
 * @author Administrator
 *
 */
public class ApplyInfo {

	/** 主键 */
	private String id;
	/** 婚姻状况 */
	private String marriageId;
	/** 学历状况 */
	private String educationId;
	/**  */
	private String contactstype;
	/**  */
	private String contactname;
	/**  */
	private String contactphone;
	/**  */
	private String email;
	/**  */
	private String homeprovince;
	/**  */
	private String homecity;
	/**  */
	private String homeregion;
	/**  */
	private String homeaddress;
	/**  */
	private String ifhaveRoom;
	/**  */
	private String liveYears;
	/**  */
	private String carnumber;
	/**  */
	private String carbrand;
	/**  */
	private String job;
	/**  */
	private Date creditcardstarttime;
	/**  */
	private Date creditcardendtime;
	/**  */
	private String sendcardaddress;
	/**  */
	private String unitname;
	/**  */
	private String postname;
	/**  */
	private String workYears;
	/**  */
	private String companyprovince;
	/**  */
	private String companycity;
	/**  */
	private String companyregion;
	/**  */
	private String companyaddress;
	/**  */
	private String companyphonetype;
	/**  */
	private String companyphone;
	/**  */
	private Date createtime;
	/**  */
	private Date updatetime;
	/**  */
	private String ifDelete;


}
