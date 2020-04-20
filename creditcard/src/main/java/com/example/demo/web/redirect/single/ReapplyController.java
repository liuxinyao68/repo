package com.example.demo.web.redirect.single;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReapplyController {

	@RequestMapping("/cardListForreapply.do")
	public String cardListForreapply() {
		return "single/reapply/cardListForreapply";
	}
	
	@RequestMapping("/creditreapply.do")
	public String creditreapply() {
		return "single/reapply/creditreapply";
	}
	
}
