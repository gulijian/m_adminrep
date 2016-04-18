package com.gu.dao.message;

import java.util.List;

import com.gu.bean.Message;
import com.gu.bean.Params;

/**
 * 信息管理Mapper
 * IMessageMapper
 * 创建人:gulj 
 * 时间：2015年12月04日 10:35:08
 * @version 1.0.0
 * 
 */
public interface IMessageMapper {

	/**
	 * 
	 * com.gu.dao.message 
	 * 方法名：findMessages
	 * 创建人：gulj 
	 * 手机号码:15295059075
	 * 时间：2015年12月04日 10:35:08
	 * @param params
	 * @return 
	 * 返回类型：List<Message>
	 * @exception 
	 * @since  1.0.0
	 */
	public List<Message> findMessages(Params params);
	
	/**
	 * 求总数
	 * com.gu.dao.message 
	 * 方法名：count
	 * 创建人：gulj 
	 * 手机号码:15295059075
	 * 时间：2015年12月04日 10:35:08
	 * @param id
	 * @return 
	 * 返回类型：List<Message>
	 * @exception 
	 * @since  1.0.0
	 */
	public int count(Params params);
	
	/**
	 * 
	 * com.gu.dao.message 
	 * 方法名：getMessage
	 * 创建人：gulj 
	 * 手机号码:15295059075
	 * 时间：2015年12月04日 10:35:08
	 * @param id
	 * @return 
	 * 返回类型：List<Message>
	 * @exception 
	 * @since  1.0.0
	 */
	public Message get(Integer id);
	
	/**
	 * 保存信息管理
	 * com.gu.dao.message 
	 * 方法名：save
	 * 创建人：gulj 
	 * 手机号码:15295059075
	 * 时间：2015年12月04日 10:35:08
	 * @param message
	 * @return 
	 * 返回类型：Message
	 * @exception 
	 * @since  1.0.0
	 */
	public int save(Message message);
	
	/**
	 * 更新信息管理
	 * com.gu.dao.message 
	 * 方法名：update
	 * 创建人：gulj 
	 * 手机号码:15295059075
	 * 时间：2015年12月04日 10:35:08
	 * @param message
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int update(Message message);
	
	/**
	 * 删除信息管理
	 * com.gu.dao.message 
	 * 方法名：delete
	 * 创建人：gulj 
	 * 手机号码:15295059075
	 * 时间：2015年12月04日 10:35:08 
	 * @param params
	 * @return 
	 * 返回类型：int
	 * @exception 
	 * @since  1.0.0
	 */
	public int delete(Params params);
	
}
