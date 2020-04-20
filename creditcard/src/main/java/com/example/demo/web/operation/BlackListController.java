package com.example.demo.web.operation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.pojo.Page;
import com.example.demo.pojo.UserInfo;
import com.example.demo.service.BatchService;
import com.example.demo.service.UserInfoService;

@Controller
public class BlackListController {

	@Autowired
	private BatchService batchService;
	
	@Autowired
	private UserInfoService userInfoService;

	/**
	 * 分页查询黑名单用户
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("/queryBlacklist.do")
	public String queryBlackList(Page<UserInfo> page,Model model) {
		page = batchService.dealPage(page,1);
		if(page.getCurrectPage() > page.getTotalPage()) {
			System.out.println("页码超出最大页数");
		}
		List<UserInfo> list = batchService.queryBlackListPage(page);
		model.addAttribute("lists", list);
		model.addAttribute("page", page);
		return "batch/blacklist";
	}

	@RequestMapping("/opBlackList.do")
	public String opBlackList(String[] id,int op) {
		if(1 == op) {
			//移出黑名单
			System.out.println("移出黑名单");
			userInfoService.removeBlackList(id);
		}
		if(2 == op) {
			//发送短信
			String nessage = "";
			batchService.sendShortMessage(id,nessage);
		}
		return "redirect:/queryBlacklist.do";
	}
}
