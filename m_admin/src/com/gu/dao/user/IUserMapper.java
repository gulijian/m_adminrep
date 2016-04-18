
package com.gu.dao.user;

import com.gu.bean.Params;
import com.gu.bean.AdminUser;

/**
 * 
 * IUserMapper
 * 创建人:gulj
 * 时间：2015年12月1日-下午2:28:45 
 * @version 1.0.0
 *
 */
public interface IUserMapper {

	/**
	 * 
	 * 根据账号和密码实现登陆
	 * 方法名：getLogin
	 * 创建人：gulj
	 * 时间：2015年12月1日-下午2:28:38 
	 * @param params
	 * @return User
	 * @exception 
	 * @since  1.0.0
	 */
	public AdminUser getLogin(Params params);
}
