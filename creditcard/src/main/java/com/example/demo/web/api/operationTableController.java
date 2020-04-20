package com.example.demo.web.api;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.CreditCard;
import com.example.demo.pojo.UserInfo;
import com.example.demo.service.ClientApplyOperationService;
import com.example.demo.service.CreditCardService;
import com.example.demo.service.LoginInfoService;
import com.example.demo.service.UserInfoService;
import com.example.demo.util.CartRandomUtil;
import com.example.demo.util.SMSSendUtil;
import com.example.demo.vo.LoginVO;
import com.example.demo.vo.ResultVo;
import com.example.demo.vo.BackResultVO;


@RestController
public class operationTableController {
	
	@Autowired
	private CreditCardService creditCardService;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private ClientApplyOperationService clientApplyOperationService;
	
	@Autowired
	private LoginInfoService loginInfoService;
	
	
	/**
	 * 管理员用户登入接口
	 * @param loginVO
	 * @return
	 */
	@RequestMapping("/loginOfAdmin.do")
	public BackResultVO loginOfAdmin(LoginVO loginVO) {
		Long id = loginVO.getId();
		String password = loginVO.getPassword();
		Long phone = loginVO.getPhone();
		int flag = loginInfoService.loginAdmin(id, password,phone);
		BackResultVO rs = new BackResultVO();
		switch(flag) {
			case 0:
				rs.setSuccess(true);
				break;
			case -1:
				rs.setSuccess(false);
				rs.setMsg("该账号未被注册");
				break;
			case 1:
				rs.setSuccess(false);
				rs.setMsg("该账号以被冻结");
				break;
			case 2:
				rs.setSuccess(false);
				rs.setMsg("你不是管理员无法注册");
				break;
			default:
				break;
		}

		return rs;
	}
	

	/**
	 * 验证用户手机号是否为默认手机号，再创建随机手机验证码，并发给该手机号
	 * @param info  其中必须包含信用卡id和用户手机号
	 * @return  返回验证码或者false
	 */
	@RequestMapping("/getPhoneCodeAndSendCode.do")
	public String getPhoneCodeAndSendCode(String id,String phone) {
		String cardId = id;
		List<CreditCard> list = creditCardService.queryCreditCardByCondition(cardId);
		CreditCard creditCard = (list == null || list.size() == 0 ) ? null: list.get(0);
		if(creditCard == null) {
			return "false";
		}
		UserInfo userInfo = userInfoService.queryUserInfoById(creditCard.getUserId());
		if(userInfo.getPhone().equals(phone)) {
			String code = SMSSendUtil.getPhoneCode(phone);
			return code;
		}
		return "false";
	}
	
	/**
	 * 同意该办理请求id的办卡请求
	 * @param applyid
	 * @return
	 */
	@RequestMapping("/agreeApplyByApplyId.do")
	public BackResultVO agreeApplyByApplyId(Long[] applyid) {
		boolean flag = clientApplyOperationService.handleCardRequest(applyid,true);
		BackResultVO rs = new BackResultVO();
		if(flag) {
			rs.setSuccess(true);
	
		}else {
			rs.setSuccess(false);
			rs.setMsg("处理失败");
		}
		return rs;
	}

	/**
	 * 驳回该办理请求id的办卡请求
	 * @param applyid
	 * @return
	 */
	@RequestMapping("/disagreeApplyByApplyId.do")
	public BackResultVO disagreeApplyByApplyId(Long[] applyid) {
		boolean flag = clientApplyOperationService.handleCardRequest(applyid,false);
		BackResultVO rs = new BackResultVO();
		if(flag) {
			rs.setSuccess(true);
	
		}else {
			rs.setSuccess(false);
			rs.setMsg("处理失败");
		}
		return rs;
	}
	
	/**
	 * 注销信用卡
	 * @param paypassword
	 * @param code
	 * @param phonecode
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/logoutCreditCard.do")
	public BackResultVO logoutCreditCard(String paypassword ,String code,String phonecode,String id) {
		BackResultVO rs = new BackResultVO();
		List<CreditCard> list = creditCardService.queryCreditCardByCondition(id);
		CreditCard creditCard = (list == null || list.size() == 0 ) ? null: list.get(0);
		if(creditCard.getPayPassword().equals(paypassword)) {
			//短信验证
			if(code.equals(phonecode)) {
				System.out.println("可以注销");
				creditCard.setIfDelete(1);
				int flag = creditCardService.updateCreditCartByCondition(creditCard);
				if(flag > 0) {
					rs.setSuccess(true);
				}
			}else {
				rs.setSuccess(false);
				rs.setMsg("验证码输入错误");
			}
		}else {
			rs.setSuccess(false);
			rs.setMsg("密码输入错误");
		}
		return rs;	
	}
	
	/**
	 * 修改用户支付密码
	 * @param oldpassword  原来的密码
	 * @param newpassword  新改的密码
	 * @param confirmpassword  确认密码
	 * @param id  信用卡id
	 * @param model
	 * @return
	 */
	@RequestMapping("/updatePayPassward.do")
	public BackResultVO updatePayPassward(String oldpassword ,String newpassword,String confirmpassword,String id) {
		BackResultVO rs = new BackResultVO();
		List<CreditCard> list = creditCardService.queryCreditCardByCondition(id);
		CreditCard creditCard = (list == null || list.size() == 0 ) ? null: list.get(0);
		if(!newpassword.equals(confirmpassword)) {
			rs.setSuccess(false);
			rs.setMsg("两次密码不相同");
		}else {
			if(creditCard.getPayPassword().equals(oldpassword)) {
				creditCard.setPayPassword(newpassword);
				int flag = creditCardService.updateCreditCartByCondition(creditCard);
				if(flag > 0) {
					rs.setSuccess(true);
				}else {
					rs.setSuccess(false);
					rs.setMsg("密码修改失败");
				}
			}else {
				rs.setSuccess(false);
				rs.setMsg("密码输入错误");
			}
		}
		return rs;	
	}
	
