package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.LoginInfoService;
import com.example.demo.vo.LoginVO;
import com.example.demo.vo.BackResultVO;

@Controller
public class LoginInfoController {

	@Autowired
	private LoginInfoService loginInfoService;

	/**
	 * 管理员用户登入接口
	 * @param loginVO
	 * @return
	 */
	@RequestMapping("/loginAdmin.do")
	@ResponseBody
	public BackResultVO loginAdmin(LoginVO loginVO) {
		System.out.println(loginVO);
		BackResultVO rs = new BackResultVO();
		if(!loginVO.getPhonecode().equals(loginVO.getCode())) {
			rs.setSuccess(false);
			rs.setMsg("手机验证码错误");
			return rs;
		}
		Long id = loginVO.getId();
		System.out.println(loginVO);
		String password = loginVO.getPassword();
		Long phone = loginVO.getPhone();
		int flag = loginInfoService.loginAdmin(id, password,phone);
		switch(flag) {
			case 0:
				rs.setSuccess(true);
				break;
			case -1:
				rs.setSuccess(false);
				rs.setMsg("该账号未被注册");
				break;
			case 1:
				rs.setSuccess(false);
				rs.setMsg("该账号以被冻结");
				break;
			case 2:
				rs.setSuccess(false);
				rs.setMsg("你不是管理员无法注册");
				break;
			case 3:
				rs.setSuccess(false);
				rs.setMsg("手机号码有误");
				break;
			default:
				break;
		}

		return rs;
	}
	
	

}
