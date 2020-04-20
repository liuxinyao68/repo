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
public class SysdictionaryItem {

  private String id;
  private String parentid;
  private String name;
  private String sequence;
  private Date createtime;
  private Date updatetime;
  private String ifDelete;

}
