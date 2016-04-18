package com.gu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * IndexController
 * 创建人:gulj 
 * 时间：2015年11月23日-下午11:46:36 
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin")
public class IndexController {

	@RequestMapping("/index")
	public String index(){
		return "index";
	}
}
