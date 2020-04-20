package com.example.demo.web.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.CartApplication;
import com.example.demo.pojo.CreditCard;
import com.example.demo.pojo.OverFlows;
import com.example.demo.pojo.StageUserInfoVO;
import com.example.demo.service.BatchService;
import com.example.demo.service.CreditCardService;
import com.example.demo.service.HtmlVOService;
import com.example.demo.service.SingleUserDealService;
import com.example.demo.vo.ResultVo;
import com.example.demo.vo.UserInfoVO;

@RestController
public class queryTableController {
	
	@Autowired
	private CreditCardService creditCardService;
	
	@Autowired
	private SingleUserDealService singleUserDealService;	
	
	@Autowired
	private HtmlVOService htmlVOService;
	
	@Autowired
	private BatchService batchService;
		
	/**
	 * 通过用户id查询用户信用卡号集合
	 * @param uid
	 * @return
	 */
	@RequestMapping("/queryCardNumberListByUserId.do")
	public List<String> queryCardNumberByUserId(String userId){
		List<String> list = creditCardService.queryCreditByUid(userId);
		return list;
	 }
	
	/**
	 * 通过信用卡id查询信用卡信息
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/queryCreditCardInfoById.do")
	public CreditCard queryCreditCardInfoById(String id) {
		List<CreditCard> list = creditCardService.queryCreditCardByCondition(id);
		CreditCard creditCard = (list == null || list.size() == 0 ) ? null: list.get(0);
		return creditCard;
	}
	
	/**
	 * 查询用户信用卡的分期信息情况
	 * @param realname  用户名
	 * @param idcartnumber  身份证号
	 * @param cardnumber  信用卡号
	 * @param model
	 * @return
	 */
	@RequestMapping("/queryUserStageInfoByOne.do")
	public List<UserInfoVO> queryUserStageInfoByOne(String realname,String idcartnumber,String cardnumber) {
		List<UserInfoVO> list = singleUserDealService.queryUserDetailInfoBy(realname, idcartnumber, cardnumber);
		return list;
	}
	
	/**
	 * 查询用户详细信息
	 * @param realname
	 * @param idcartnumber
	 * @param cardnumber
	 * @return
	 */
	@RequestMapping("/queryUserInfoDetailInfo.do")
	public UserInfoVO queryUserInfoDetailInfo(String realname,String idcartnumber,String cardnumber) {
		UserInfoVO userInfoVO = singleUserDealService.queryUserDetailInfo(realname,idcartnumber,cardnumber);
		if(userInfoVO != null) {
			// 该用户存在
			return userInfoVO;
		}
		return null;
	}
	
	/**
	 * 查询信用卡申请列表
	 * @return
	 */
	@RequestMapping("/queryCreaditCardApplyList.do")
	public List<CartApplication> queryCreaditCardApplyList() {
		List<CartApplication> list = htmlVOService.queryCartApplication();
		return list;
	}
	
	/**
	 * 查询所有分期用户
	 * @param model
	 * @return
	 */
	@RequestMapping("/queryAllStageUserList.do")
	public List<StageUserInfoVO> queryAllStageUserList() {
		List<StageUserInfoVO> list = htmlVOService.queryStageUserInfoVOByCondition();
		return list;
	}
	
	/**
	 * 查询所有逾期用户
	 * @return
	 */
	@RequestMapping("/queryAllOverFlowsUserList.do")
	public List<OverFlows> queryOverFlows() {
		List<OverFlows> overFlows = htmlVOService.queryAOverFlowsByCondition();
		return overFlows;
	}
	
	/**
	 * 批量发送短信
	 * @param userid
	 * @param send
	 * @return
	 */
	@RequestMapping("/SendMessageList.do")
	public ResultVo opBlackList(String[] userid,String send) {
		//短信内容
		batchService.sendShortMessage(userid,send);
		ResultVo rs = new ResultVo();
		rs.setSuccess(true);
		return rs;
	}
	


}
