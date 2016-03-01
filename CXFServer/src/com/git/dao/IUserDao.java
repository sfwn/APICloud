package com.git.dao;

import java.util.HashMap;
import java.util.List;

import com.git.entity.User;

public interface IUserDao 
{
	//public List list(Object object);
	public String reg(User u);
	public User login(HashMap params);
}
