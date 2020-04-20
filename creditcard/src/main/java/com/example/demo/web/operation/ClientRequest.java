package com.example.demo.web.operation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.pojo.CartApplication;
import com.example.demo.service.ClientApplyOperationService;
import com.example.demo.service.HtmlVOService;

@Controller
public class ClientRequest {
	
	@Autowired
	private HtmlVOService htmlVOService;
	
	@Autowired
	private ClientApplyOperationService clientApplyOperationService;
	
	/**
	 * 查询信用卡申请列表
	 * @return
	 */
	@RequestMapping("/cartapplicationlist.do")
	public String queryCartApplicationList() {
		List<CartApplication> list = htmlVOService.queryCartApplication();
		System.out.println(list.size());
		return "redirect:/applycart.do";
	}
	
	/**
	 * 同意驳回该办理请求id的办卡请求
	 * @param applyid
	 * @return
	 */
	@RequestMapping("/agreementApply.do")
	public String aggrementApply(Long[] applyid) {
		clientApplyOperationService.handleCardRequest(applyid,true);
		return "redirect:/cartapplicationlist.do";
	}
	
	
	/**
	 * 驳回该办理请求id的办卡请求
	 * @param applyid
	 * @return
	 */
	@RequestMapping("/rejectApply.do")
	public String rejectApplyApply(Long[] applyid) {
		clientApplyOperationService.handleCardRequest(applyid,false);
		return "redirect:/cartapplicationlist.do";
	}
	

}
