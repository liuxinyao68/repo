package com.example.demo.web.redirect.single;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdjustAmountController {

	@RequestMapping("/adjustamount.do")
	public String adjustamount() {
		return "single/adjust/adjustamount";
	}

	@RequestMapping("/cardListForadjustamount.do")
	public String cardListForadjustamount() {
		return "single/adjust/cardListForadjustamount";
	}
	
}
