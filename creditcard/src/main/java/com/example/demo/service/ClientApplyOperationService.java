package com.example.demo.service;

public interface ClientApplyOperationService {

	/**
	 * 信用卡处理操作
	 * @param applyid
	 * @param b
	 * @return
	 */
	boolean handleCardRequest(Long[] applyid, boolean b);

}
