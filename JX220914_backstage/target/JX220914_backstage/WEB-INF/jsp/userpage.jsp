<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/all.css">
    <link rel="stylesheet" href="js/layui/css/layui.css">
    <style>
        .layui-input{
            height: 32px!important;
        }
    </style>
</head>

<body>
<table class="layui-hide" id="userlist" lay-filter="userlist"></table>

<script type="text/html" id="toolbarDemo">
    <div>
        <input class="layui-layer-input layui-btn-sm" id="name" lay-event="name" style="margin-right:20px"
               placeholder="请输入昵称">
        <div class="layui-input-inline layui-btn-sm" style="margin-right:20px">
            <select id="ustate">
                <option value="-1">状态选择</option>
                <option value="1">启用</option>
                <option value="0">禁用</option>
            </select>
        </div>
        <button class="layui-btn layui-btn-sm" lay-event="getCheckData">查询</button>
    </div>
</script>

<script type="text/html" id="userSex">
    <sapn type="" name="sex">{{ d.usersex == 1 ? '男':'女'}}</sapn>
</script>

<script type="text/html" id="userState">
    <input type="checkbox" name="state" title="{{d.state==1?'启用':'禁用'}}" lay-filter="state"
           value="{{d.userid}}" {{ d.state== 1 ? 'checked':''}} >
</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">重置密码</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</body>
<script src="js/layui/layui.js"></script>
<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/userpage.js"></script>
<script>
    layui.use('table', function () {
        var table = layui.table;
        table.render({
            elem: '#userlist',
            url: 'user/vaguequery',
            method: 'post',
            toolbar: '#toolbarDemo',
            where:{state:-1},
            cols: [[
                {field: 'userid', width: 70, title: 'ID', sort: true}
                , {field: 'username', width: 80, title: '用户名'}
                // , { field: 'useracc', width: 100, title: '账号' }
                , {field: 'usersex', width: 80, title: '性别', toolbar: '#userSex'}
                , {field: 'userage', title: '年龄', width: 80, sort: true}
                , {field: 'userphone', title: '电话'}
                , {field: 'address', title: '地址'}
                , {field: 'state', width: 110, title: '状态', toolbar: '#userState'}
                , {field: 'createtime', width: 180, title: '创建时间', sort: true}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 150}
            ]],
            page: true,
            limits: [2, 5, 10, 20, 50],
            limit: 2
        });
    });
</script>

</html>
