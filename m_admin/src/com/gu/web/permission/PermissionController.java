package com.gu.web.permission;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gu.bean.Params;
import com.gu.service.permission.IPermissionService;

/**
 * 用户管理web
 * PermissionController
 * 创建人:gulj
 * 时间：2015年12月21日 22:22:04
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin/permission")
public class PermissionController {
	
	@Autowired
	private IPermissionService permissionService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public String list(Params params){
		return "permission/list";
	}
	
	
	/*列表查询*/
	@ResponseBody
	@RequestMapping("/root")
	public HashMap<String, Object> root(Params params){
		return permissionService.findPermissions(params);
	}
}
