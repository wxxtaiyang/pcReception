<%@ page import="com.cykj.bean.PcAdmin" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<%
    String path = request.getContextPath();
    PcAdmin admin = (PcAdmin) request.getSession().getAttribute("admin");
    System.out.println(admin);
%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/all.css">
    <link rel="stylesheet" href="js/layui/css/layui.css">
    <link rel="stylesheet" href="css/acpadminpage.css">
</head>
<body>
<div class="father">
    <div class="title">资金账户</div>
    <span class="words" id="balance">余额： 2234元</span><br>
    <span class="words">业务收入情况：</span>
    <table class="layui-hide" id="acpadmin" lay-filter="acpadmin"></table>
    <div class="returns">
        <a class="layui-btn layui-btn-fluid layui-btn-normal" href="index" style="width:200px">返回</a>
    </div>
</div>


<script type="text/html" id="capsort">
    <span name="capsort">{{ d.capsort == 1 ? '咨询':'预约'}}</span>
</script>
</body>
<script src="js/layui/layui.js"></script>
<script src="js/jquery-1.7.2.min.js"></script>
<script>
    layui.use('table', function () {
        var table = layui.table;
        table.render({
            elem: '#acpadmin',
            url: 'acpadmin/list',
            method:'post',
            cols: [[
                { field: 'createtime', title: '发生时间' }
                , { field: 'username',  title: '客户名称' }
                , { field: 'capsort', title: '咨询/预约',toolbar:'#capsort'}
                , { field: 'capprice', title: '金额(元)'}
            ]],
            page: false,
            done:function () {
                $('#balance').html('余额： <%=admin.getAdminbalance()%>元');
            }
        });
    });
</script>
</html>

