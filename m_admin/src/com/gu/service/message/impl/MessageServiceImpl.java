package com.gu.service.message.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gu.bean.Message;
import com.gu.bean.Params;
import com.gu.dao.message.IMessageMapper;
import com.gu.service.message.IMessageService;
import com.gu.util.GStringUtils;

/**
 * 信息管理serviceImpl
 * IMessageService
 * 创建人:gulj 
 * 时间：2015年12月04日 10:35:08
 * @version 1.0.0
 * 
 */
@Service
public class MessageServiceImpl implements IMessageService{

	@Autowired
	private IMessageMapper messageMapper;
	
	@Override
	public List<Message> findMessages(Params params){
		if(GStringUtils.isEmpty(params.getOrder()))params.setOrder("create_time desc");
		return messageMapper.findMessages(params);
	}
	
	@Override
	public int count(Params params){
		return messageMapper.count(params);
	}

	@Override
	public Message get(Integer id) {
		return messageMapper.get(id);
	}

	@Override
	public int save(Message message) {
		return messageMapper.save(message);
	}

	@Override
	public int update(Message message) {
		return messageMapper.update(message);
	}

	@Override
	public int delete(Params params) {
		return messageMapper.delete(params);
	}
}
