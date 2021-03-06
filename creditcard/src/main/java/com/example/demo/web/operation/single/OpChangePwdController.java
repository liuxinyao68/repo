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
public class OpChangePwdController {
	
	@Autowired
	private SingleUserDealService singleUserDealService;
	
	@Autowired
	private CreditCardService creditCardService;
	
	/**
	 * 通過信用卡id查詢信用卡信息
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/changepassword.do")
	public String changePassword(String id ,Model model) {
		List<CreditCard> list = creditCardService.queryCreditCardByCondition(id);
		CreditCard creditCard = (list == null || list.size() == 0 ) ? null: list.get(0);
		model.addAttribute("creditCard", creditCard);
		return "single/changepassword/ChangePassword";
	}
	
	/**
	 * 查詢用戶信用卡分期情況
	 * @param realname   用戶名
	 * @param idcartnumber  用戶身份證號
	 * @param cardnumber  信用卡號
	 * @param model
	 * @return
	 */
	@RequestMapping("/userCardList.do")
	public String userCardList(String realname,String idcartnumber,String cardnumber,Model model) {
		List<UserInfoVO> list = singleUserDealService.queryUserDetailInfoBy(realname, idcartnumber, cardnumber);
		model.addAttribute("userList", list);
		model.addAttribute("realname", realname);
		model.addAttribute("idcartnumber", idcartnumber);
		model.addAttribute("cardnumber", cardnumber);
		return "single/changepassword/cardListForChangePwd";
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
	@RequestMapping("/confirmchangepassword.do")
	public String confirmChangePassword(String oldpassword ,String newpassword,String confirmpassword,String id,Model model) {
		List<CreditCard> list = creditCardService.queryCreditCardByCondition(id);
		CreditCard creditCard = (list == null || list.size() == 0 ) ? null: list.get(0);
		model.addAttribute("creditCard", creditCard);
		if(oldpassword == null || oldpassword == "") {
			model.addAttribute("message", "请输入原来的支付密码");
			return "single/changepassword/ChangePassword";
		}
		if(newpassword == null || newpassword == "") {
			model.addAttribute("message", "请输入新的支付密码");
			return "single/changepassword/ChangePassword";
		}
		if(!newpassword.equals(confirmpassword)) {
			model.addAttribute("message", "两次密码不相同");
			return "single/changepassword/ChangePassword";	
		}
		if(creditCard.getPayPassword().equals(oldpassword)) {
			creditCard.setPayPassword(newpassword);
			int flag = creditCardService.updateCreditCartByCondition(creditCard);
			if(flag > 0) {
				model.addAttribute("message", "密码修改成功");
				return "single/success";
			}
		}
		model.addAttribute("message", "密码输入错误");
		return "single/changepassword/ChangePassword";	
	}

}
