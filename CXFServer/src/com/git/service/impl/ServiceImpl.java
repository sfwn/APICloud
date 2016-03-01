package com.git.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.jws.WebService;

import com.git.dao.IUserDao;
import com.git.entity.FileSources;
import com.git.entity.User;
import com.git.service.IService;
import com.git.service.IUserService;

@WebService(endpointInterface = "com.git.service.IService")
public class ServiceImpl implements IService{

    private IUserService userService;
    private IUserDao userDao;
    
	public IUserDao getUserDao()
	{
		return userDao;
	}

	public void setUserDao(IUserDao userDao)
	{
		this.userDao = userDao;
	}

	public IUserService getUserService()
	{
		return userService;
	}

	public void setUserService(IUserService userService)
	{
		this.userService = userService;
	}

	@Override
	public String upload(FileSources file) {
		DataHandler handler = file.getHandler();
		InputStream is = null;
		OutputStream os = null;
		try {
			System.out.println("文件开始上传。。。。。。");
			is = handler.getInputStream();
			/*os = new FileOutputStream("F:/" + file.getFileName() + "."
					+ file.getContentType());*/
			String fileName =file.getFileName() + "."
					+ file.getContentType();
			System.out.println("文件名称-----："+fileName);
			String path = ServiceImpl.createDir(fileName, file.getUseName());
			os = new FileOutputStream(path);
			int n = 0;
			byte[] b = new byte[1024];
			while ((n = is.read(b)) != -1) {
				os.write(b, 0, n);
			}
			os.flush();
			System.out.println("文件上传成功~");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return "上传成功！";
	}

	@Override
	public FileSources download(String fileName) {
		FileSources file =new FileSources();
		
		String url ="f:/"+fileName+".jpg";
		file.setFileName(fileName);
		file.setContentType("jpg");
		try {
			DataSource ds = new FileDataSource(new File(url));
			file.setHandler(new DataHandler(ds));
			return file;
		} catch (Exception e) {
			
			return null;
		}
		
	}

	@Override
	public Object CXFService(HashMap<Object, Object> params)
	{
		
		return params;
	}

	@Override
	public String login(HashMap<Object, Object> params)
	{
		User u=userService.login(params);
		if(u==null){
			
			return "登陆失败";
		}
		return "登陆成功";
	}

	@Override
	public String reg(User u)
	{
		String msg=userService.reg(u);
		return msg;
	}

	@Override
	public String downloadFile(List list)
	{
		String url  = "E:\\GIT\\CXFServer\\WebRoot\\upload\\1.jpg";
		return url;
	}
    //在指定文件夹下生成文件夹
	public static String createDir(String fileName,String userNameDir){
		//系统指定 的文件夹
		
	   String sourcePath =System.getProperty("user.home")+"\\"+"upload";
	   File f = new File(sourcePath);  
	    // 目录已存在创建文件夹  
	    if (!f.exists()) {  
	        f.mkdir();// 目录不存在的情况下，会抛出异常  
	        System.out.println("创建文件目录成功");
	    }  
	   System.out.println("系统指定 的文件夹:"+sourcePath);
	   //创建客户目录
		String filePath = sourcePath +"\\"+ userNameDir;  
		
	    File fp = new File(filePath);  
	    // 目录已存在创建文件夹  
	    if (!fp.exists()) {  
	        fp.mkdir();// 目录不存在的情况下，会抛出异常  
	        System.out.println("创建个人指定目录成功");
	    }  
	    
	    //文件路径
	    String path = filePath+"\\"+fileName;
	    System.out.println("上传文件全名称："+path);
		return path;
	}
	
	//获取指定文件夹下的指定文件
	public static String getSingleFile( String filename,String folder) throws FileNotFoundException, IOException
			 {
		//系统指定 的文件夹
		String sourcePath =System.getProperty("user.home")+"\\"+folder;
		System.out.println("--------"+sourcePath);
		List<String> files = getFiles(sourcePath);
		
		if (files.contains(filename)) {
			//File file = new File(sourcePath + "\\" + filename);
			//Stem.out.println("我在这儿呢！");
			String singleFile =sourcePath+"\\"+ filename;
		 return singleFile;
		} else {
			System.out.println("查找的名为：" + filename + "不存在！！！");
			return null;
		}
	}
	public static List<String> getFiles(String sourcePath)
			throws FileNotFoundException, IOException {
		ArrayList<String> list = new ArrayList<String>();
		//System.out.println(sourcePath);
		File dir = new File(sourcePath);
		File files[] = dir.listFiles();
		for (File f : files) {
			
				//获取文件名
				list.add(f.getName());
			
		}
		//System.out.println(list);
		return list;
	}
}
