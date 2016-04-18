package com.gu.service.content.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gu.bean.Content;
import com.gu.bean.Params;
import com.gu.dao.content.IContentMapper;
import com.gu.service.content.IContentService;
import com.gu.util.GStringUtils;

/**
 * 内容管理serviceImpl
 * IContentService
 * 创建人:gulj 
 * 时间：2015年12月04日 13:07:58
 * @version 1.0.0
 * 
 */
@Service
public class ContentServiceImpl implements IContentService{

	@Autowired
	private IContentMapper contentMapper;
	
	@Override
	public List<Content> findContents(Params params){
		if(GStringUtils.isEmpty(params.getOrder()))params.setOrder("create_time desc");
		return contentMapper.findContents(params);
	}
	
	@Override
	public int count(Params params){
		return contentMapper.count(params);
	}

	@Override
	public Content get(Integer id) {
		return contentMapper.get(id);
	}

	@Override
	public int save(Content content) {
		return contentMapper.save(content);
	}

	@Override
	public int update(Content content) {
		return contentMapper.update(content);
	}

	@Override
	public int delete(Params params) {
		return contentMapper.delete(params);
	}
}
