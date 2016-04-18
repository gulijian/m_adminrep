package com.gu.service.adminstat.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gu.bean.Params;
import com.gu.dao.adminstat.IStatMapper;
import com.gu.service.adminstat.IStatService;

/**
 * 日记管理serviceImpl
 * IAdminStatService
 * 创建人:gulj 
 * 时间：2015年12月05日 00:07:45
 * @version 1.0.0
 * 
 */
@Service
public class StatServiceImpl implements IStatService{

	@Autowired
	private IStatMapper statMapper;

	@Override
	public List<HashMap<String, Object>> groupContent(Params params) {
		return statMapper.groupContent(params);
	}
	
	
}
