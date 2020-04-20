package com.example.demo.web.redirect.single;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	
	
	@RequestMapping("/cardListForlogout.do")
	public String cardListForlogout() {
		return "single/logout/cardListForlogout";
	}
	
	

}
