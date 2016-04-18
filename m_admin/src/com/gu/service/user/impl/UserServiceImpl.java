package com.gu.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gu.bean.Params;
import com.gu.bean.AdminUser;
import com.gu.dao.user.IUserMapper;
import com.gu.service.user.IUserService;

/**
 * 
 * UserServiceImpl
 * 创建人:gulj
 * 时间：2015年12月1日-下午2:50:46 
 * @version 1.0.0
 *
 */
@Service
public class UserServiceImpl  implements IUserService{


	@Autowired
	private IUserMapper userMapper;
	
	@Override
	public AdminUser getLogin(Params params) {
		return userMapper.getLogin(params);	
	}
}
