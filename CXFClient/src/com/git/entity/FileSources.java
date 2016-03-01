package com.git.entity;

import java.io.Serializable;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.soap.MTOM;

@XmlRootElement(name="FileSources")  
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlSeeAlso({FileSources.class})  
@MTOM
public class FileSources implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String useName;
	private String fileName;// 文件名
	private String contentType;// 文件类型
	private DataHandler handler;//大型文件上传所需

	public FileSources() {
		super();
		
	}

	public String getUseName()
	{
		return useName;
	}

	public void setUseName(String useName)
	{
		this.useName = useName;
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

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}
