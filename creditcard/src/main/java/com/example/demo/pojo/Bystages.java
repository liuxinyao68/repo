package com.example.demo.pojo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * 分期表
 * @author Administrator
 *
 */
@Getter
@Setter
@ToString
public class Bystages {

  private String id;
  private String version;
  /** 分期总金额 */
  private String totalmoney;
  /** 分期期数 */
  private String totalmonth;
  /** 利率 */
  private String rate;
  /** 每期应还 */
  private String monthsend;
  /** 已还期数 */
  private String endsendMonthnum;
  /** 卡id */
  private Integer credid;
  /** 提醒次数 */
  private String remindnum;
  /**创建时间*/
  private Date createtime;
  /**更新时间*/
  private Date updatetime;
  /**是否删除*/
  private String ifDelete;
}
