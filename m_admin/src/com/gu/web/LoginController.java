package com.gu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gu.bean.AdminUser;
import com.gu.bean.Params;
import com.gu.core.BaseController;
import com.gu.service.user.IUserService;
import com.gu.util.GStringUtils;

import static com.gu.util.Constant.*;
/**
 * 
 * LoginController
 * 创建人:gulj
 * 时间：2015年12月1日-下午2:37:44 
 * @version 1.0.0
 *
 */
@Controller
public class LoginController extends BaseController{
	
	@Autowired
	IUserService  service;

	@RequestMapping("/login")
	public String login(){
		return "login";
	}

	/**
	 * 
	 * 登陆
	 * 方法名：logined
	 * 创建人：gulj
	 * 时间：2015年12月1日-下午2:37:58 
	 * @param params
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	@ResponseBody
	@RequestMapping(value="/logined",method=RequestMethod.POST)
	public String logined(Params params){
		if(params!=null){
			if(GStringUtils.isNotEmpty(params.getUsername()) && GStringUtils.isNotEmpty(params.getPassword())){
				params.setPassword(GStringUtils.md5Base64(params.getPassword()));
				AdminUser user = service.getLogin(params);
				if(user!=null){
					session.setAttribute(SESSION_USER, user);
					session.setAttribute(SESSION_USER_USERNAME, user.getUsername());
					//日记监控用户行为和获取请求参数
					request.getServletContext().setAttribute("user_log", user);
					request.getServletContext().setAttribute("request_log", request);
					return "success";
				}else{
					return "fail";
				}
			}else{
				return "null";//请输入账号和密码
			}
		}else{
			return "error";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(){
		session.invalidate();
		return "redirect:login";
	}
}