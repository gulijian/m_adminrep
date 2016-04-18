package com.gu.web.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gu.bean.Message;
import com.gu.bean.Params;
import com.gu.service.message.IMessageService;

/**
 * 信息管理web
 * MessageController
 * 创建人:gulj
 * 时间：2015年12月04日 10:35:08
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin/message")
public class MessageController {
	
	@Autowired
	private IMessageService messageService;
	
	/*列表查询*/
	@RequestMapping("/list")
	public String list(Params params){
		return "message/list";
	}
	
	/*模板页面*/
	@RequestMapping("/template")
	public ModelAndView template(Params params){
		ModelAndView modelAndView = new ModelAndView();
		List<Message> messages = messageService.findMessages(params);
		int count = messageService.count(params);
		modelAndView.setViewName("message/template");
		modelAndView.addObject("datas",messages);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}
}
