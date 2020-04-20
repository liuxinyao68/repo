package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.pojo.Bill;
import com.example.demo.pojo.Bystages;
import com.example.demo.vo.BaoBiaosVo;
@Mapper
public interface ReportFormMapper {
	/**
	 * 查询流水表所有信息
	 * @param baoBiaosVo 
	 * @return
	 */
	List<Bill> getBillAll(BaoBiaosVo baoBiaosVo);
	/**
	 * 查询分期表所有信息
	 * @param baoBiaosVo
	 * @return
	 */
	List<Bystages> getBystagesAll(BaoBiaosVo baoBiaosVo);

}
