package com.example.demo.web.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectSingleController {
	

	@RequestMapping("/userinfo.do")
	public String userInfo() {
		return "single/userinfo";
	}

}
