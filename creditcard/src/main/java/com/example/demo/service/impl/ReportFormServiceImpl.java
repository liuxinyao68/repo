package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.ReportFormMapper;
import com.example.demo.pojo.Bill;
import com.example.demo.pojo.Bystages;
import com.example.demo.service.ReportFormService;
import com.example.demo.util.DateZhuanHuanUtil;
import com.example.demo.vo.BaoBiaoVo;
import com.example.demo.vo.BaoBiaosVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ReportFormServiceImpl implements ReportFormService {

	@Autowired
	private ReportFormMapper reportFormMapper;

	/**
	 * 分页查询流水表
	 */
	@Override
	public PageInfo<Bill> getBillAll(BaoBiaoVo baoBiaoVo) throws Exception {
		// 创建一个转换类用来接转换页面传递的值的数据类型然后传递给mapper层
		BaoBiaosVo baoBiaosVo = new BaoBiaosVo();
		// 判断页面传递的参数是否为空
		if (!"null".equals(baoBiaoVo.getCreatetime())) {
			baoBiaosVo.setCreatetime(DateZhuanHuanUtil.parseDate(baoBiaoVo.getCreatetime()));
		}
		if (!"null".equals(baoBiaoVo.getEndcreatetime())) {
			baoBiaosVo.setEndcreatetime(DateZhuanHuanUtil.parseDate(baoBiaoVo.getEndcreatetime()));
		}
		// 调用分页插件
		PageHelper.startPage(baoBiaoVo.getPageNum(), baoBiaoVo.getPageSize());
		// 查询数据库
		List<Bill> list = reportFormMapper.getBillAll(baoBiaosVo);
		// 返回参数放入分页插件pageInfo中
		PageInfo<Bill> bill = new PageInfo<Bill>(list);
		// 返回分页后的数据
		return bill;
	}

	/**
	 * 打印流水报表信息
	 */
	@Override
	public List<Bill> getBillAlls(BaoBiaoVo baoBiaoVo) {
		// 创建一个转换类用来接转换页面传递的值的数据类型然后传递给mapper层
		BaoBiaosVo baoBiaosVo = new BaoBiaosVo();
		// 判断页面传递的参数是否为空
		if (!"null".equals(baoBiaoVo.getCreatetime())) {
			baoBiaosVo.setCreatetime(DateZhuanHuanUtil.parseDate(baoBiaoVo.getCreatetime()));
		}
		if (!"null".equals(baoBiaoVo.getEndcreatetime())) {
			baoBiaosVo.setEndcreatetime(DateZhuanHuanUtil.parseDate(baoBiaoVo.getEndcreatetime()));
		}
		// 返回要打印的数据
		return reportFormMapper.getBillAll(baoBiaosVo);
	}

	/**
	 * 分页查询分期报表
	 */
	@Override
	public PageInfo<Bystages> getAll(BaoBiaoVo baoBiaoVo) {
		// 创建一个转换类用来接转换页面传递的值的数据类型然后传递给mapper层
		BaoBiaosVo baoBiaosVo = new BaoBiaosVo();
		// 判断页面传递的参数是否为空
		if (!"null".equals(baoBiaoVo.getCreatetime())) {
			baoBiaosVo.setCreatetime(DateZhuanHuanUtil.parseDate(baoBiaoVo.getCreatetime()));
		}
		if (!"null".equals(baoBiaoVo.getEndcreatetime())) {
			baoBiaosVo.setEndcreatetime(DateZhuanHuanUtil.parseDate(baoBiaoVo.getEndcreatetime()));
		}
		// 调用分页插件
		PageHelper.startPage(baoBiaoVo.getPageNum(), baoBiaoVo.getPageSize());
		// 查询数据库
		List<Bystages> list = reportFormMapper.getBystagesAll(baoBiaosVo);
		// 返回参数放入分页插件pageInfo中
		PageInfo<Bystages> bill = new PageInfo<Bystages>(list);
		// 返回分页后的数据
		return bill;
	}

	@Override
	public List<Bystages> getAlls(BaoBiaoVo baoBiaoVo) {
		// 创建一个转换类用来接转换页面传递的值的数据类型然后传递给mapper层
		BaoBiaosVo baoBiaosVo = new BaoBiaosVo();
		// 判断页面传递的参数是否为空
		if (!"null".equals(baoBiaoVo.getCreatetime())) {
			baoBiaosVo.setCreatetime(DateZhuanHuanUtil.parseDate(baoBiaoVo.getCreatetime()));
		}
		if (!"null".equals(baoBiaoVo.getEndcreatetime())) {
			baoBiaosVo.setEndcreatetime(DateZhuanHuanUtil.parseDate(baoBiaoVo.getEndcreatetime()));
		}
		// 返回要打印的数据
		return reportFormMapper.getBystagesAll(baoBiaosVo);
	}

}
