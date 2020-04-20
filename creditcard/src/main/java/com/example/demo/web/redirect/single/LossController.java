package com.example.demo.web.redirect.single;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LossController {
	
	@RequestMapping("/cardListForLoss.do")
	public String cardListForLoss() {
		return "single/loss/cardListForLoss";
	}
	
	@RequestMapping("/creditLoss.do")
	public String creditLoss() {
		return "single/loss/creditLoss";
	}	
	
	

}
