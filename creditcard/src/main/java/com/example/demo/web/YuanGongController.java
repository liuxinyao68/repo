package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.pojo.LoginInfo;
import com.example.demo.service.YuanGongService;
import com.example.demo.vo.LoginInfoVo;
import com.example.demo.vo.ResultVo;
import com.example.demo.vo.YuanGongVo;
import com.github.pagehelper.PageInfo;
/**
 * 管理员Controller
 * @author Administrator
 *
 */
@Controller
public class YuanGongController {
	@Autowired
	private YuanGongService yuanGongService;
	/**
	 * 查询所有员工
	 * @param model
	 * @param yuanGongVo 查询所得的用户信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("yuanGong")
	public String yuanGong(Model model,YuanGongVo yuanGongVo) throws Exception {
		
		PageInfo<LoginInfo> loginInfo = yuanGongService.queryByUserInfo(yuanGongVo);
		List<LoginInfo>  lists = loginInfo.getList();
		model.addAttribute("pageInfo", loginInfo);
		model.addAttribute("userInfo", lists);
		return "userList";
	} 
	/**
	 * 批量删除
	 * @param ids[] 要删除的用户id
	 * @return
	 */
	@RequestMapping("batchDeletUser")
	@ResponseBody
	public ResultVo batchDeletUser(int[] ids)throws Exception {
		try {
			yuanGongService.batchDeletUser(ids);
			return new ResultVo();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultVo(false, e.getMessage());
		}
	}
	/**
	 * 根据id查询员工信息并跳转到修改页面
	 * @param id 要修改的用户id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("queryGoodById")
	public String queryGoodById(int id,Model model) throws Exception {
		LoginInfo loginInfo = yuanGongService.queryGoodById(id);
		model.addAttribute("loginInfo", loginInfo);
		return "update";
	}
	/**
	 * 修改用户信息
	 * @param loginIfVo 用户要修改的信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("updateLoginInfUser")
	@ResponseBody
	public ResultVo updateLoginInfUser(LoginInfoVo loginIfVo)throws Exception {
		try {
			yuanGongService.updateLoginInf(loginIfVo);
			return new ResultVo();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultVo(false, e.getMessage());
		}
		
	} 
	
	/**
	 * 根据id删除员工信息
	 * @param id 要删除的员工id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("deletLogin")
	public String deletLogin(int id)throws Exception {
		yuanGongService.deletLogin(id);
		return "redirect:deletLoginInfo";
	}
	/**
	 * 删除页面跳转
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("deletLoginInfo")
	public String deletLoginInfo()throws Exception {
		return "redirect:yuanGong";
	}
	/**
	 * 添加页面跳转
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addLogin")
	public String addLogin()throws Exception {
		return "addLoginInfo";
	}
	/**
	 * 添加员工 
	 * @param loginInfo 要添加的员工信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addLoginIn")
	@ResponseBody
	public ResultVo addLoginInfo(LoginInfo loginInfo)throws Exception {
		ResultVo rs = new ResultVo();
		try { 
			yuanGongService.addLoginInfo(loginInfo);
			rs.setSuccess(true);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			
			return new ResultVo(false, e.getMessage());
		}
	}
	
}
