package com.example.demo.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 数据字典信息
 * 
 * @author Administrator
 *
 */
@Setter
@Getter
@ToString
public class ShuJuZiDianNeiRongVo {
	private String id;
	private String parentid;
	private String name;
	private String sequence;
	private Date updatetime;
	private String ifDelete;
}
