package com.gu.service.permission.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gu.bean.Permission;
import com.gu.bean.Params;
import com.gu.dao.permission.IPermissionMapper;
import com.gu.service.permission.IPermissionService;
import com.gu.util.GStringUtils;

/**
 * 用户管理serviceImpl
 * IPermissionService
 * 创建人:gulj 
 * 时间：2015年12月21日 22:22:04
 * @version 1.0.0
 * 
 */
@Service
public class PermissionServiceImpl implements IPermissionService{

	@Autowired
	private IPermissionMapper permissionMapper;
	
	TreeMap<String,List<HashMap<String, Object>>> childrenMap = null;
	@Override
	public HashMap<String,Object> findPermissions(Params params){
		//返回类型
		HashMap<String, Object> datas = new HashMap<>();
		//装载所有的子元素
		childrenMap = new TreeMap<>();
		//所有的根目标
		List<Permission> permissions = permissionMapper.findPermissionRoot(params);
		if(permissions!=null && permissions.size()>0){
			List<HashMap<String, Object>> maps = new ArrayList<>();//泛型的菱形写法 jdk1.7
			for (Permission permission : permissions) {
				HashMap<String, Object> map = new HashMap<>();
				map.put("name", permission.getName());
				map.put("url", "javascript:void(0);");
				map.put("opid", permission.getId());
				map.put("pid", permission.getId());
				maps.add(map);
				getChildrenData(permission.getId());
			}
			datas.put("root", maps);
			datas.put("children", childrenMap);
			return datas;
		}else{
			return null;
		}
	}
	
	
	/**
	 * com.tz.service.permission.impl 
	 * 方法名：getChildrenData
	 * 创建人：gulj 
	 * 时间：2015年12月15日-上午12:23:53 
	 * @param pid 
	 * 返回类型：void
	 * @exception 
	 * @since  1.0.0
	 */
	private void getChildrenData(Integer pid){
		//查询所有的子类
		List<Permission> childrenPermissions = permissionMapper.findPermissionChildren(pid);
		//判断是否还有子类对象
		if(childrenPermissions!=null && childrenPermissions.size()>0){
			//数据类型接受
			List<HashMap<String, Object>> maps = new ArrayList<>();//泛型的菱形写法 jdk1.7
			//开始循环所有子类
			for (Permission permission : childrenPermissions) {
				HashMap<String, Object> map = new HashMap<>();
				map.put("name", permission.getName());
				map.put("url", "javascript:void(0);");
				map.put("opid", permission.getId());
				map.put("pid", permission.getId());
				//添加到返回值中
				maps.add(map);
				getChildrenData(permission.getId());
			}
			childrenMap.put(pid+"", maps);
		}
	}
	@Override
	public int count(Params params){
		return permissionMapper.count(params);
	}

	@Override
	public Permission get(Integer id) {
		return permissionMapper.get(id);
	}

	@Override
	public int save(Permission permission) {
		return permissionMapper.save(permission);
	}

	@Override
	public int update(Permission permission) {
		return permissionMapper.update(permission);
	}

	@Override
	public int delete(Params params) {
		return permissionMapper.delete(params);
	}
}
