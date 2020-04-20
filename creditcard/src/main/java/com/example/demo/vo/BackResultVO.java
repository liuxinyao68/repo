package com.example.demo.vo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
/**
 * 信息返回实体类
 * @author Administrator
 *
 */
public class BackResultVO {
	
	private boolean success;
	private String msg;
	private Object data;

}
