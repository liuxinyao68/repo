package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.LoginInfoMapper;
import com.example.demo.pojo.LoginInfo;
import com.example.demo.service.LoginInfoService;
import com.example.demo.util.SessionUtil;

@Service("loginInfoService")
public class LoginInfoServiceImpl implements LoginInfoService {
	
	@Autowired
	private LoginInfoMapper loginInfoMapper;

	
	/**
	 * 管理员登入
	 */
	@Override
	public int loginAdmin(Long id, String password,Long phone) {
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setId(id);
		loginInfo.setPassword(password);
		List<LoginInfo> list = loginInfoMapper.queryLoginInfoByCondition(loginInfo);
		loginInfo = list == null || list.size() == 0 ? null : list.get(0);
		if(loginInfo != null) {
			if(!(loginInfo.getPhone()).equals(phone)) {
				return 3;  //手机号不正确
			}
			if(loginInfo.getState() == 1 || loginInfo.getIfDelete() == 1) {
				System.out.println("------>" + "用户已注销账户或者冻结账户");
				//用户已注销账户或者冻结账户
				return 1;
			}else {
				if(loginInfo.getUsertype() == 0) {
					System.out.println("------>" + "你不是管理员，无法登入");
					return 2;
				}else {
					SessionUtil.setCurrent("loginInfo", loginInfo);
					//登入成功
					System.out.println("------>" + "登入成功");
					return 0;
				}
			}
		}
		//该用户还没注册
		System.out.println("------>" + "该用户还没注册");
		return -1;
	}

}
