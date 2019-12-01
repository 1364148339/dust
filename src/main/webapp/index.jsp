<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/18
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发起签到</title>
</head>
<body>
<h2>签到</h2>
<form action="${pageContext.request.contextPath}/myActivity/initiateSignIn" method="post" accept-charset="UTF-8">
    <p>活动id:<input type="text" name="a_id"></p>
    <p>签到码:<input type="text" name="check_num"></p>
    <P>签到持续时间:<input type="text" name="continued_time"></P>
    <input type="submit" value="发起签到">
</form>
<h2>后台</h2>
<a href="${pageContext.request.contextPath}/find">点击进入后台</a>
<%-- <a href="/test/find">dddd</a>--%>

<%-- 文件的上传测试--%>

<%-- <h3>Springmvc文件上传</h3>--%>

<%-- <form action="/test/fileUpLoad" method="post" enctype="multipart/form-data">--%>
<%--     选择文件：<input type="file" name="uploads" /><br/>--%>
<%--     选择文件：<input type="file" name="uploads" /><br/>--%>
<%--     选择文件：<input type="file" name="uploads" /><br/>--%>
<%--     <input type="submit" value="上传"/>--%>
<%-- </form>--%>

<%-- <form action="/test/fileDownLoad" method="post" enctype="multipart/form-data">--%>
<%--     <input type="submit" value="下载" />--%>
<%-- </form>--%>

</body>
</html>
