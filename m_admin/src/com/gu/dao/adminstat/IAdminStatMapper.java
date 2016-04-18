package com.gu.dao.adminstat;

import java.util.HashMap;
import java.util.List;

import com.gu.bean.AdminStat;
import com.gu.bean.Params;

/**
 * 日记管理Mapper
 * IAdminStatMapper
 * 创建人:gulj 
 * 时间：2015年12月05日 00:07:45
 * @version 1.0.0
 * 
 */
public interface IAdminStatMapper {

	/**
	 * 
	 * com.tz.dao.adminstat 
	 * 方法名：findAdminStats
	 * 创建人：gulj
	 * 时间：2015年12月05日 00:07:45
	 * @param params
	 * @return 
	 * 返回类型：List<AdminStat>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<AdminStat> findAdminStats(Params params);
	
	/**
	 * 求总数
	 * com.tz.dao.adminstat 
	 * 方法名：count
	 * 创建人：gulj
	 * 时间：2015年12月05日 00:07:45
	 * @param id
	 * @return 
	 * 返回类型：List<AdminStat>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(Params params);
	
	/**
	 * 
	 * com.tz.dao.adminstat 
	 * 方法名：getAdminStat
	 * 创建人：gulj
	 * 时间：2015年12月05日 00:07:45
	 * @param id
	 * @return 
	 * 返回类型：List<AdminStat>
	 * @exception 
	 * @since  1.0.0
	 */
	public AdminStat get(Integer id);
	
	/**
	 * 保存日记管理
	 * com.tz.dao.adminstat 
	 * 方法名：save
	 * 创建人：gulj
	 * 时间：2015年12月05日 00:07:45
	 * @param adminstat
	 * @return 
	 * 返回类型：AdminStat
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(AdminStat adminstat);
	
	/**
	 * 更新日记管理
	 * com.tz.dao.adminstat 
	 * 方法名：update
	 * 创建人：gulj
	 * 时间：2015年12月05日 00:07:45
	 * @param adminstat
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(AdminStat adminstat);
	
	/**
	 * 删除日记管理
	 * com.tz.dao.adminstat 
	 * 方法名：delete
	 * 创建人：gulj
	 * 时间：2015年12月05日 00:07:45 
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(Params params);
	
	/**
	 * 根据月份查询具体内容信息
	 * com.tz.dao.adminstat 
	 * 方法名：groupContents
	 * 创建人：gulj 
	 * 时间：2015年12月9日-下午9:25:41 
	 * @param params
	 * @return 
	 * 返回类型：List<HashMap<String,Object>>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<HashMap<String,Object>> groupContents(Params params);
	
	/**
	 * 统计出某一天中某一时刻的注册用户
	 * com.gu.dao.adminstat 
	 * 方法名：groupUsers
	 * 创建人：gulj 
	 * 手机号码:15074816437
	 * 时间：2015年12月9日-下午10:23:50 
	 * @param params
	 * @return 
	 * 返回类型：List<HashMap<String,Object>>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<HashMap<String,Object>> groupUsers(Params params);
	
}
