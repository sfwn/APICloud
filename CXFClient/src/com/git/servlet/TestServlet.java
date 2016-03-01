package com.git.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;




public class TestServlet extends HttpServlet
{  
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException
	{
		  System.out.println("--------------------");
		  String account = request.getParameter("name1");
		  String file = request.getParameter("file");
		  System.out.println(file);
		  System.out.println("linjun:"+account);
		  JSONObject json = new JSONObject();  
          
	        JSONArray array = new JSONArray();  
	        
	        JSONObject member = null;
	        for (int i = 0; i < 3; i++) {  
	            member = new JSONObject();  
	            member.put("name", "xiaohua"+i);  
	            member.put("age", 20+i);  
	            array.add(member);  
	        }  
	          
	        json.put("account", account);
	        json.put("jsonArray", array);
	       //request.getRequestDispatcher("filedemo.jsp").forward(request, resp);  
		  PrintWriter pw = resp.getWriter();   
	        pw.print(json.toString());    
	  
	    
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{

				super.doPost(req, resp);
	}
	
}
