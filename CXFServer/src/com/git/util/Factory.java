package com.git.util;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Factory
{

	public Factory()
	{
		// TODO 自动生成的构造函数存根
	}
	public static ApplicationContext context = new ClassPathXmlApplicationContext(

            "cxf-servlet.xml");  

	public static SessionFactory factory = (SessionFactory) context   

            .getBean("sessionFactory");   
    //spring直接帮我们加载了hibernate.cgf.xml文件，让我们直接操作了sessionfactory。其实下面的事务管理我们也可以通过spring的来管理的。但是由于没写一个一个代理类所以就没写。
}
