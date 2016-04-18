package com.gu.dao.adminuser;

import java.util.List;

import com.gu.bean.AdminUser;
import com.gu.bean.Params;

/**
 * 用户管理Mapper
 * IAdminUserMapper
 * 创建人:gulj 
 * 时间：2015年12月21日 21:43:01
 * @version 1.0.0
 * 
 */
public interface IAdminUserMapper {

	/**
	 * 
	 * com.gu.dao.adminuser 
	 * 方法名：findAdminUsers
	 * 创建人：gulj 
	 * 手机号码:15295059075
	 * 时间：2015年12月21日 21:43:01
	 * @param params
	 * @return 
	 * 返回类型：List<AdminUser>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<AdminUser> findAdminUsers(Params params);
	
	/**
	 * 求总数
	 * com.gu.dao.adminuser 
	 * 方法名：count
	 * 创建人：gulj 
	 * 手机号码:15295059075
	 * 时间：2015年12月21日 21:43:01
	 * @param id
	 * @return 
	 * 返回类型：List<AdminUser>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(Params params);
	
	/**
	 * 
	 * com.gu.dao.adminuser 
	 * 方法名：getAdminUser
	 * 创建人：gulj 
	 * 手机号码:15295059075
	 * 时间：2015年12月21日 21:43:01
	 * @param id
	 * @return 
	 * 返回类型：List<AdminUser>
	 * @exception 
	 * @since  1.0.0
	 */
	public AdminUser get(Integer id);
	
	/**
	 * 保存用户管理
	 * com.gu.dao.adminuser 
	 * 方法名：save
	 * 创建人：gulj 
	 * 手机号码:15295059075
	 * 时间：2015年12月21日 21:43:01
	 * @param adminuser
	 * @return 
	 * 返回类型：AdminUser
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(AdminUser adminuser);
	
	/**
	 * 更新用户管理
	 * com.gu.dao.adminuser 
	 * 方法名：update
	 * 创建人：gulj 
	 * 手机号码:15295059075
	 * 时间：2015年12月21日 21:43:01
	 * @param adminuser
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(AdminUser adminuser);
	
	/**
	 * 删除用户管理
	 * com.gu.dao.adminuser 
	 * 方法名：delete
	 * 创建人：gulj 
	 * 手机号码:15295059075
	 * 时间：2015年12月21日 21:43:01 
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(Params params);
	
}
