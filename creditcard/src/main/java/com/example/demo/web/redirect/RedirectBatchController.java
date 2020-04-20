package com.example.demo.web.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectBatchController {
	
	
	@RequestMapping("/blacklist.do")
	public String blacklist() {
		return "batch/blacklist";
	}
	
	@RequestMapping("/sendmessage.do")
	public String sendmessage() {
		return "batch/sendmessage";
	}
	
	@RequestMapping("/overdueUser.do")
	public String overdueUser() {
		return "batch/overdueUser";
	}
	
	@RequestMapping("/stageUser.do")
	public String stageUser() {
		return "batch/stageUser";
	}

}
