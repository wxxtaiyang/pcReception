<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/all.css">
    <link rel="stylesheet" href="js/layui/css/layui.css">
    <title>Document</title>
</head>
<style>
    .father {
        width: 660px;
        margin: 0 auto;
        box-shadow: 1px 1px 200px white inset;
        padding: 30px 20px;
        border-radius: 50px;
    }

    h1 {
        text-align: center;
        margin-bottom: 30px;
    }

    .text {
        word-break: break-all;
    }
</style>

<body>
<div class="father layui-form">
    <h1>预约详情</h1>
    <div class="layui-form-item">
        <div class="layui-input-inline" id="username">咨询人：张三</div>
        <div class="layui-input-inline" id="field">领域：亲子关系</div>
        <div class="layui-input-inline" id="time" style="width: 250px;;">预约时间： 2022-10-11 20:00:00.0</div>
    </div>

    <div class="layui-form-item">
        <label class="layui-input-inline" style="width:auto;">问题描述：</label>
        <div class="layui-input-block text" id="problem">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-input-inline" style="width:auto;">诊断答复：</label>
        <div class="layui-input-block text" id="result">
            <textarea type="text" name="pro" id="pro" class="layui-input" style="min-height:100px;"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block" style="text-align:center;">
            <button type="button" class="layui-btn" onclick="closeOur()">提交</button>
        </div>
    </div>
</div>
</body>
<script src="js/layui/layui.js"></script>
<script src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" th:inline="javascript">
    /*<![CDATA[*/
    ctxPath = /*[[@{/}]]*/ '';
    /*]]>*/
</script>
<script>
    var url = window.location.href;
    var obj = JSON.parse(decodeURI(url.split("=")[1]));
    // console.log(obj);
    $('#field').html("领域："+obj.fieldname);
    switch (obj.timeslot) {
        case 1:
            $('#time').html("预约时间： "+obj.ordertime+" 08:00");
            break;
        case 2:
            $('#time').html("预约时间： "+obj.ordertime+" 09:00");
            break;
        case 3:
            $('#time').html("预约时间： "+obj.ordertime+" 10:00");
            break;
        case 4:
            $('#time').html("预约时间： "+obj.ordertime+" 11:00");
            break;
        case 5:
            $('#time').html("预约时间： "+obj.ordertime+" 14:00");
            break;
        case 6:
            $('#time').html("预约时间： "+obj.ordertime+" 15:00");
            break;
        case 7:
            $('#time').html("预约时间： "+obj.ordertime+" 16:00");
            break;
        case 8:
            $('#time').html("预约时间： "+obj.ordertime+" 17:00");
            break;
    }
    $('#problem').html(obj.orderproblem);
    $('#username').html('咨询人： '+obj.username);

    function closeOur() {
        $.ajax({
            url:'order/result',
            data:{
                orderid:obj.orderid,
                result:$('#pro').val()
            },
            type:'post',
            dataType: 'json',
            success:function (res) {
                if(res.flag){
                    layer.msg(res.msg);
                    setTimeout(function () {
                        parent.layer.closeAll();
                    },500);
                }else{
                    layer.msg(res.msg,{icon:2})
                }
            }
        });
    }
</script>
</html>
