package com.example.demo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
/**
 * 登入视图 实体类
 * @author Administrator
 *
 */
public class LoginVO {
	
	private Long id;
	private String password;
	private Long phone;
	private String phonecode;
	private String photocode;
	private String code;
}
