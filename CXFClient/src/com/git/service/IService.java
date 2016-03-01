package com.git.service;

import java.util.HashMap;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

import com.git.entity.FileSources;
import com.git.entity.User;

@WebService
@BindingType(value = SOAPBinding.SOAP12HTTP_BINDING)
public interface IService {

	@WebMethod(operationName = "download")
	public FileSources download(@WebParam(name = "fileName") String fileName);

	@WebMethod(operationName = "upload")
	public String upload(@WebParam(name = "file") FileSources file);
	@WebMethod(operationName = "cxfservice")
	public Object CXFService(@WebParam(name = "params") HashMap<Object, Object> params);
	
	@WebMethod(operationName = "login")
	public String login(@WebParam(name = "login") HashMap<Object, Object> params);
	
	@WebMethod(operationName = "reg")
	public String reg(@WebParam(name = "reg") User u);
	
	@WebMethod(operationName = "downloadFile")
	public String downloadFile(@WebParam(name = "list") List list);
}
