package com.git.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.git.entity.FileSources;
import com.git.entity.User;
import com.git.util.FileUtil;


public class RegServlet extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		
		JSONObject json = new JSONObject();  
        //JSONArray array = new JSONArray();  
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
	       //调用数据库
  		 User u = new User();
  		 u.setUsername(username);
  		 u.setPassword(password);
  		String msg = FileUtil.client.reg(u);
 		 
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
