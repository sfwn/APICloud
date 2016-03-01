package com.git.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.git.dao.IBaseDao;
import com.git.util.Factory;

public abstract class ABaseDao implements IBaseDao
{

	public  List list(Object object){
		List list = new ArrayList();
		String a =object.getClass().toString();
		System.out.println(a);
		String[] str =  a.split("\\.");
		System.out.println(str[str.length-1]);
		Session session = Factory.factory.openSession();
	     String _hql = "from  "+str+"  r where 1=1";
	      list = session.createQuery(_hql).list();
	      session.close();
		return list;
	}
}
