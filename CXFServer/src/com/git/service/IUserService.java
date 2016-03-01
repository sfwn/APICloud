package com.git.service;

import java.util.HashMap;

import com.git.entity.User;

public interface IUserService
{
	public String reg(User u);
	public User login(HashMap params);
}
