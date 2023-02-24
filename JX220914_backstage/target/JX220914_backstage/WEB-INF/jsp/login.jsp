<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<% String path = request.getContextPath();%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/all.css">
    <link rel="stylesheet" href="js/layui/css/layui.css">
    <link rel="stylesheet" href="css/login.css">
    <title>后台登录界面</title>
</head>
<body>
<div class="father">
    <div class="title font">
        中国人的太阳心理健康与咨询中心
    </div>
    <form action="javascript:void(0)" class="layui-form layui-form-pane" id="adminLogin">
        <div class="layui-form-item">
            <label class="layui-form-label"><i class="layui-icon layui-icon-username">账号</i></label>
            <div class="layui-input-block">
                <input type="text" name="adminacc" required lay-verify="required" placeholder="请输入账号"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><i class="layui-icon layui-icon-password">密码</i></label>
            <div class="layui-input-block">
                <input type="password" name="adminpwd" required lay-verify="required" placeholder="请输入密码"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><i class="layui-icon layui-icon-vercode">验证码</i></label>
            <div class="layui-input-block">
                <input type="text" name="code" required lay-verify="required" placeholder="请输入验证码"
                       autocomplete="off" class="layui-input">
                <div style="font-size:10px;height: 30px;line-height: 30px;">
                    <img src="code" width="100px" height="30px" id="identify">
                    <span onclick="changeCode()">看不清，换一张</span>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-inline">
                <button class="layui-btn" type="button" lay-filter="formDemo" onclick="login('<%=path%>')">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary" style="background-color:white;">重置</button>
            </div>
        </div>
    </form>
</div>
</body>
<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/layui/layui.js"></script>
<script src="js/login.js"></script>
</html>