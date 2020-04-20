package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.Sysdictionary;
import com.example.demo.pojo.SysdictionaryItem;
import com.example.demo.vo.ShuJuZiDianNeiRongVo;

public interface ShuJuZiDianService {
	/**
	 * 查询数据字典类型表
	 * @return
	 */
	List<Sysdictionary> queryAll();
	/**
	 * 根据数据字典类型表id查询所有数据字典内容
	 * @return
	 */
	List<SysdictionaryItem> sysdictionarysItemAll(String id);
	/**
	 * 批量删除
	 * @param ids
	 */
	void batchDeletUser(int[] ids) throws Exception;
	/**
	 * 根据内容表id查询所有数据字典内容
	 * @return
	 */
	SysdictionaryItem queryShuJuZiDianById(String id);
	/**
	 * 修改数据字典内容表
	 * @param shuJuZiDianNeiRongVo
	 */
	void updateshujuzidian(ShuJuZiDianNeiRongVo shuJuZiDianNeiRongVo) throws Exception;
	/**
	 * 根据页面删除字典
	 * @param id
	 */
	void deletShuJuZiDianById(String id);
	/**
	 * 添加数据字典
	 * @param sysdictionaryItem
	 */
	void addShuJu(SysdictionaryItem sysdictionaryItem) throws Exception;

}
