package com.example.demo.pojo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * 分页表
 * @author Administrator
 *
 * @param <T>  泛化,所有对象均可以使用该分页实体类
 */
@Data
public class Page<T> {

	/** 当前页   */
	private Integer currectPage;
	/** 页容量  */
	private Integer sizePage;
	/** 总页量  
	 *  totalPage = count%sizePage == 0 ? count/sizePage : count/sizePage + 1;
	 */
	private Integer totalPage;
	/** 显示多少页下标 */
	private Integer pages;
	/** 总纪录数 */
	private Integer count;
	/** 开始页  */
	private Integer startPage;
	/** 结束页 */
	private Integer endPage;
	
	/** 开始序列
	 *   (currectPage - 1) * sizePage + 1
	 */
	private Integer startNo;
	/** 结束 
	 * 
	 * currectPage*sizePage
	 */
	private Integer endNo;
	/** 当前页数据列表  */
	private List<T> list = new ArrayList<>();
	

}
