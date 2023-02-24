<%@ page import="com.cykj.bean.PcAdmin" %>
<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<% String path = request.getContextPath();
   PcAdmin admin = (PcAdmin) request.getSession().getAttribute("admin");
%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/all.css">
    <link rel="stylesheet" href="js/layui/css/layui.css">
    <link rel="stylesheet" href="css/homepage.css">
    <title>后台主页</title>
</head>

<body>
    <div class="father">
        <div class="hearder">
            <ul class="layui-nav" lay-filter="" style="background-color:#1e9eff2b;min-width: 800px;">
                <span class="title font" style="font-size:40px;">中国人的太阳心理健康与咨询中心</span>
                <li class="layui-nav-item adminname" style="position:absolute;">
                    <a href="javascript:;" style="font-size:15px;color:black;">欢迎您：<%=admin.getAdminname()%></a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">查看</a></dd>
                        <dd><a href="javascript:;" onclick="closeThis()">退出</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
        <div class="main">
            <div class="left">
                <ul class="layui-nav layui-nav-tree" lay-filter="test" id="leftNav"
                    style="height: 100%;background-color: rgba(0, 78, 151, 0.67);">
                </ul>
            </div>
            <div class="right">
                <iframe src="index" name="right" style="min-width:800px;"></iframe>
            </div>
        </div>
    </div>
</body>
<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/layui/layui.js"></script>
<script>
    var path = '<%=path%>';
    $(function () {
        $.ajax({
            url:'power/getlist',
            dataType:'json',
            success:function (data) {
                var html = '';
                $.each(data.list,function(i,el) {
                    if(el.prowerparent == 0){
                        html+= '<li class="layui-nav-item"> <a href="javascript:;" target="right">'+el.powername+'</a>';
                        html+='<dl class="layui-nav-child">';
                        $.each(data.list,function(index,item) {
                            if(item.prowerparent == el.powerid){
                                html+= '<dd><a href="'+item.powerurl+'" target="right">'+item.powername+'</a></dd>'
                            }
                        });
                        html+='</dl></li>'
                    }
                });
                $('#leftNav').html(html);
                layui.element.init()
            }
        })
    })
    function closeThis() {
        layer.confirm("确认退出当前账号？",function(){
            window.close();
            window.open('admin/exit','_blank');
        });
    }
</script>
</html>