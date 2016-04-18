package com.gu.test;

import org.apache.struts2.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gu.bean.AdminUser;
import com.gu.bean.Params;
import com.gu.bean.User;
import com.gu.service.user.IUserService;

/**
 * 
 * TestApplicationContext
 * 创建人:gulj
 * 时间：2015年12月1日-下午2:49:55 
 * @version 1.0.0
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class TestApplicationContext {
	
	@Autowired
	IUserService  service;
	@Test
	public void handler() throws JSONException{
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
//		DruidDataSource dataSource = context.getBean(DruidDataSource.class);
//		System.out.println("============"+dataSource);
//		IUserMapper mapper = context.getBean(IUserMapper.class);
//		System.out.println(mapper);
		Params params = new Params();
		params.setUsername("gulj");
		params.setPassword("4QrcOUm6Wau+VuBX8g+IPg==");
		AdminUser user = service.getLogin(params);
		System.out.println("============="+user.getUsername());
	}
}
