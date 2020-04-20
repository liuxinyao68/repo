package com.example.demo.web.operation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.pojo.OverFlows;
import com.example.demo.pojo.Page;
import com.example.demo.pojo.StageUserInfoVO;
import com.example.demo.pojo.UserInfo;
import com.example.demo.service.BatchService;
import com.example.demo.service.HtmlVOService;

@Controller
public class BatchController {
	
	@Autowired
	private BatchService batchService;
	
	@Autowired
	private HtmlVOService htmlVOService;
	
	
	
	/**
	 * 分页查询所有用户信息
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("/queryAllUserlist.do")
	public String queryAllUserlist(Page<UserInfo> page,Model model) {
		page = batchService.dealPage(page,null);
		if(page.getCurrectPage() > page.getTotalPage()) {
			System.out.println("页码超出最大页数");
		}
		List<UserInfo> list = batchService.queryAllUserInfoByPage(page);
		model.addAttribute("lists", list);
		model.addAttribute("page", page);
		return "batch/sendmessage";
	}
	
	/**
	 * 查询所有分期用户
	 * @param model
	 * @return
	 */
	@RequestMapping("/stageUserList.do")
	public String stageUserList(Model model) {
		List<StageUserInfoVO> list = htmlVOService.queryStageUserInfoVOByCondition();
		model.addAttribute("lists", list);
		return "batch/stageUser";
	}
	
	/**
	 * 查询所有逾期用户
	 * @param model
	 * @return
	 */
	@RequestMapping("/queryOverFlows.do")
	public String queryOverFlows(Model model) {
		List<OverFlows> list = htmlVOService.queryAOverFlowsByCondition();
		model.addAttribute("lists", list);
		return "batch/overdueUser";
	}
	
	/**
	 * 批量发送短信
	 * @param userid
	 * @param send
	 * @return
	 */
	@RequestMapping("/opSendMessage.do")
	public String opBlackList(String[] userid,String send) {
		//短信内容
		batchService.sendShortMessage(userid,send);
		return "redirect:/queryAllUserlist.do";
	}

}
