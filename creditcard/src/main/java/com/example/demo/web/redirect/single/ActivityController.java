package com.example.demo.web.redirect.single;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActivityController {
	
	@RequestMapping("/cardListActivity.do")
	public String cardListForLoss() {
		return "single/activity/cardListForActivity";
	}
	
	@RequestMapping("/creditActivity.do")
	public String creditLoss() {
		return "single/activity/creditActivity";
	}	
	
	

}
