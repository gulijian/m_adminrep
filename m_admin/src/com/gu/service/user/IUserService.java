package com.gu.service.user;

import com.gu.bean.AdminUser;
import com.gu.bean.Params;

/**
 * 
 * IUserService
 * 创建人:gulj
 * 时间：2015年12月1日-下午2:51:22 
 * @version 1.0.0
 *
 */
public interface IUserService {

	/**
	 * 
	 * 根据账号和密码实现登陆
	 * 方法名：getLogin
	 * 创建人：gulj
	 * 时间：2015年12月1日-下午2:51:33 
	 * @param params
	 * @return User
	 * @exception 
	 * @since  1.0.0
	 */
	public AdminUser getLogin(Params params);
}
