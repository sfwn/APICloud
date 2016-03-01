package com.git.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;








import com.git.dao.IUserDao;
import com.git.entity.User;
import com.git.util.Factory;

public class UserDao extends ABaseDao implements IUserDao
{

	public UserDao()
	{
	
	}
	public User login(HashMap params){
		Session session = Factory.factory.openSession();

	     //Transaction transaction = session.beginTransaction();
	     String _hql = "from User r where r.username=? and r.password =?";
	     List<User> list = session.createQuery(_hql).setParameter(0,params.get("username")).setParameter(1,params.get("password")).list();
			// List<RegConf> list=HibernateTool.select(session, _hql);
			/*Iterator<User> i = list.iterator();
			User rc = null;
			if (i != null)
			{
				while (i.hasNext())
				{
					rc = (User) i.next();
				}
				
			}*/
	     User u =null;
	     if(list!=null &&list.size()>0){
	    	 
	    	  u = list.get(0);
	     }
	    // transaction.commit();

	     session.close();
	     return u;
	}
	public String reg(User u){
		Session session = Factory.factory.openSession();

	     Transaction transaction = session.beginTransaction();
	    
	     
	     session.save(u);
	     String msg ="注册成功";
	     transaction.commit();

	     session.close();
	     return msg;
	}
	
	


}