	/**
	 * 确定挂失（冻结）信用卡
	 * @param paypassword
	 * @param code
	 * @param phonecode
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/freezeCreditCard.do")
	public BackResultVO freezeCreditCard(String paypassword ,String code,String phonecode,String id) {
		BackResultVO rs = new BackResultVO();
		List<CreditCard> list = creditCardService.queryCreditCardByCondition(id);
		CreditCard creditCard = (list == null || list.size() == 0 ) ? null: list.get(0);
		if(creditCard.getPayPassword().equals(paypassword)) {
			//短信验证
			if(code.equals(phonecode)) {
				creditCard.setState(2);
				int flag = creditCardService.updateCreditCartByCondition(creditCard);
				if(flag > 0) {
					rs.setSuccess(true);
				}else {
					rs.setSuccess(false);
					rs.setMsg("信用卡挂失失败");
				}
			}else {
				rs.setSuccess(false);
				rs.setMsg("验证码输入错误");
			}
		}else {
			rs.setSuccess(false);
			rs.setMsg("密码输入错误");
		}
		return rs;		
	}
	
	/**
	 * 确定补办信用卡
	 * @param id
	 * @param paypassword
	 * @param code
	 * @param phonecode
	 * @param model
	 * @return
	 */
	@RequestMapping("/reApplyCreditCard.do")
	public BackResultVO reApplyCreditCard(String id,String paypassword,String code,String phonecode) {
		BackResultVO rs = new BackResultVO();
		List<CreditCard> list = creditCardService.queryCreditCardByCondition(id);
		CreditCard creditCard = (list == null || list.size() == 0 ) ? null: list.get(0);
		String oldCard = creditCard.getCardNumber();
		if(creditCard.getPayPassword().equals(paypassword)) {
			Date time= new Date(); 
			creditCard.setIfDelete(1);
			creditCard.setUpdateTime(time);
			if(code.equals(phonecode)) {
				if(creditCardService.updateCreditCartByCondition(creditCard)>0) {
					System.out.println(creditCard);
					String newCard = CartRandomUtil.getCart();
					creditCard.setCardNumber(newCard);
					creditCard.setUpdateTime(time);
					creditCard.setCreateTime(time);
					creditCard.setReplaceCardNumber(oldCard);
					if(creditCardService.insertCreditCardByCondition(creditCard)>0) {
						String result = "你的卡号为" + oldCard + "的信用卡已经被注销" + "信用卡补办成功！你的新的信用卡的卡号为：" + newCard;
						rs.setSuccess(true);
						rs.setData(result);
					}else {
						rs.setSuccess(false);
						rs.setMsg("信用卡补办失败");
					}
				}else {
					rs.setSuccess(false);
					rs.setMsg("信用卡补办失败");
				}
			}else {
				rs.setSuccess(false);
				rs.setMsg("验证码输入错误");
			}
		}else {
			rs.setSuccess(false);
			rs.setMsg("支付密码错误");
		}
		return rs;
	}
	
	
	/**
	 * 移出黑名单
	 * @param userid
	 * @return
	 */
	@RequestMapping("/removeBlackList.do")
	public ResultVo removeBlackList(String[] userid) {
		ResultVo rs = new ResultVo();
		if(userid == null) {
			rs.setSuccess(false);
			rs.setMessage("用户id不能为空");
			return rs;
		}
		userInfoService.removeBlackList(userid);
		
		rs.setSuccess(true);
		return rs;
		
	}
	
	/**
	 * 移出黑名单
	 * @param userid
	 * @return
	 */
	@RequestMapping("/addToBlackList.do")
	public ResultVo addToBlackList(String[] userid) {
		ResultVo rs = new ResultVo();
		if(userid == null) {
			rs.setSuccess(false);
			rs.setMessage("用户id不能为空");
			return rs;
		}
		userInfoService.addToBlackList(userid);
		
		rs.setSuccess(true);
		return rs;
		
	}
	
	/**
	 * 通过身份证号移出或者移入黑名单
	 * @param userid
	 * @return
	 */
	@RequestMapping("/addToBlackListByIdCard.do")
	public ResultVo addToBlackListByIdCard(String[] idcard,String  op) {

		System.out.println(op);
		for(int i =0;i<idcard.length;i++) {
			System.out.println(idcard[i]);
		}
		
		ResultVo rs = new ResultVo();
		if(idcard == null || idcard.length == 0) {
			rs.setSuccess(false);
			rs.setMessage("身份证不能为空");
			return rs;
		}
		if(op == null || op == "") {
			rs.setSuccess(false);
			rs.setMessage("操作不能为空");
			return rs;
		}
		userInfoService.addToBlackListByIdCard(idcard,op);
		rs.setSuccess(true);
		return rs;
		
	}
	
	/**
	 * 通过身份证号移出或者移入黑名单
	 * @param userid
	 * @return
	 */
	@RequestMapping("/addToBlackListByUserId.do")
	public ResultVo addToBlackListByUserId(String[] userid,String  op) {

		System.out.println(op);
		for(int i =0;i<userid.length;i++) {
			System.out.println(userid[i]);
		}
		
		ResultVo rs = new ResultVo();
		if(userid == null || userid.length == 0) {
			rs.setSuccess(false);
			rs.setMessage("用户id不能为空");
			return rs;
		}
		if(op == null || op == "") {
			rs.setSuccess(false);
			rs.setMessage("操作不能为空");
			return rs;
		}
		userInfoService.addToBlackListByUserId(userid,op);
		rs.setSuccess(true);
		return rs;
		
	}
	
}
