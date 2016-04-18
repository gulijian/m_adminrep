package com.gu.dao.permission;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gu.bean.Permission;
import com.gu.bean.Params;

/**
 * 用户管理Mapper
 * IPermissionMapper
 * 创建人:gulj 
 * 时间：2015年12月21日 22:22:04
 * @version 1.0.0
 * 
 */
public interface IPermissionMapper {

	/**
	 * 
	 * com.gu.dao.permission 
	 * 方法名：findPermissions
	 * 创建人：gulj 
	 * 手机号码:15295059075
	 * 时间：2015年12月21日 22:22:04
	 * @param params
	 * @return 
	 * 返回类型：List<Permission>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Permission> findPermissionRoot(Params params);
	public List<Permission> findPermissionChildren(@Param("id")Integer parentId);
	
	/**
	 * 求总数
	 * com.gu.dao.permission 
	 * 方法名：count
	 * 创建人：gulj 
	 * 手机号码:15295059075
	 * 时间：2015年12月21日 22:22:04
	 * @param id
	 * @return 
	 * 返回类型：List<Permission>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(Params params);
	
	/**
	 * 
	 * com.gu.dao.permission 
	 * 方法名：getPermission
	 * 创建人：gulj 
	 * 手机号码:15295059075
	 * 时间：2015年12月21日 22:22:04
	 * @param id
	 * @return 
	 * 返回类型：List<Permission>
	 * @exception 
	 * @since  1.0.0
	 */
	public Permission get(Integer id);
	
	/**
	 * 保存用户管理
	 * com.gu.dao.permission 
	 * 方法名：save
	 * 创建人：gulj 
	 * 手机号码:15295059075
	 * 时间：2015年12月21日 22:22:04
	 * @param permission
	 * @return 
	 * 返回类型：Permission
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(Permission permission);
	
	/**
	 * 更新用户管理
	 * com.gu.dao.permission 
	 * 方法名：update
	 * 创建人：gulj 
	 * 手机号码:15295059075
	 * 时间：2015年12月21日 22:22:04
	 * @param permission
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(Permission permission);
	
	/**
	 * 删除用户管理
	 * com.gu.dao.permission 
	 * 方法名：delete
	 * 创建人：gulj 
	 * 手机号码:15295059075
	 * 时间：2015年12月21日 22:22:04 
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(Params params);
	
}
