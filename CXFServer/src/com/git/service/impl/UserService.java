package com.git.service.impl;

import java.util.HashMap;

import org.omg.CORBA.Policy;
import org.omg.PortableServer.IdUniquenessPolicyOperations;
import org.omg.PortableServer.IdUniquenessPolicyValue;

import com.git.dao.IUserDao;
import com.git.dao.impl.UserDao;
import com.git.entity.User;
import com.git.service.IUserService;

public class UserService implements IUserService{
	
	 private IUserDao userDao;
	    
		public IUserDao getUserDao()
		{
			return userDao;
		}

		public void setUserDao(IUserDao userDao)
		{
			this.userDao = userDao;
		}

	@Override
	public String reg(User u)
	{
		
		return userDao.reg(u);
	}

	@Override
	public User login(HashMap params)
	{
		// TODO 自动生成的方法存根
		return userDao.login(params);
	} 

	
}
