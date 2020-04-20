package com.example.demo.pojo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
/**
 * 用户基本信息
 * @author Administrator
 *
 */
public class UserInfo {

  private String id;
  private String version;
  /** 位状态 用户认证的信息状况 */
  private String bitstate;
  /** 认证信用分数 */
  private String authscore;
  /** 认证信用等级 */
  private String authgrade;
  /** 用户真实姓名 */
  private String realname;
  /** 身份证号码 */
  private String idcardnumber;
  /** 电话 */
  private String phone;
  private Date createtime;
  private Date updatetime;
  private String ifDelete;
  /** 所在城市 */
  private String citynow;
  /** 申请的具体信息id */
  private String applyinfoId;
  /** 当前信用卡的申请状态 */
  private String applystate;
  /** 信用卡的主键 */
  private String ifBlackname;


}
