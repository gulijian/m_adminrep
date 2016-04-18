package com.gu.service.adminuser.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gu.bean.AdminUser;
import com.gu.bean.Params;
import com.gu.dao.adminuser.IAdminUserMapper;
import com.gu.service.adminuser.IAdminUserService;
import com.gu.util.GStringUtils;

/**
 * 用户管理serviceImpl
 * IAdminUserService
 * 创建人:gulj 
 * 时间：2015年12月21日 21:43:01
 * @version 1.0.0
 * 
 */
@Service
public class AdminUserServiceImpl implements IAdminUserService{

	@Autowired
	private IAdminUserMapper adminuserMapper;
	
	@Override
	public List<AdminUser> findAdminUsers(Params params){
		if(GStringUtils.isEmpty(params.getOrder()))params.setOrder("create_time desc");
		return adminuserMapper.findAdminUsers(params);
	}
	
	@Override
	public int count(Params params){
		return adminuserMapper.count(params);
	}

	@Override
	public AdminUser get(Integer id) {
		return adminuserMapper.get(id);
	}

	@Override
	public int save(AdminUser adminuser) {
		return adminuserMapper.save(adminuser);
	}

	@Override
	public int update(AdminUser adminuser) {
		return adminuserMapper.update(adminuser);
	}

	@Override
	public int delete(Params params) {
		return adminuserMapper.delete(params);
	}
}
