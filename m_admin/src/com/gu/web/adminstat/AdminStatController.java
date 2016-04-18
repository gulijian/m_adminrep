package com.gu.web.adminstat;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gu.bean.AdminStat;
import com.gu.bean.Params;
import com.gu.service.adminstat.IAdminStatService;

/**
 * 日记管理web
 * AdminStatController
 * 创建人:gulj
 * 时间：2015年12月05日 00:07:45
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin/adminstat")
public class AdminStatController {
	
	@Autowired
	private IAdminStatService adminstatService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public String list(Params params){
		return "adminstat/list";
	}
	
	/*用户统计列表查询*/
	@RequestMapping(value="/userlist")
	public String userlist(){
		return "adminstat/userlist";
	}
	
	
	/*内容统计列表查询*/
	@RequestMapping(value="/contentlist")
	public String contentlist(){
		return "adminstat/contentlist";
	}
	
	/*模板页面*/
	@RequestMapping("/template")
	public ModelAndView template(Params params){
		ModelAndView modelAndView = new ModelAndView();
		List<AdminStat> adminstats = adminstatService.findAdminStats(params);
		int count = adminstatService.count(params);
		modelAndView.setViewName("adminstat/template");
		modelAndView.addObject("datas",adminstats);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}
	
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,value="/groupcontent")
	public List<HashMap<String, Object>> groupContents(Params params){
		List<HashMap<String, Object>> datas = adminstatService.groupContents(params);
		return datas;
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST,value="/groupusers")
	public List<HashMap<String, Object>> groupUsers(Params params){
		List<HashMap<String, Object>> datas = adminstatService.groupUsers(params);
		return datas;
	}
}
