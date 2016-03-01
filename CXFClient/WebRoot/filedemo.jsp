<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在此处插入标题</title>
</head>
<body>
      
    用户名：${requestScope.fileName } <br/>  
    文件：${requestScope.contentType }<br/> 
    结果：${requestScope.return }<br/> 
    <!-- 把上传的图片显示出来 --> 
    <div style="background-image: url('${requestScope.file1 }');">
     <img  src="${requestScope.file1 }" />
    
    </div> 
</body>
</html>