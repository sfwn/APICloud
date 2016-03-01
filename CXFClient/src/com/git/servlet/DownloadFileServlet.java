package com.git.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
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
import com.git.util.FileUtil;


public class DownloadFileServlet extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		 req.setCharacterEncoding("utf-8");  //设置编码  
		 resp.setContentType("text/html;charset=utf-8");
		
	        JSONObject json = new JSONObject();  
	          
	        //JSONArray array = new JSONArray();  
	        
	        String userName = req.getParameter("username");
	        String fileName = req.getParameter("filename");
	        String sourcePath =System.getProperty("user.home")+"\\"+"upload";
	 	   System.out.println("系统指定 的文件夹:"+sourcePath);
	 	   //创建客户目录
	 		//String filePath = sourcePath +"\\"+ userName+"\\"+fileName;  
	 	     String filePath ="http://10.100.51.125:8080/CXFClient/upload/1.jpg";
	       json.put("path", filePath);
	       // List list = new ArrayList();
	       // FileSources msg = FileUtil.client.download(userName+":"+fileName);
		    PrintWriter pw = resp.getWriter();   
	        pw.print(json);   
        
	        //req.getRequestDispatcher("filedemo.jsp").forward(request, resp);  
	          
	  
	    
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{

				super.doPost(req, resp);
	}
	
}
