package com.example.demo.vo;

import java.util.ArrayList;
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
public class BaoBiaoVo {
	private int pageNum = 1;

	private int pageSize = 10;
	private String createtime;
	private String endcreatetime;

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


}
