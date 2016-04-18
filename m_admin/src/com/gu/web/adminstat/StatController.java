package com.gu.web.adminstat;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gu.bean.Params;
import com.gu.service.adminstat.IStatService;

/**
 * 日记管理web
 * StatController
 * 创建人:gulj
 * 时间：2015年12月05日 00:07:45
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin/stat")
public class StatController {
	
	@Autowired
	private IStatService statService;
	
	/*列表查询*/
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public List<HashMap<String, Object>> list(Params params){
		List<HashMap<String, Object>> datas = statService.groupContent(params);
		return datas;
	}
	

	
}
