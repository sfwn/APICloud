package com.git.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name="FileSources")  
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlSeeAlso({FileSources.class})  
public class FileSources implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String useName;
	private String fileName;// 文件名
	private String contentType;// 文件类型
	private DataHandler handler;//大型文件上传所需
    private Timestamp createTime;
   
	public FileSources() {
		super();
		
	}

	public Timestamp getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Timestamp createTime)
	{
		this.createTime = createTime;
	}

	public DataHandler getHandler() {
		return handler;
	}

	public void setHandler(DataHandler handler) {
		this.handler = handler;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getContentType() {
		return contentType;
	}

	public String getUseName()
	{
		return useName;
	}

	public void setUseName(String useName)
	{
		this.useName = useName;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public FileSources(String useName, String fileName, String contentType,
			Timestamp createTime)
	{
		super();
		this.useName = useName;
		this.fileName = fileName;
		this.contentType = contentType;
		this.createTime = createTime;
	}

	public FileSources(int id, String fileName, String contentType,
			DataHandler handler)
	{
		super();
		this.id = id;
		this.fileName = fileName;
		this.contentType = contentType;
		this.handler = handler;
	}

	

}
