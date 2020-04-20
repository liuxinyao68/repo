package com.example.demo.service;


import com.example.demo.pojo.LoginInfo;
import com.example.demo.vo.LoginInfoVo;
import com.example.demo.vo.YuanGongVo;
import com.github.pagehelper.PageInfo;

public interface YuanGongService {
	/**
	 * 员工分页查询
	 * @param yuanGongVo
	 * @return
	 */
	PageInfo<LoginInfo> queryByUserInfo(YuanGongVo yuanGongVo) throws Exception;
	/**
	 * 批量删除
	 * @param ids
	 * @throws Exception
	 */
	void batchDeletUser(int[] ids) throws Exception;
	/**
	 * 修改用户信息
	 * @param loginIfVo
	 */
	void updateLoginInf(LoginInfoVo loginIfVo) throws Exception ;
	/**
	 * 根据员工id查询员工信息
	 * @param id
	 * @return
	 */
	LoginInfo queryGoodById(int id) throws Exception;
	/**
	 * 删除员工信息
	 * @param id
	 */
	void deletLogin(int id) throws Exception;
	/**
	 * 添加员工
	 * @param loginInfo
	 */
	void addLoginInfo(LoginInfo loginInfo) throws Exception; 

}
