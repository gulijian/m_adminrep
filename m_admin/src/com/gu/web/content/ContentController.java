package com.gu.web.content;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gu.bean.Content;
import com.gu.bean.Params;
import com.gu.service.content.IContentService;

/**
 * 内容管理web
 * ContentController
 * 创建人:gulj
 * 时间：2015年12月04日 13:07:58
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/admin/content")
public class ContentController {
	
	@Autowired
	private IContentService contentService;
	
	@RequestMapping("/list")
	public String list(Params params){
		return "content/list";
	}
	
	
	@RequestMapping("/template")
	public ModelAndView template(Params params){
		ModelAndView modelAndView = new ModelAndView();
		params.setIsDelete(0);
		List<Content> contents = contentService.findContents(params);
		int count = contentService.count(params);
		modelAndView.setViewName("content/template");
		modelAndView.addObject("datas",contents);
		modelAndView.addObject("itemCount",count);
		return modelAndView;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(Content content){
		contentService.update(content);
		return "success";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(Params params){
		contentService.delete(params);
		return "success";
	}
}
