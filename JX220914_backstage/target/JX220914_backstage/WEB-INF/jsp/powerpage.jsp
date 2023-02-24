<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="css/all.css">
    <link rel="stylesheet" href="js/layui/css/layui.css">
    <link rel="stylesheet" href="css/powerpage.css">
</head>

<body>
<div class="father">
    <div class="left">
        <ul id="role">
<%--            <li onclick="liClick(this)" value="3">咨询师</li>--%>
<%--            <li onclick="liClick(this)" value="2">管理员</li>--%>
        </ul>
    </div>
    <div class="right">
        <div id="transfer"></div>
        <div class="layui-btn-container" style="margin-top:20px;">
            <button type="button" class="layui-btn layui-btn-radius" transfer-demo="getTransferData">确定</button>
            <button type="button" class="layui-btn layui-btn-normal layui-btn-radius" transfer-demo="reload">取消</button>
        </div>
    </div>

</div>
<script src="js/layui/layui.js"></script>
<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/transfer.js"></script>

<script>
    var value = [];
    var data = [];
    var transfer = new Transfer();
    var roleid = 0;
    //显示搜索框
    transfer.render({
        elem: '#transfer',
        // 未选数据
        data: data,
        title: ['未拥有权限', '已拥有权限'],
        // 已选择数据，默认在右边
        value:value,
        // 菜单二级全展开
        spread: true,
    });
    var util = layui.util;
    //按钮事件
    util.event('transfer-demo', {
        getTransferData: function () {
            if(roleid === 0){
                layer.msg("请先选择角色");
            }
            var list = new Array();
            for (let i = 0; i < transfer.rightTree.length; i++) {
                list.push(transfer.rightTree[i].value);
                for (let j = 0; j < transfer.rightTree[i].children.length; j++) {
                    list.push(transfer.rightTree[i].children[j].value);
                }
            }
            $.ajax({
                url:'power/updatePower',
                data:{
                    roleid:roleid,
                    arr:list
                },
                dataType:'json',
                success:function (d) {
                    layer.msg(d.msg)
                    value = transfer.rightTree;
                    data = transfer.leftTree;
                }
            })
        },
        reload: function () {
            //重载实例
            transfer.reload();
        }
    });
</script>
</body>
<script src="js/powerpage.js"></script>
</html>
