package com.example.demo.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Page;
import com.example.demo.pojo.UserInfo;
import com.example.demo.service.BatchService;
@RestController
public class queryTableByPageController {
	
	@Autowired
	private BatchService batchService;
	
	/**
	 * 分页查询黑名单用户
	 * @param page  当前页currectPage,页容量sizePage,显示多少页
	 * @return
	 */
	@RequestMapping("/queryBlackInfoListByPage.do")
	public List<UserInfo> queryBlackInfoListByPage(Page<UserInfo> page) {
		page = batchService.dealPage(page,1);
		if(page.getCurrectPage() > page.getTotalPage()) {
			System.out.println("页码超出最大页数");
		}
		List<UserInfo> list = batchService.queryBlackListPage(page);
		return list;
	}
	
	/**
	 * 分页查询所有用户信息
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("/queryAllUserDeatilListByPage.do")
	public List<UserInfo> queryAllUserDeatilListByPage(Page<UserInfo> page) {
		page = batchService.dealPage(page,null);
		System.out.println(page);
		if(page.getCurrectPage() > page.getTotalPage()) {
			System.out.println("页码超出最大页数");
		}
		List<UserInfo> list = batchService.queryAllUserInfoByPage(page);
		return list;
	}

}
