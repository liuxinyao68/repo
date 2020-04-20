package com.example.demo.web.redirect.single;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChangePwdController {

	@RequestMapping("/cardListForChangePwd.do")
	public String changePassword() {
		return "single/changepassword/cardListForChangePwd";
	}
	
	
}
