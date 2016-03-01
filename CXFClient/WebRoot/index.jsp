<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <base href="<%=basePath%>">  
      
    <title>My JSP 'fileupload.jsp' starting page</title>  
      
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
    <!-- 
    <link rel="stylesheet" type="text/css" href="styles.css"> 
    -->  
     <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
  </head>
  <script type="text/javascript">
   function bu(){
	   alert("你好");
	   var fd = new FormData();
		
		fd.append("upfile", $("#upfile").get(0).files[0]);
	   $.ajax({
           cache: true,
           type: "POST",
           url: "fileServlet",
           processData: false,
   		   contentType: false,
           data: fd,// 你的formid
           async: false,
           error: function(request) {
               alert("Connection error");
           },
           success: function(data) {
               $("#commonLayout_appcreshi").parent().html(data);
               alert("成功！！！");
           }
       });
	   alert("结束")
   }
  </script>  
<body>
     <form action="fileServlet" enctype="multipart/form-data" method="post"  >
     	<table>
         <tr>
         	<td>fileName:</td>
         	<td><input type="text" name="fileName"/></td>
         </tr>               
          <tr>
         	<td>contentType</td>
         	<td><input type="text" name="contentType"/></td>
         </tr>
          <tr>
         	<td>文件：</td>
         	<td><input type="file" name="file1"/></td>
         </tr>
     	 <tr>
     	   <td colspan="2"><input type="submit" value="提交"/></td>
     	 </tr>
     	</table>
     </form> 
     
     <!--  <form id="yourformid" enctype="multipart/form-data" method="post"  >
     	<table>
         <tr>
         	<td>fileName:</td>
         	<td><input type="text" name="fileName"/></td>
         </tr>
          <tr>
         	<td>contentType</td>
         	<td><input type="text" name="contentType"/></td>
         </tr>
          <tr>
         	<td>文件：</td>
         	<td><input id="upfile" type="file" name="file1"/></td>
         </tr>
     	 <tr>
     	   <td colspan="2"><input type="button" value="提交" onclick="bu()"/></td>
     	 </tr>
     	</table>
     </form> -->
     <div id="commonLayout_appcreshi"></div>
     <div id="common"></div>
</body>
</html>