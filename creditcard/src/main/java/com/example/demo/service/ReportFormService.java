package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.Bill;
import com.example.demo.pojo.Bystages;
import com.example.demo.vo.BaoBiaoVo;
import com.github.pagehelper.PageInfo;

public interface ReportFormService {
	/**
	 * 分页查询分期报表
	 * @param baoBiaoVo 
	 * @return
	 */
	PageInfo<Bystages> getAll(BaoBiaoVo baoBiaoVo);
	/**
	 * 分页查询流水报表
	 * @param yuanGongVo 
	 * @return
	 */
	PageInfo<Bill> getBillAll(BaoBiaoVo baoBiaoVo) throws Exception;
	/**
	 * 打印流水报表
	 * @param yuanGongVo 
	 * @return
	 */
	List<Bill> getBillAlls(BaoBiaoVo baoBiaoVo);
	/**
	 * 打印分期报表
	 * @param baoBiaoVo
	 * @return
	 */
	List<Bystages> getAlls(BaoBiaoVo baoBiaoVo);

}
