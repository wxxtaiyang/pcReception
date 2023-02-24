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
</head>
<style>
    .layui-table-cell{
        height:50px;
        line-height: 50px;
    }
    .layui-input{
        height: 32px!important;
    }
    .layui-input-inline{
        vertical-align: unset;
    }
</style>
<body>
<table class="layui-hide" id="adminlist" lay-filter="adminlist"></table>

<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <input class="layui-layer-input layui-btn-sm" id="name" lay-event="name" style="margin-right:20px"
               placeholder="请输入昵称">
        <div class="layui-input-inline layui-btn-sm" style="margin-right:20px">
            <select id="state">
                <option value="-1">状态选择</option>
                <option value="1">启用</option>
                <option value="0">禁用</option>
            </select>
        </div>
        <button class="layui-btn layui-btn-sm" lay-event="getCheckData" style="margin-right:20px">查询</button>
        <button class="layui-btn layui-btn-sm" lay-event="addData">添加</button>
    </div>
</script>
<script type="text/html" id="adminImage">
    <img src="{{d.adminimg}}" alt="该管理员图片失效" style="width: 40px;height: 40px">
</script>


<script type="text/html" id="adminState">
    <input type="checkbox" name="state" title="{{d.adminstate==1?'启用':'禁用'}}" lay-filter="state"
           value="{{d.adminid}}" {{d.adminstate==1?'checked':'' }}>
</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">重置密码</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</body>
<script src="js/layui/layui.js"></script>
<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/adminpage.js"></script>
<script>
    layui.use('table', function () {
        var table = layui.table;
        table.render({
            elem: '#adminlist',
            url: 'admin/list',
            method:'post',
            where:{state:-1},
            toolbar: '#toolbarDemo',
            cols: [[
                { field: 'adminid', width: 70, title: 'ID', sort: true }
                , { field: 'adminname', width: 120, title: '名称' }
                , { field: 'rolename', width: 120, title: '角色'}
                // , { field: 'adminacc', width: 100, title: '账号' }
                , { field: 'adminimg', width: 80,height:'40px', title: '头像',toolbar:'#adminImage'}
                , { field: 'socialcontext', title: '社会背景' }
                , { field: 'adminschool',width: 120, title: '毕业院校' }
                , { field: 'admintitle',width: 80, title: '职称' }
                , { field: 'adminstate', width: 110, title: '状态',toolbar:'#adminState'}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
            ]],
            page: true,
            limits: [2, 5, 10, 20, 50],
            limit: 2
        });
    });
</script>

</html>

