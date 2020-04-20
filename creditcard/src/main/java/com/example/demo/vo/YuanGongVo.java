package com.example.demo.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.demo.pojo.UserInfo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 分页实体类
 * 
 * @author Administrator
 *
 */
@Getter
@Setter
@ToString
public class YuanGongVo {
	private int pageNum = 1;

	private int pageSize = 10;
	private Long id;// 员工编号
	private Date createtime;
	private Date endcreatetime;
	private Long phone;
	private Integer ifDelete;

	private List<UserInfo> Materials = new ArrayList<UserInfo>();

	public List<UserInfo> getMaterials() {
		return Materials;
	}

	public void setMaterials(List<UserInfo> Materials) {
		this.Materials = Materials;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
