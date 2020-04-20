package com.example.demo.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 报表带条件分页查询页面传递参数转换类
 * @author Administrator
 *
 */
@Getter
@Setter
@ToString
public class BaoBiaosVo {
	private Date createtime;
	private Date endcreatetime;
}
