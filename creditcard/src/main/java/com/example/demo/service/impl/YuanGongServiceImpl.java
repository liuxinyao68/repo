package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.YuanGongMapper;
import com.example.demo.pojo.LoginInfo;
import com.example.demo.service.YuanGongService;
import com.example.demo.util.DateZhuanHuanUtil;
import com.example.demo.vo.LoginInfoVo;
import com.example.demo.vo.YuanGongVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class YuanGongServiceImpl implements YuanGongService {
	@Autowired
	private YuanGongMapper yuanGongMapper;

	/**
	 * 分页查询员工信息
	 */
	@Override
	public PageInfo<LoginInfo> queryByUserInfo(YuanGongVo yuanGongVo) throws Exception {
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setId(yuanGongVo.getId());
		loginInfo.setIfDelete(yuanGongVo.getIfDelete());
		loginInfo.setPhone(yuanGongVo.getPhone());
		loginInfo.setCreatetime(yuanGongVo.getCreatetime());
		PageHelper.startPage(yuanGongVo.getPageNum(), yuanGongVo.getPageSize());
		List<LoginInfo> list = yuanGongMapper.queryByUserInfoAll(loginInfo);
		PageInfo<LoginInfo> logInfo = new PageInfo<LoginInfo>(list);
		return logInfo;
	}

	/**
	 * 批量删除
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void batchDeletUser(int[] ids) throws Exception {
		try {
			yuanGongMapper.batchDeletUserById(ids);
			return;
		} catch (RuntimeException e) {
			throw new RuntimeException("删除失败!!");
		}

	}

	/**
	 * 修改员工信息
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateLoginInf(LoginInfoVo loginIfVo) throws Exception {
		try {
			yuanGongMapper.updateLoginInf(loginIfVo);
		} catch (RuntimeException e) {
			throw new RuntimeException("修改失败!!");
		}

	}

	/**
	 * 根据员工id 查询员工信息
	 */
	@Override
	public LoginInfo queryGoodById(int id) throws Exception {
		return yuanGongMapper.queryGoodById(id);
	}

	/**
	 * 删除员工信息
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deletLogin(int id) throws Exception {

		try {
			yuanGongMapper.deletLogin(id);
		} catch (RuntimeException e) {
			throw new RuntimeException("修改失败!!");
		}
	} 

	/**
	 * 添加员工
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addLoginInfo(LoginInfo loginInfo)throws Exception{
		try {
			Date date = DateZhuanHuanUtil.convertDate(new Date());
			loginInfo.setCreatetime(date);
			loginInfo.setUpdatetime(date);
			yuanGongMapper.addLoginInfo(loginInfo);
		} catch (RuntimeException e) {
			throw new RuntimeException("添加失败!!");
		}
	}

}
