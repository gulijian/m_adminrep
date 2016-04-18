package com.gu.dao.content;

import java.util.List;

import com.gu.bean.Content;
import com.gu.bean.Params;

/**
 * 内容管理Mapper
 * IContentMapper
 * 创建人:gulj 
 * 时间：2015年12月04日 13:07:58
 * @version 1.0.0
 * 
 */
public interface IContentMapper {

	/**
	 * 
	 * com.gu.dao.content 
	 * 方法名：findContents
	 * 创建人：gulj 
	 * 手机号码:15295059075
	 * 时间：2015年12月04日 13:07:58
	 * @param params
	 * @return 
	 * 返回类型：List<Content>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Content> findContents(Params params);
	
	/**
	 * 求总数
	 * com.gu.dao.content 
	 * 方法名：count
	 * 创建人：gulj 
	 * 手机号码:15295059075
	 * 时间：2015年12月04日 13:07:58
	 * @param id
	 * @return 
	 * 返回类型：List<Content>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(Params params);
	
	/**
	 * 
	 * com.gu.dao.content 
	 * 方法名：getContent
	 * 创建人：gulj 
	 * 手机号码:15295059075
	 * 时间：2015年12月04日 13:07:58
	 * @param id
	 * @return 
	 * 返回类型：List<Content>
	 * @exception 
	 * @since  1.0.0
	 */
	public Content get(Integer id);
	
	/**
	 * 保存内容管理
	 * com.gu.dao.content 
	 * 方法名：save
	 * 创建人：gulj 
	 * 手机号码:15295059075
	 * 时间：2015年12月04日 13:07:58
	 * @param content
	 * @return 
	 * 返回类型：Content
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(Content content);
	
	/**
	 * 更新内容管理
	 * com.gu.dao.content 
	 * 方法名：update
	 * 创建人：gulj 
	 * 手机号码:15295059075
	 * 时间：2015年12月04日 13:07:58
	 * @param content
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(Content content);
	
	/**
	 * 删除内容管理
	 * com.gu.dao.content 
	 * 方法名：delete
	 * 创建人：gulj 
	 * 手机号码:15295059075
	 * 时间：2015年12月04日 13:07:58 
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(Params params);
	
}
