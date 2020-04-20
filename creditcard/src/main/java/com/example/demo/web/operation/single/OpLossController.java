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
public class OpLossController {
	
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
	@RequestMapping("/userCardListToLoss.do")
	public String userCardListToLoss(String realname,String idcartnumber,String cardnumber,Model model) {
		List<UserInfoVO> list = singleUserDealService.queryUserDetailInfoBy(realname, idcartnumber, cardnumber);
		model.addAttribute("userList", list);
		model.addAttribute("realname", realname);
		model.addAttribute("idcartnumber", idcartnumber);
		model.addAttribute("cardnumber", cardnumber);
		return "single/loss/cardListForLoss";
	}
	
	/**
	 * 通过用户id查询信用卡信息
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/creditCardLoss.do")
	public String creditCardLoss(String id ,Model model) {
		List<CreditCard> list = creditCardService.queryCreditCardByCondition(id);
		CreditCard creditCard = (list == null || list.size() == 0 ) ? null: list.get(0);
		model.addAttribute("creditCard", creditCard);
		return "single/loss/creditCardLoss";
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
	@RequestMapping("/confirmLoss.do")
	public String confirmLoss(String paypassword ,String code,String phonecode,String phone,String id,Model model) {
		List<CreditCard> list = creditCardService.queryCreditCardByCondition(id);
		CreditCard creditCard = (list == null || list.size() == 0 ) ? null: list.get(0);
		model.addAttribute("creditCard", creditCard);
		if(phone == null || phone == "") {
			model.addAttribute("message", "手机号码不能为空");
			return "single/loss/creditCardLoss";
		}
		if(phonecode == null || phonecode == "") {
			model.addAttribute("message", "未输入验证码");
			return "single/loss/creditCardLoss";
		}
		if(creditCard.getPayPassword().equals(paypassword)) {
			//短信验证
			if(code.equals(phonecode)) {
				creditCard.setState(2);
				int flag = creditCardService.updateCreditCartByCondition(creditCard);
				if(flag > 0) {
					model.addAttribute("message", "挂失成功，信用卡以被冻结");
					return "single/success";
				}
			}
			model.addAttribute("message", "验证码输入错误");
			return "single/loss/creditCardLoss";
		}
		model.addAttribute("message", "密码输入错误");
		return "single/loss/creditCardLoss";	

	}

}
