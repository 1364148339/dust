<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/18
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/upload/layui/css/layui.css" media="all">
    <script src="${pageContext.request.contextPath}/upload/layui/layui.js"></script>
    <script>
            layui.use('table', function(){
            var table = layui.table;
            //第一个实例
            table.render({
                elem: '#userTable'
                ,id: 'userTable'
                ,url: '/test/userManagement/getAll'
                ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
                ,toolbar:true
                ,totalRow:true
                ,title:'用户数据表'
                ,limit: 5
                ,limits:[5,10,15,20]
                ,page: true //开启分页
                ,cols: [[ //表头
                {field: 'h_photo', title: '头像', width:80,height:80, fixed: 'left',templet:'<div><img style="height:30px;width:30px;border-radius:50%;line-height:40px!important;" src="{{ d.h_photo}}"></div>'}
                ,{field: 'id', title: '编号', width:80, sort: true}
                ,{field: 'n_name', edit:'text',title: '昵称'}
                ,{field: 'p_number', edit:'text',title: '手机号'}
                ,{field: 'pwd', edit:'text',title: '密码'}
                ,{field: 'autograph', edit:'text',title: '签名'}
                ,{field: 'integral', title: '积分', width: 80, sort: true}
                ,{field: 'email',edit:'text', title: '邮箱'}
                ,{type:  'checkbox'}
                ]]
                ,parseData: function(res){ //将原始数据解析成 table 组件所规定的数据
                    return {
                        "code": res.code, //解析接口状态
                        "msg": res.msg, //解析提示文本
                        "count": res.count, //解析数据长度
                        "data": res.data //解析数据列表
                    };
                }
            });

                //搜索
                var $ = layui.$, active = {
                    reload: function(){
                        var content = $('#searchContent');

                        //执行重载
                        table.reload('userTable', {
                            page: {
                                curr: 1 //重新从第 1 页开始
                            }
                            ,url: '/test/userManagement/search'
                            ,where: {
                                key: content.val()
                            }
                        }, 'data');
                    }
                };
                //复选框
                $('.SearchTable .layui-btn').on('click', function(){
                    var type = $(this).data('type');
                    active[type] ? active[type].call(this) : '';
                });

                //监听表格复选框选择
                table.on('checkbox(userTable)', function(obj){
                    console.log(obj)
                });

                //监听单元格编辑 修改
                table.on('edit(userTable)', function(obj){
                   // console.log(obj)
                     //var value = obj.value //得到修改后的值
                    var user = {};
                    var data = obj.data //得到所在行所有键值
                    user["id"] = data.id;
                    user["n_name"] = data.n_name;
                    user["p_number"] = data.p_number;
                    user["pwd"] = data.pwd;
                    user["autograph"] = data.autograph;
                    user["email"] = data.email;
                    $.ajax({
                        url:'/test/userManagement/edit',
                        contentType:'application/json;charset=utf-8',
                        type:'post',
                        //dataType : 'json',
                        data:JSON.stringify(user),
                        success:function () {
                           layer.alert('修改成功');
                        },
                        error:function () {
                            layer.alert('网络错误!');
                        }
                    });
                });
                var $ = layui.$, active = {
                    //增加
                    addData: function(){ //获取选中数据
                        layer.open({
                            type:'1',
                            title: '用户信息修改',
                            content:''
                        })

                    }
                    //删除
                    ,deleteData: function () {//删除获取选中数据
                        var checkStatus = table.checkStatus('userTable')
                            ,data = checkStatus.data;



                        if(data.length == 0) {
                            layer.alert('至少选择一条数据!');
                            return false;
                        }
                        var idItem = [];
                        for (var i=0;i<data.length;i++)
                        {
                            idItem[i] = data[i].id;
                        }

                        //询问框
                        layer.confirm('确认删除'+data.length+'条数据吗？', {
                            btn: ['确认','取消'] //按钮
                        },
                        function(){
                            $.ajax({
                                url:'/test/userManagement/delete',
                                contentType:'application/json;charset=utf-8',
                                type:'post',
                                dataType : 'json',
                                data: JSON.stringify({
                                    ids:idItem
                                }),
                                success:function (res) {
                                    if(res.code==0)
                                    {
                                        layer.msg(status.msg,{
                                            icon:1,
                                            offset: 'rb',//右下角弹出
                                            title: false,//不显示标题
                                            closeBtn: 0, //不显示关闭按钮
                                            shade: [0],//不显示遮罩层
                                            time: 2000, //2秒后自动关闭
                                            anim: 4,//动画效果
                                        });
                                        layui.table.reload('userTable'); //更新成功刷新当前数据表格 分页默认为当前页

                                    }else{
                                        layer.alert(res.msg);
                                    }
                                },
                                error:function () {
                                    layer.alert('网络错误!');
                                }
                            });
                        });
                    }
                };
        });
    </script>
</head>
<body>
<div>
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
        <legend>添加：普通用户</legend>
    </fieldset>
    <form class="layui-form" action="">
        <!--<diV class="layui-form-item">
            <button type="button" class="layui-btn" id="test1"><i class="layui-icon"></i>上传头像</button>
            <div class="layui-upload">
                <div class="layui-upload-list">
                    <img class="layui-upload-img" id="demo1">
                    <p id="demoText"></p>
                </div>
            </div>
        </div>-->
        <div class="layui-form-item">
            <label class="layui-form-label">昵称</label>
            <div class="layui-input-inline">
                <input type="text" name="username" lay-verify="required" placeholder="请输入昵称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">手机号</label>
            <div class="layui-input-inline">
                <input type="tel" name="phone" lay-verify="required|phone" placeholder="请输入手机号" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-inline">
                <input type="text" name="email" lay-verify="email" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input type="password" name="password" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<div>
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
        <legend>管理：用户资料</legend>
    </fieldset>
    <div class="SearchTable">
        <div class="layui-inline">
            <div class="layui-inline">
                <input class="layui-input" name="id" id="searchContent" autocomplete="off">
            </div>
            <button class="layui-btn" data-type="reload">查找</button>
        </div>
        <div class="layui-btn-group" style="float: right">
            <%--            <button class="layui-btn" data-type="addData">增加</button>--%>
            <button class="layui-btn" data-type="deleteData">删除</button>
        </div>
    </div>

    <table class="layui-hide" id="userTable" lay-filter="userTable"></table>
</div>

</body>
</html>
