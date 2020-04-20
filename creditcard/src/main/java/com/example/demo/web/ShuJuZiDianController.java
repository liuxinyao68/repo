package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.pojo.Sysdictionary;
import com.example.demo.pojo.SysdictionaryItem;
import com.example.demo.service.ShuJuZiDianService;
import com.example.demo.vo.ResultVo;
import com.example.demo.vo.ShuJuZiDianNeiRongVo;

/**
 * 数据字典 Controller
 * 
 * @author Administrator
 *
 */
@Controller
public class ShuJuZiDianController {
	@Autowired
	private ShuJuZiDianService shuJuZiDianService;

	/**
	 * 查询数据字典类型表中所有的类型
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("shuJuXiang")
	public String shuJuXiang(Model model) throws Exception {
		List<Sysdictionary> listSysdictionaries = shuJuZiDianService.queryAll();
		model.addAttribute("listSysdictionaries", listSysdictionaries);
		return "index";
	}

	/**
	 * 根据数据字典类型id查询所有数据字典内容
	 * 
	 * @param id    数据字典类型id
	 * @param name  数据字典类型名称
	 * @param model
	 * @return
	 */
	@RequestMapping("sysdictionarys")
	public String sysdictionarys(String id, String name, Model model) {
		List<SysdictionaryItem> sysdictionaryItems = shuJuZiDianService.sysdictionarysItemAll(id);
		model.addAttribute("name", name);
		model.addAttribute("sysdictionaryItems", sysdictionaryItems);
		return "shuJuZiDian";
	}

	/**
	 * 批量删除
	 * 
	 * @param ids 被删除的id数组
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("batchDeletSysdictionaryItem")
	@ResponseBody
	public ResultVo batchDeletSysdictionaryItem(int[] ids) throws Exception {
		try {
			shuJuZiDianService.batchDeletUser(ids);
			return new ResultVo();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultVo(false, e.getMessage());
		}
	}

	/**
	 * 根据id查询数据字典信息并跳转到修改页面
	 * 
	 * @param id    要修改的id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("queryShuJuZiDianById")
	public String queryShuJuZiDianById(String id, Model model) throws Exception {
		SysdictionaryItem sysdiction = shuJuZiDianService.queryShuJuZiDianById(id);
		model.addAttribute("sysdiction", sysdiction);
		return "updateshujuzidian";
	}

	/**
	 * 修改数据字典信息
	 * 
	 * @param shuJuZiDianNeiRongVo 要修改的信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("updateshujuzidian")
	@ResponseBody
	public ResultVo updateshujuzidian(ShuJuZiDianNeiRongVo shuJuZiDianNeiRongVo) throws Exception {
		try {
			shuJuZiDianService.updateshujuzidian(shuJuZiDianNeiRongVo);
			return new ResultVo();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultVo(false, e.getMessage());
		}
	}

	/**
	 * 根据id删除字典信息
	 * 
	 * @param id 要删除的id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("deletShuJuZiDianById")
	public String deletShuJuZiDianById(String id) throws Exception {
		shuJuZiDianService.deletShuJuZiDianById(id);
		return "redirect:deletLoginInfo";
	}

	/**
	 * 删除页面跳转
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("deletShuJuZiDian")
	public String deletShuJuZiDian() throws Exception {
		return "redirect:yuanGong";
	}

	/**
	 * 添加页面跳转
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addSysdictionaryItem")
	public String addLogin() throws Exception {
		return "addShuJuZiDian";
	}

	/**
	 * 添加数据字典 
	 * 
	 * @param sysdictionaryItem 要添加的信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addShuJu")
	@ResponseBody
	public ResultVo addShuJu(SysdictionaryItem sysdictionaryItem) throws Exception {
		try {
			shuJuZiDianService.addShuJu(sysdictionaryItem);
			return new ResultVo();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultVo(false, e.getMessage());
		}
	}

}
