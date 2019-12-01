<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/18
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <script>
        function showdiv(number){
            for(var i=1;i<=7;i++){
                if(i==number){
                    var obj=document.getElementById("info"+number);
                    obj.style.display="";
                }else{
                    var obj=document.getElementById("info"+i);
                    obj.style.display="none";
                }
            }
        }
    </script>
</head>
<body>
<link type="text/css" rel="styleSheet"  href="${pageContext.request.contextPath}/upload/css/admin/home.css" />
<div class="kelei_main">

    <div class="kelei_left" >
        <div class="kelei_top" align="center">
            <div>
                <img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1574082483756&di=ac8245c4601e1f91132dcd4fb471c3ae&imgtype=0&src=http%3A%2F%2Fcdn.duitang.com%2Fuploads%2Fitem%2F201501%2F25%2F20150125093346_5eJva.thumb.700_0.jpeg" width="70%" height="70%" >
                <p>昵称:
                    <span>放生</span>
                </p>
            </div>
        </div>
        <div class="kelei_menu_row1">
            <div class="kelei_menu_name" onclick="showdiv(1)">
                <a href="#" >首页</a>
            </div>
            <!--<div class="kelei_menu_value" id="detail_title">
                <div onmouseover="showdiv(1)">
                    <a href="#">用户数据</a>
                </div>
                <div onmouseover="showdiv(2)">
                    <a href="#">下拉测试菜单二</a>
                </div>
                <div onmouseover="showdiv(3)">
                    <a href="#">下拉测试菜单三</a>
                </div>
                <div onmouseover="showdiv(4)">
                    <a href="#">下拉测试菜单四</a>
                </div>
                <div onmouseover="showdiv(5)">
                    <a href="#">下拉测试菜单五</a>
                </div>
            </div>-->
        </div>
        <div class="kelei_menu_row2" >
            <div class="kelei_menu_name"onclick="showdiv(2)">
                <a href="#" >用户管理</a>
            </div>
        </div>
        <div class="kelei_menu_row3" >
            <div class="kelei_menu_name" onclick="showdiv(3)">
                <a href="#" >爱心人士管理</a>
            </div>
        </div>
        <div class="kelei_menu_row4" >
            <div class="kelei_menu_name" onclick="showdiv(4)">
                <a href="#" >志愿者管理</a>
            </div>
        </div>
        <div class="kelei_menu_row5" >
            <div class="kelei_menu_name" onclick="showdiv(5)">
                <a href="#" >公益组织管理</a>
            </div>
        </div>
        <div class="kelei_menu_row6" >
            <div class="kelei_menu_name" onclick="showdiv(6)">
                <a href="#" >切换账号</a>
            </div>
        </div>
        <div class="kelei_menu_row7" >
            <div class="kelei_menu_name" onclick="showdiv(7)">
                <a href="#" >退出</a>
            </div>
        </div>
    </div>


    <div class="kelei_center">

        <div id="detail_info">
            <div id="info1" class="detail_info_same" style="display: block">
                首页
            </div>
            <div id="info2" class="detail_info_same" style="display: none">
                <jsp:include page="user.jsp"/>
            </div>
            <div id="info3" class="detail_info_same" style="display: none">
                <jsp:include page="luser.jsp"/>
            </div>
            <div id="info4" class="detail_info_same" style="display: none">
                <jsp:include page="volunteer.jsp"/>
            </div>
            <div id="info5" class="detail_info_same" style="display: none">
                <jsp:include page="organization.jsp"/>
            </div>
            <div id="info6" class="detail_info_same" style="display: none">
                切换账号
            </div>
            <div id="info7" class="detail_info_same" style="display: none">
                退出
            </div>
        </div>
    </div>
    <div class="kelei_down" align="center">
        <p>微尘公益</p>
    </div>
</div>
</body>
</html>