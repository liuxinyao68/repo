package com.example.demo.web.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectClientApplyController {

	@RequestMapping("/applycart.do")
	public String applyCart() {
		return "clientapply/applycart";
	}
	
	@RequestMapping("/adjustamountapply.do")
	public String adjustamount() {
		return "clientapply/adjustamount";
	}
}
