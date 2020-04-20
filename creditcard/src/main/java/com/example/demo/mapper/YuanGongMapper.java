package com.example.demo.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.pojo.LoginInfo;
import com.example.demo.vo.LoginInfoVo;

@Mapper
public interface YuanGongMapper {
	/**
	 * 查询所有用户
	 * @param yuanGongVo
	 * @return
	 */
	List<LoginInfo> queryByUserInfoAll(LoginInfo loginInfo) throws Exception;
	/**
	 * 根据id批量删除员工  软删除
	 * @param ids
	 */
	void batchDeletUserById(int[] ids) throws Exception;
	/**
	 * 根据员工id查询员工信息
	 * @param id
	 * @return
	 */
	LoginInfo queryGoodById(int id) throws Exception;
	/**
	 * 修改员工信息
	 * @param loginIfVo
	 * @throws Exception
	 */
	void updateLoginInf(LoginInfoVo loginIfVo) throws Exception ;
	/**
	 * 删除员工信息
	 * @param id
	 */
	void deletLogin(int id) throws Exception ;
	/**
	 * 添加员工
	 * @param loginInfo
	 */
	void addLoginInfo(LoginInfo loginInfo) throws Exception;

}
