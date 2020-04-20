package com.example.demo.pojo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * 用户登入表
 * @author Administrator
 *
 */
@Getter
@Setter
@ToString
public class LoginInfo {

  private Long id;
  /** 电话 */
  private Long phone;
  private String password;
  private Integer state;
  /** 用户类型 */
  private Integer usertype;
  private Date createtime;
  private Date updatetime;
  private Integer ifDelete;


}
