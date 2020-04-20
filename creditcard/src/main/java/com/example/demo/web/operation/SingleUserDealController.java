package com.example.demo.web.operation;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.pojo.CreditCard;
import com.example.demo.pojo.UserInfo;
import com.example.demo.service.CreditCardService;
import com.example.demo.service.SingleUserDealService;
import com.example.demo.service.UserInfoService;
import com.example.demo.util.SMSSendUtil;
import com.example.demo.vo.UserInfoVO;

@Controller
public class SingleUserDealController {

	@Autowired
	private SingleUserDealService singleUserDealService;
	
	@Autowired
	private CreditCardService creditCardService;
	
	@Autowired
	private UserInfoService userInfoService;
	
	/**
	 * 查询单个用户信息三表联查用户表，信用卡表，分期情况表
	 * @param realname  
	 * @param idcartnumber
	 * @param cardnumber
	 * @param model
	 * @return
	 */
	@RequestMapping("/userDetailInfo.do")
	public String userDetailInfo(String realname,String idcartnumber,String cardnumber,Model model) {
		UserInfoVO userInfoVO = singleUserDealService.queryUserDetailInfo(realname,idcartnumber,cardnumber);
		if(userInfoVO != null) {
			// 该用户存在
			model.addAttribute("userInfoVO" , userInfoVO);
			model.addAttribute("realname" , realname);
			model.addAttribute("idcartnumber" , idcartnumber);
			model.addAttribute("cardnumber" , cardnumber);
		}else {
			// 该用户不存在或者该用户并未在本行办理信用卡
			model.addAttribute("message" , "该用户不存在或者该用户并未在本行办理信用卡");
			model.addAttribute("realname" , realname);
			model.addAttribute("idcartnumber" , idcartnumber);
			model.addAttribute("cardnumber" , cardnumber);
		}
		return "single/userinfo";
	}
	
	/**
	 * 验证用户手机号是否为默认手机号，再创建随机手机验证码，并发给该手机号
	 * @param info  其中必须包含信用卡id和用户手机号
	 * @return  返回验证码或者false
	 */
	@RequestMapping("/getPhoneCode.do")
	@ResponseBody
	public String getPhoneCode(@RequestParam Map<String,Object> info) {

		String cardId = (String)info.get("id");
		String phone = (String)info.get("phone");
		
		List<CreditCard> list = creditCardService.queryCreditCardByCondition(cardId);
		CreditCard creditCard = (list == null || list.size() == 0 ) ? null: list.get(0);
		UserInfo userInfo = userInfoService.queryUserInfoById(creditCard.getUserId());

		if(userInfo.getPhone().equals(phone)) {
			String code = SMSSendUtil.getPhoneCode(phone);
			return code;
		}
		return "false";
	}
	
	
	
}
