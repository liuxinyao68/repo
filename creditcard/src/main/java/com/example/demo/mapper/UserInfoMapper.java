package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.pojo.Count;
import com.example.demo.pojo.Page;
import com.example.demo.pojo.UserInfo;

@Mapper
public interface UserInfoMapper {
	
	/**
	 * 查询用户信息
	 * @param userInfo
	 * @return
	 */
	public List<UserInfo> queryUserInfoByCondition(UserInfo userInfo);
	
	/**
	 * 插入用户信息
	 * @param userInfo
	 * @return
	 */
	public int insertUserInfoByCondition(UserInfo userInfo);
	
	/**
	 * 根据是否加入黑名单查询用户数量
	 * @param id
	 * @return
	 */
	public Count queryCountOfUserInfo(Integer ifBlackName);
	
	/**
	 * 分页查询所有在黑名单中的用户信息
	 * @param page
	 * @return
	 */
	public List<UserInfo> queryBalckUserInfoByPage(Page<UserInfo> page);
	
	/**
	 * 分页查询所有用户信息
	 * @param page
	 * @return
	 */
	public List<UserInfo> queryAllUserInfoByPage(Page<UserInfo> page);

	/**
	 * 修改userinfo表信息
	 * @param userInfo
	 */
	public void updateUserInfoByCondition(UserInfo userInfo);

}
