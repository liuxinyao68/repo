package com.example.demo.pojo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
/**
 * ip登入日志情况表
 * @author Administrator
 *
 */
public class IpLog {

  private String id;
  private String ip;
  /** 登入状态 */
  private String loginstatenow;
  /** 登入的用户 */
  private String loginuserId;  //通过该字段与用户登入表进行整合
  /** 登入的用户类型 */
  private String loginusertype;
  private Date logintime;
  private Date createtime;
  private Date updatetime;
  private String ifDelete;


}
