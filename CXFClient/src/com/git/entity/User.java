package com.git.entity;

public class User
{
	private String id;
	private String username;
	private String password;
	private Integer authority;
	private String tel;
	private String position;
	
	
	@Override
	public String toString()
	{
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", authority=" + authority + ", tel=" + tel
				+ ", position=" + position + "]";
	}


	public User(String id, String username, String password, Integer authority,
			String tel, String position)
	{
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.authority = authority;
		this.tel = tel;
		this.position = position;
	}


	public User(String username, String password, Integer authority,
			String tel, String position)
	{
		super();
		this.username = username;
		this.password = password;
		this.authority = authority;
		this.tel = tel;
		this.position = position;
	}


	public String getId()
	{
		return id;
	}


	public void setId(String id)
	{
		this.id = id;
	}


	public String getUsername()
	{
		return username;
	}


	public void setUsername(String username)
	{
		this.username = username;
	}


	public String getPassword()
	{
		return password;
	}


	public void setPassword(String password)
	{
		this.password = password;
	}


	public Integer getAuthority()
	{
		return authority;
	}


	public void setAuthority(Integer authority)
	{
		this.authority = authority;
	}


	public String getTel()
	{
		return tel;
	}


	public void setTel(String tel)
	{
		this.tel = tel;
	}


	public String getPosition()
	{
		return position;
	}


	public void setPosition(String position)
	{
		this.position = position;
	}


	public User()
	{
		
	}

}
