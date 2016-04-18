package com.gu.service.adminstat;

import java.util.HashMap;
import java.util.List;

import com.gu.bean.Params;

/**
 * 日记管理Mapper
 * IAdminStatMapper
 * 创建人:gulj
 * 时间：2015年12月05日 00:07:45
 * @version 1.0.0
 * 
 */
public interface IStatService {

	/**
	 * 
	 * com.gu.dao.adminstat 
	 * 方法名：findAdminStats
	 * 创建人：gulj
	 * 时间：2015年12月05日 00:07:45
	 * @param params
	 * @return 
	 * 返回类型：List<AdminStat>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<HashMap<String, Object>> groupContent(Params params);

}
