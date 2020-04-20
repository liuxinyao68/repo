package com.example.demo.web.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirctViewController {
	
	@RequestMapping("/incrlimit.do")
	public String incrLimit() {
		return "view/incrlimit";
	}
	
	
	@RequestMapping("/userList.do")
	public String userList() {
		return "view/userList";
	}
	
	@RequestMapping("/communication.do")
	public String communication() {
		return "view/communication";
	}
	
	@RequestMapping("/loginInfo.do")
	public String loginInfo() {
		return "view/loginInfo";
	}
	
	@RequestMapping("/shopList.do")
	public String shopList() {
		return "view/shopList";
	}
	
	@RequestMapping("/loginUser.do")
	public String loginUser() {
		return "view/loginUser";
	}
	
	@RequestMapping("/loginCode.do")
	public String loginCode() {
		return "view/loginCode";
	}
	
	@RequestMapping("/aptitudeInfo.do")
	public String aptitudeInfo() {
		return "view/aptitudeInfo";
	}
	
	@RequestMapping("/main.do")
	public String main() {
		return "view/main";
	}

}
