package com.example.demo.pojo;

import java.util.Date;

import lombok.Data;

@Data
/**
 * 信用卡信息表
 * @author Administrator
 *
 */
public class CreditCard {

	  private String id;              //主键
	  private String cardNumber;       //卡号
	  private Integer ifMain;          
	  private Integer state;           //当前卡的状态, 如注销, 正常等
	  private String userId;          //用户id  通过该键与用户表整合
	  private Date createTime;        
	  private Date updateTime;
	  private Integer ifDelete;       
	  private Double totalQuota;      //总额度
	  private String payPassword;      //支付密码
	  private Date enableStartTime;    //
	  private Integer ifActivation;
	  private Date enableEndTime;
	  private Integer version;              //版本
	  private String replaceCardNumber;     //
	  private String chu;                   //出账日(默认3号)
	  private String huan;                  //还款日(默认23号)

}
