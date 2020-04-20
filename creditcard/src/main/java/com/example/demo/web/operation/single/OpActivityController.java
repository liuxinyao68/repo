package com.example.demo.web.operation.single;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.pojo.CreditCard;
import com.example.demo.service.CreditCardService;
import com.example.demo.service.SingleUserDealService;
import com.example.demo.vo.UserInfoVO;

@Controller
public class OpActivityController {
	
	@Autowired
	private SingleUserDealService singleUserDealService;
	
	@Autowired
	private CreditCardService creditCardService;
	
	/**
	 * 查询用户基本信息
	 * @param realname  用户姓名
	 * @param idcartnumber   用户身份证号码
	 * @param cardnumber  信用卡号
	 * @param model
	 * @return
	 */
	@RequestMapping("/userCardListToActivity.do")
	public String userCardListToActivity(String realname,String idcartnumber,String cardnumber,Model model) {
		List<UserInfoVO> list = singleUserDealService.queryUserDetailInfoBy(realname, idcartnumber, cardnumber);
		model.addAttribute("userList", list);
		model.addAttribute("realname", realname);
		model.addAttribute("idcartnumber", idcartnumber);
		model.addAttribute("cardnumber", cardnumber);
		return "single/activity/cardListForActivity";
	}
	
	/**
	 * 通过用户id查询信用卡信息
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/creditCardActivity.do")
	public String creditCardActivity(String id ,Model model) {
		List<CreditCard> list = creditCardService.queryCreditCardByCondition(id);
		CreditCard creditCard = (list == null || list.size() == 0 ) ? null: list.get(0);
		model.addAttribute("creditCard", creditCard);
		return "single/activity/creditCardActivity";
	}
	
	/**
	 * 确定激活信用卡
	 * @param paypassword
	 * @param code
	 * @param phonecode
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/confirmActivity.do")
	public String confirmActivity(String paypassword ,String phone,String code,String phonecode,String id,Model model) {
		List<CreditCard> list = creditCardService.queryCreditCardByCondition(id);
		CreditCard creditCard = (list == null || list.size() == 0 ) ? null: list.get(0);
		model.addAttribute("creditCard", creditCard);
		if(phone == null || phone == "") {
			model.addAttribute("message", "手机号码不能为空");
			return "single/activity/creditCardActivity";
		}
		if(phonecode == null || phonecode == "") {
			model.addAttribute("message", "未输入验证码");
			return "single/activity/creditCardActivity";
		}
		if(creditCard.getState() == 1) {
			model.addAttribute("message", "该信用卡以被激活");
			return "single/activity/creditCardActivity";
		}
		if(creditCard.getPayPassword().equals(paypassword)) {
			//短信验证
			if(code.equals(phonecode)) {
				creditCard.setState(1);
				if(creditCardService.updateCreditCartByCondition(creditCard)>0) {
					model.addAttribute("message", "信用卡激活成功");
					return "single/success";
				}
				model.addAttribute("message", "信用卡激活失败");
				return "single/activity/creditCardActivity";
			}
			model.addAttribute("message", "验证码输入错误");
			return "single/activity/creditCardActivity";
		}
		model.addAttribute("message", "密码输入错误");
		return "single/activity/creditCardActivity";	

	}

}
