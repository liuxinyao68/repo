package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.pojo.Sysdictionary;
import com.example.demo.pojo.SysdictionaryItem;
import com.example.demo.vo.ShuJuZiDianNeiRongVo;
@Mapper
public interface ShuJuZiDianMapper {
	/**
	 * 查询数据字典类型表
	 * @return
	 */
	List<Sysdictionary> queryAll();
	/**
	 * 查询所有数据字典内容
	 * @param id
	 * @return
	 */
	List<SysdictionaryItem> sysdictionarysItemAll(String id);
	/**
	 * 批量删除
	 * @param ids
	 * @throws Exception
	 */
	void batchDeletUserById(int[] ids) throws Exception;
	/**
	 * 根据内容表id查询所有数据字典内容
	 * @return
	 */
	SysdictionaryItem queryShuJuZiDianById(String id);
	/**
	 * 修改数据字典内容表
	 * @param shuJuZiDianNeiRongVo
	 * @throws Exception
	 */
	void updateshujuzidian(ShuJuZiDianNeiRongVo shuJuZiDianNeiRongVo) throws Exception;
	/**
	 * 根据id删除字典信息
	 * @param id
	 */
	void deletShuJuZiDianById(String id);
	/**
	 * 添加数据字典
	 * @param sysdictionaryItem
	 */
	void addShuJu(SysdictionaryItem sysdictionaryItem)throws Exception;

}
