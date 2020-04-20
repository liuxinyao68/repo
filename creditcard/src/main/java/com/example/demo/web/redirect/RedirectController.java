package com.example.demo.web.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	
	
	@RequestMapping("/index.do")
	public String index() {
		return "index";
	}


}
