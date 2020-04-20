package com.example.demo.web.api;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.util.SMSSendUtil;

@Controller
public class UtilsController {

	/**
	 * 验证用户手机号是否为默认手机号，再创建随机手机验证码，并发给该手机号
	 * @param info  其中必须包含信用卡id和用户手机号
	 * @return  返回验证码或者false
	 */
	@RequestMapping("/getCode.do")
	@ResponseBody
	public String getPhoneCode(@RequestParam Map<String,Object> info) {
		System.out.println(info);
		String phone = (String)info.get("phone");
		if(phone == null) {
			return "false";
		}
		String code = SMSSendUtil.getPhoneCode(phone);
		return code;
	}
	
}
