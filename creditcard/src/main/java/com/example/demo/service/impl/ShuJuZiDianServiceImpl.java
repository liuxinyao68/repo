package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.ShuJuZiDianMapper;
import com.example.demo.pojo.Sysdictionary;
import com.example.demo.pojo.SysdictionaryItem;
import com.example.demo.service.ShuJuZiDianService;
import com.example.demo.util.DateZhuanHuanUtil;
import com.example.demo.vo.ShuJuZiDianNeiRongVo;
@Service
public class ShuJuZiDianServiceImpl implements ShuJuZiDianService {
	@Autowired
	private ShuJuZiDianMapper shuJuZiDianMapper;
	/**
	 * 查询数据字典类型表
	 */
	@Override
	public List<Sysdictionary> queryAll() {
		return shuJuZiDianMapper.queryAll();
	}
	/**
	 * 查询所有数据字典内容
	 * @return
	 */
	@Override
	public List<SysdictionaryItem> sysdictionarysItemAll(String id) {
		return shuJuZiDianMapper.sysdictionarysItemAll(id);
	}
	/**
	 * 批量删除
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void batchDeletUser(int[] ids) throws Exception {
		try {
			shuJuZiDianMapper.batchDeletUserById(ids);
			return;
		} catch (RuntimeException e) {
			throw new RuntimeException("删除失败!!");
		}
		
	}
	/**
	 * 根据内容表id查询所有数据字典内容
	 * @return
	 */
	@Override
	public SysdictionaryItem queryShuJuZiDianById(String id) {
		return shuJuZiDianMapper.queryShuJuZiDianById(id);
	}
	/**
	 *修改 数据字典内容表
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateshujuzidian(ShuJuZiDianNeiRongVo shuJuZiDianNeiRongVo) throws Exception {
		try {
			shuJuZiDianNeiRongVo.setUpdatetime(DateZhuanHuanUtil.convertDate(new Date()));
			shuJuZiDianMapper.updateshujuzidian(shuJuZiDianNeiRongVo);
		} catch (RuntimeException e) {
			throw new RuntimeException("修改失败!!");
		}
	}
	/**
	 * 根据id删除字典信息
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deletShuJuZiDianById(String id) {
		
		try {
			shuJuZiDianMapper.deletShuJuZiDianById(id);
		} catch (RuntimeException e) {
			throw new RuntimeException("删除失败!!");
		}
	}
	/**
	 * 添加数据字典
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addShuJu(SysdictionaryItem sysdictionaryItem) throws Exception {
		try {
			java.sql.Date date = DateZhuanHuanUtil.convertDate(new Date());
			sysdictionaryItem.setCreatetime(date);
			sysdictionaryItem.setUpdatetime(date);
			shuJuZiDianMapper.addShuJu(sysdictionaryItem);
			return;
		} catch (RuntimeException e) {
			throw new RuntimeException("添加失败!!");
		}
		
	}

}
