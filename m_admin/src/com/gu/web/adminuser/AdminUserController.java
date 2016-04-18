package com.gu.web.adminuser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gu.bean.AdminUser;
import com.gu.bean.Params;
import com.gu.service.adminuser.IAdminUserService;

/**
 * 用户管理web
 * AdminUserController
 * 创建人:gulj
 * 时间：2015年12月21日 21:43:01
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin/adminuser")
public class AdminUserController {
	
	@Autowired
	private IAdminUserService adminuserService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public String list(Params params){
		return "adminuser/list";
	}
	
	/*模板页面*/
	@RequestMapping("/template")
	public ModelAndView template(Params params){
		ModelAndView modelAndView = new ModelAndView();
		params.setIsDelete(0);
		params.setOrder("create_time desc");
		List<AdminUser> adminusers = adminuserService.findAdminUsers(params);
		int count = adminuserService.count(params);
		modelAndView.setViewName("adminuser/template");
		modelAndView.addObject("datas",adminusers);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}
	
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,value="/delete")
	public String delete(Params params){
		try {
			adminuserService.delete(params);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
