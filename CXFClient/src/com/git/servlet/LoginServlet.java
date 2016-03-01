package com.git.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.git.util.FileUtil;


public class LoginServlet extends HttpServlet
{

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		
		JSONObject json = new JSONObject();  
        JSONArray array = new JSONArray();  
        PrintWriter pw = resp.getWriter();   
		 req.setCharacterEncoding("utf-8");  //设置编码  
		 resp.setContentType("text/html;charset=utf-8");
		 String username= req.getParameter("username");
  		 String password =req.getParameter("password");
  		 if(username ==null || username.equals("")){
  			 json.put("msg", "用户名不能为空");
 	         pw.print(json.toString());
 	         return;
  		 }
  		 if(username ==null || username.equals("")){
  			 json.put("msg", "密码不能为空");
 	         pw.print(json.toString());  
 	         return;
  		 }  
  		 HashMap params = new HashMap();
  		 params.put("username", username);
  		 params.put("password", password);
	       //调用数据库
  		String msg = FileUtil.client.login(params);
  		 
  		 json.put("msg",msg);
  		pw.print(json.toString());
	          
	  
	    
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{

				super.doPost(req, resp);
	}
	
}
