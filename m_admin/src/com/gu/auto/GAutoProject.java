package com.gu.auto;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

import com.gu.util.GFileUtil;
import com.gu.util.GStringUtils;


/**
 * 
 * AutoProject
 * 创建人:gulj 
 * 时间：2015年11月28日-下午11:40:30 
 * @version 1.0.0
 * 
 */
public class GAutoProject {
	
	//bean
	//service 
	//dao 
	//web/bean
	//pages/bean
	private static String beanName = "Permission";
	private static String smallBeanName = beanName.toLowerCase();
	
	//注释
	private static String description = "用户管理";
	private static String author = "gulj";
	private static String qq = "1175327069";
	private static String telephone = "15295059075";
	private static String email = "1175327069@qq.com";
	private static String date = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date());
	
	
	//目录结构
	private static String srcPath = "src/";
	private static String beanPath = "com/gu/bean/";
	private static String daoPath = "com/gu/dao/";
	private static String servicePath = "com/gu/service/";
	private static String serviceImplPath = "com/gu/service/"+smallBeanName+"/impl/";
	private static String webPath = "com/gu/web/"+smallBeanName+"/";
	private static String pagePath = "/WebRoot/WEB-INF/pages/"+smallBeanName+"/";
	
	//模板目录
	private static String beanTemplate = "template/bean.txt";
	private static String daoTemplate = "template/mapper.txt";
	private static String xmlTemplate = "template/sql.txt";
	private static String serviceTemplate = "template/service.txt";
	private static String serviceImplTemplate = "template/serviceImpl.txt";
	private static String webTemplate = "template/web.txt";
	private static String pageTemplate = "template/list.txt";
	private static String tableTemplate = "template/table.sql";
	private static String templateTemplate = "template/template.txt";
	
	//包名
	private static String beanPackage ="com.gu.bean";
	private static String daoPackage ="com.gu.dao";
	private static String servicePackage ="com.gu.service";
	private static String serviceImplPackage ="com.gu.service"+smallBeanName+".impl";
	private static String webPackage ="com.gu.web";
	
	//template
	public static void createTemplate() throws IOException{
		//bean的根目录
		String rootPath = getRoot(pagePath);
//					//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile,"template.jsp");
		//获取模板页面路径
		String template = getRoot(templateTemplate);
//					//读取模板内容
		String content = GFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示Template: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示Template: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+pagePath+"】成功!!!");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	
	//page
		public static void createPage() throws IOException{
			//bean的根目录
			String rootPath = getRoot(pagePath);
//						//自动创建根目录
			File rootFile  = new File(rootPath);
			if(!rootFile.exists())rootFile.mkdirs();
			//写入的目标文件
			File beanFile = new File(rootFile,"list.jsp");
			//获取模板页面路径
			String template = getRoot(pageTemplate);
//						//读取模板内容
			String content = GFileUtil.readFileByLines(template);
			//替换模板内容
			content = replaceTemplate(content);
			//判断文件是否存在，提示是否覆盖操作
			if (beanFile.exists()) {
				System.out.println("【自动构建提示Pages: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
				//控制台输入对象
				Scanner scanner = new Scanner(System.in);
				//获取控制台输入的值
				String mark = scanner.nextLine();
				if(mark.equalsIgnoreCase("yes")){
					//替换写入目标文件
					FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
				}
			}else{
				System.out.println("【自动构建提示Pages: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+pagePath+"】成功!!!");
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}
	
	//web
	public static void createWeb() throws IOException{
		//bean的根目录
		String rootPath = getRoot(srcPath+webPath);
//				//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile, beanName+"Controller.java");
		//获取模板页面路径
		String template = getRoot(webTemplate);
//				//读取模板内容
		String content = GFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示Web: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示Web: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+webPackage+"】成功!!!");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	
	//serviceImpl
	public static void createServiceImpl() throws IOException{
		//bean的根目录
		String rootPath = getRoot(srcPath+serviceImplPath);
//			//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile, beanName+"ServiceImpl.java");
		//获取模板页面路径
		String template = getRoot(serviceImplTemplate);
//			//读取模板内容
		String content = GFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示ServiceImpl: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示ServiceImpl: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+serviceImplPackage+"】成功!!!");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	
	//service
	public static void createService() throws IOException{
		//bean的根目录
		String rootPath = getRoot(srcPath+servicePath+smallBeanName);
//			//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile, "I"+beanName+"Service.java");
		//获取模板页面路径
		String template = getRoot(serviceTemplate);
//			//读取模板内容
		String content = GFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示Service: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示Service: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+servicePackage+"】成功!!!");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	
	
	
	//sqlxml
	public static void createSQLXml() throws IOException{
		//bean的根目录
		String rootPath = getRoot(srcPath+daoPath+smallBeanName);
//		//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile, beanName+".xml");
		//获取模板页面路径
		String template = getRoot(xmlTemplate);
//		//读取模板内容
		String content = GFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示sqlxml: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示sqlxml: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+daoPackage+"】成功!!!");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	
	
	//mapper
	public static void createDao() throws IOException{
		//bean的根目录
		String rootPath = getRoot(srcPath+daoPath+smallBeanName);
//		//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile, "I"+beanName+"Mapper.java");
		//获取模板页面路径
		String template = getRoot(daoTemplate);
//		//读取模板内容
		String content = GFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示Mapper: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示Mapper: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+daoPackage+"】成功!!!");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	
	//创建bean
	public static void createBean() throws IOException{
		//bean的根目录
		String rootPath = getRoot(srcPath+beanPath);
		//自动创建根目录
		File rootFile  = new File(rootPath);
		if(!rootFile.exists())rootFile.mkdirs();
		//写入的目标文件
		File beanFile = new File(rootFile, beanName+".java");
		//获取模板页面路径
		String template = getRoot(beanTemplate);
		//读取模板内容
		String content = GFileUtil.readFileByLines(template);
		//替换模板内容
		content = replaceTemplate(content);
		//判断文件是否存在，提示是否覆盖操作
		if (beanFile.exists()) {
			System.out.println("【自动构建提示Bean: 】【"+beanFile.getAbsolutePath()+"】已经存在，是否覆盖yes/no!\n");
			//控制台输入对象
			Scanner scanner = new Scanner(System.in);
			//获取控制台输入的值
			String mark = scanner.nextLine();
			if(mark.equalsIgnoreCase("yes")){
				//替换写入目标文件
				FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
			}
		}else{
			System.out.println("【自动构建提示Bean: 】您当前创建的:【"+beanFile.getAbsolutePath()+"】写入到【"+beanPackage+"】成功!!!");
			//替换写入目标文件
			FileUtils.writeStringToFile(beanFile.getAbsoluteFile(), content, "UTF-8");
		}
	}
	
	public static void createTable(){
		try {
			//获取模板页面路径
			String template = getRoot(tableTemplate);
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.42.138.7:3306/m_admin?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull", "root", "root");
			new SqlFileExecutor().execute(connection, template,"\\[smallBeanName\\]",smallBeanName);
	        System.out.println("【自动构建提示Table: 】生成表sys_"+smallBeanName+"表成功!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("【自动构建提示Table: 】生成表sys_"+smallBeanName+"表失败!");
		} 
	}
	
	
	
	/**
	 * 替换模板信息
	 * com.gu.auto 
	 * 方法名：replaceTemplate
	 * 创建人：gulj 
	 * 时间：2015年11月29日-上午12:27:48 
	 * @param content
	 * @return 
	 * 返回类型：String
	 * @exception 
	 * @since  1.0.0
	 */
	public static String replaceTemplate(String content){
		if(GStringUtils.isNotEmpty(content)){
			content = content.replaceAll("\\[beanPackage\\]",beanPackage)
					.replaceAll("\\[daoPackage\\]",daoPackage)
					.replaceAll("\\[servicePackage\\]",servicePackage)
					.replaceAll("\\[webPackage\\]",webPackage)
					.replaceAll("\\[description\\]",description)
					.replaceAll("\\[author\\]",author)
					.replaceAll("\\[date\\]",date)
					.replaceAll("\\[qq\\]",qq)
					.replaceAll("\\[email\\]",email)
					.replaceAll("\\[smallBeanName\\]",smallBeanName)
					.replaceAll("\\[telephone\\]",telephone)
					.replaceAll("\\[beanName\\]",beanName);
			return content;
		}else{
			return "";
		}
	}
	

	public static void main(String[] args) throws IOException {
		createBean();
		createDao();
		createSQLXml();
		createService();
		createServiceImpl();
		createWeb();
		createPage();
		//createTable();
		createTemplate();
	}
	
	
//		Properties properties = System.getProperties();
//		Enumeration<Object> keys =  properties.keys();
//		while (keys.hasMoreElements()) {
//			Object object = (Object) keys.nextElement();
//			System.out.println(object+"============="+properties.get(object));
//		}
	public static String getRoot(String path){
		return new File(System.getProperty("user.dir"),path).getAbsolutePath();
	}
	
	
	
	
}
