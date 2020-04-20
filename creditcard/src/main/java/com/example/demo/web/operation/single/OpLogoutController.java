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
public class OpLogoutController {
	
	@Autowired
	private SingleUserDealService singleUserDealService;

	@Autowired
	private CreditCardService creditCardService;
	
	/**
	 * 查询用户信用卡的分期信息情况
	 * @param realname  用户名
	 * @param idcartnumber  身份证号
	 * @param cardnumber  信用卡号
	 * @param model
	 * @return
	 */
	@RequestMapping("/userCardListTologout.do")
	public String userCardListTologout(String realname,String idcartnumber,String cardnumber,Model model) {
		List<UserInfoVO> list = singleUserDealService.queryUserDetailInfoBy(realname, idcartnumber, cardnumber);
		model.addAttribute("userList", list);
		model.addAttribute("realname", realname);
		model.addAttribute("idcartnumber", idcartnumber);
		model.addAttribute("cardnumber", cardnumber);
		return "single/logout/cardListForlogout";
	}
	
	/**
	 * 通过信用卡id查询信用卡信息
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/creditCardlogout.do")
	public String creditCardlogout(String id ,Model model) {
		List<CreditCard> list = creditCardService.queryCreditCardByCondition(id);
		CreditCard creditCard = (list == null || list.size() == 0 ) ? null: list.get(0);
		model.addAttribute("creditCard", creditCard);
		return "single/logout/creditCardlogout";
	}
	
	/**
	 * 确认注销信用卡
	 * @param paypassword
	 * @param code
	 * @param phonecode
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/confirmlogout.do")
	public String confirmlogout(String paypassword ,String code,String phone,String phonecode,String id,Model model) {
		List<CreditCard> list = creditCardService.queryCreditCardByCondition(id);
		CreditCard creditCard = (list == null || list.size() == 0 ) ? null: list.get(0);
		model.addAttribute("creditCard", creditCard);
		if(phone == null || phone == "") {
			model.addAttribute("message", "手机号码不能为空");
			return "single/logout/creditCardlogout";
		}
		if(phonecode == null || phonecode == "") {
			model.addAttribute("message", "未输入验证码");
			return "single/logout/creditCardlogout";
		}
		if(creditCard.getPayPassword().equals(paypassword)) {
			//短信验证
			if(code.equals(phonecode)) {
				creditCard.setIfDelete(1);
				int flag = creditCardService.updateCreditCartByCondition(creditCard);
				if(flag > 0) {
					model.addAttribute("message", "信用卡注销成功");
					return "single/success";
				}
			}
			model.addAttribute("message", "验证码输入错误");
			return "single/logout/creditCardlogout";
		}
		model.addAttribute("message", "密码输入错误");
		return "single/logout/creditCardlogout";	

	}

}
