package com.example.demo.util;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



/**
 * 用户的上下文
 * @author Administrator
 *     获取HttpSession对象, 不暴露出去
 */
public class SessionUtil {
//	/**
//	 * 当前登录的logininfo在session的key
//	 */
//	private static String LOGININFO_IN_SESSION_KEY = "current";
	/**
	 * 得到Session对象
	 * @return
	 */
	private  static HttpSession getSession(){
		/*ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return 	sra.getRequest().getSession();*/
		return ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
	}
	
	/**
	 * 把登录对象保存到Session域
	 */
	public static void setCurrent(String key,Object current){
		getSession().setAttribute(key, current);
	}
	
	/**
	 * 从Session域获取当前登录的logininfo
	 * @return
	 */
	public static Object getCurrent(String key){
		return getSession().getAttribute(key);
	}
	
	
}
