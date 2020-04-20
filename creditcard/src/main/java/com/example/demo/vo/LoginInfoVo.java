package com.example.demo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 页面传递的员工信息
 * @author Administrator
 *
 */
@Setter
@Getter
@ToString
public class LoginInfoVo {
	/**员工id*/
	private Long id;
	/** 电话 */
	private Long phone;
	/**员工密码*/
	private String password;
	/**是否被删除*/
	private Integer ifDelete;
}
