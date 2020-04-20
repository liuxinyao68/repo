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
public class AdjustController {
	
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
	@RequestMapping("/updateAdiustAmount.do")
	public String changePassword(String id ,Model model) {
		List<CreditCard> list = creditCardService.queryCreditCardByCondition(id);
		CreditCard creditCard = (list == null || list.size() == 0 ) ? null: list.get(0);
		model.addAttribute("creditCard", creditCard);
		return "single/adjust/adjustamount";
	}
	
	/**
	 * 查詢用戶信用卡分期情況
	 * @param realname   用戶名
	 * @param idcartnumber  用戶身份證號
	 * @param cardnumber  信用卡號
	 * @param model
	 * @return
	 */
	@RequestMapping("/userCardListToAdjust.do")
	public String userCardListToAdjust(String realname,String idcartnumber,String cardnumber,Model model) {
		List<UserInfoVO> list = singleUserDealService.queryUserDetailInfoBy(realname, idcartnumber, cardnumber);
		model.addAttribute("userList", list);
		model.addAttribute("realname", realname);
		model.addAttribute("idcartnumber", idcartnumber);
		model.addAttribute("cardnumber", cardnumber);
		return "single/adjust/cardListForadjustamount";
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
	@RequestMapping("/confirmUpdateAdjust.do")
	public String confirmUpdateAdjust(Double num ,String phone,String phonecode,String code,String id,Model model) {
		List<CreditCard> list = creditCardService.queryCreditCardByCondition(id);
		CreditCard creditCard = (list == null || list.size() == 0 ) ? null: list.get(0);
		
		if(phone == null) {
			model.addAttribute("creditCard", creditCard);
			model.addAttribute("message", "手机号码不能为空");
			return "single/adjust/adjustamount";
		}
		if(phonecode == null) {
			model.addAttribute("creditCard", creditCard);
			model.addAttribute("message", "未输入验证码");
			return "single/adjust/adjustamount";
		}
		Double totalQuota = creditCard.getTotalQuota();
		Double totalQuota1 = totalQuota + num;
		creditCard.setTotalQuota(totalQuota1);
		int flag = creditCardService.updateCreditCartByCondition(creditCard);
		if(flag > 0) {
			model.addAttribute("message", "额度提升成功！你现在的额度为：" + totalQuota1);
			return "single/success";
			
		}
		creditCard.setTotalQuota(totalQuota);
		model.addAttribute("creditCard", creditCard);
		model.addAttribute("message", "密码输入错误");
		return "single/adjust/adjustamount";		
	}

}
