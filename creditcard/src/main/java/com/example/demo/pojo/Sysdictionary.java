package com.example.demo.pojo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
/**
 * 字典类型表
 * @author Administrator
 *
 */
public class Sysdictionary {

  private String id;
  private String name;
  private String note;
  private Date createtime;
  private Date updatetime;
  private String ifDelete;

}
