package com.gu.service.adminstat.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gu.bean.AdminStat;
import com.gu.bean.Params;
import com.gu.dao.adminstat.IAdminStatMapper;
import com.gu.service.adminstat.IAdminStatService;
import com.gu.util.GStringUtils;

/**
 * 日记管理serviceImpl
 * IAdminStatService
 * 创建人:gulj
 * 时间：2015年12月05日 00:07:45
 * @version 1.0.0
 * 
 */
@Service
public class AdminStatServiceImpl implements IAdminStatService{

	@Autowired
	private IAdminStatMapper adminstatMapper;
	
	@Override
	public List<AdminStat> findAdminStats(Params params){
		if(GStringUtils.isEmpty(params.getOrder()))params.setOrder("create_time desc");
		return adminstatMapper.findAdminStats(params);
	}
	
	@Override
	public int count(Params params){
		return adminstatMapper.count(params);
	}

	@Override
	public AdminStat get(Integer id) {
		return adminstatMapper.get(id);
	}

	@Override
	public int save(AdminStat adminstat) {
		return adminstatMapper.save(adminstat);
	}

	@Override
	public int update(AdminStat adminstat) {
		return adminstatMapper.update(adminstat);
	}

	@Override
	public int delete(Params params) {
		return adminstatMapper.delete(params);
	}

	@Override
	public List<HashMap<String, Object>> groupContents(Params params) {
		return adminstatMapper.groupContents(params);
	}

	@Override
	public List<HashMap<String, Object>> groupUsers(Params params) {
		return adminstatMapper.groupUsers(params);
	}
}
