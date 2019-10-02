<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/18
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <a href="/test/find">dddd</a>

<%-- 文件的上传测试--%>


 <h3>Springmvc文件上传</h3>

 <form action="/test/fileUpLoad" method="post" enctype="multipart/form-data">
     选择文件：<input type="file" name="upload" /><br/>
     <input type="submit" value="上传" />
 </form>

 <form action="/test/fileDownLoad" method="post" enctype="multipart/form-data">
     <input type="submit" value="下载" />
 </form>

</body>
</html>
