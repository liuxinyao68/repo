package com.example.demo.web.operation.single;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.pojo.CreditCard;
import com.example.demo.service.CreditCardService;
import com.example.demo.service.SingleUserDealService;
import com.example.demo.util.CartRandomUtil;
import com.example.demo.vo.UserInfoVO;

@Controller
public class OpReapplyController {
	
	@Autowired
	private SingleUserDealService singleUserDealService;
	
	@Autowired
	private CreditCardService creditCardService;
	
	/**
	 * 查询用户信息
	 * @param realname 
	 * @param idcartnumber
	 * @param cardnumber
	 * @param model
	 * @return
	 */
	@RequestMapping("/userCardListToReapply.do")
	public String userCardListToReapply(String realname,String idcartnumber,String cardnumber,Model model) {
		List<UserInfoVO> list = singleUserDealService.queryUserDetailInfoBy(realname, idcartnumber, cardnumber);
		model.addAttribute("userList", list);
		model.addAttribute("realname", realname);
		model.addAttribute("idcartnumber", idcartnumber);
		model.addAttribute("cardnumber", cardnumber);
		return "single/reapply/CardListForreapply";
	}
	
	/**
	 * 通过信用卡id查询信用卡
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/creditCardReapply.do")
	public String creditCardReapply(String id ,Model model) {
		List<CreditCard> list = creditCardService.queryCreditCardByCondition(id);
		CreditCard creditCard = (list == null || list.size() == 0 ) ? null: list.get(0);
		model.addAttribute("creditCard", creditCard);

		return "single/reapply/creditCartReapply";
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
	@RequestMapping("/confirmReapply.do")
	public String confirmReapply(String id,String paypassword,String phone,String code,String phonecode,Model model) {
		List<CreditCard> list = creditCardService.queryCreditCardByCondition(id);
		CreditCard creditCard = (list == null || list.size() == 0 ) ? null: list.get(0);
		String oldCard = creditCard.getCardNumber();
		model.addAttribute("creditCard", creditCard);
		if(phone == null || phone == "") {
			model.addAttribute("message", "手机号码不能为空");
			return "single/reapply/creditCartReapply";
		}
		if(phonecode == null || phonecode == "") {
			model.addAttribute("message", "未输入验证码");
			return "single/reapply/creditCartReapply";
		}
		if(creditCard.getPayPassword().equals(paypassword)) {
			Date time= new Date(); 
			creditCard.setIfDelete(1);
			creditCard.setUpdateTime(time);
			if(creditCardService.updateCreditCartByCondition(creditCard)>0) {
				String newCard = CartRandomUtil.getCart();
				creditCard.setCardNumber(newCard);
				creditCard.setUpdateTime(time);
				creditCard.setCreateTime(time);
				creditCard.setReplaceCardNumber(oldCard);
				if(creditCardService.insertCreditCardByCondition(creditCard)>0) {
					model.addAttribute("message", "你的卡号为" + oldCard + "的信用卡已经被注销" + "信用卡补办成功！你的新的信用卡的卡号为：" + newCard);
					return "single/success";	
				}
			}
			model.addAttribute("message", "信用卡补办失败" );
			return "single/reapply/creditCartReapply";
		}
		//添加短信验证
		if(code.equals(phonecode)) {
			//验证码正确
		}else {
			model.addAttribute("message", "验证码输入错误");
			return "single/reapply/creditCartReapply";
		}
		model.addAttribute("message", "支付密码错误" );
		return "single/reapply/creditCartReapply";
	}

}
