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
        <div class="layui-input-inline" id="state">预约状态：已诊断</div>
        <div class="layui-input-inline" id="price">费用： 100元</div>
        <div class="layui-input-inline" id="adminname">咨询师：张三</div>
    </div>
    <div class="layui-form-item">
        <label class="layui-input-inline" style="width:auto;">问题描述：</label>
        <div class="layui-input-block text" id="problem">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-input-inline" style="width:auto;">诊断答复：</label>
        <div class="layui-input-block text" id="result">

        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-input-inline" style="width:auto;" id="resultDate">答复时间： 2022-10-11 20:00:00.0</label>
    </div>
    <div class="layui-form-item">
        <label class="layui-input-inline" style="width:auto;">评价内容</label>
        <div class="layui-input-block text" id="rate">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block" style="text-align:center;">
            <button type="button" class="layui-btn layui-btn-primary" onclick="closeOur()">返回</button>
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
    switch (obj.orderstate) {
        case 0:
            $('#state').html("预约状态：预约失败");
            break;
        case 1:
            $('#state').html("预约状态：已预约");
            break;
        case 2:
            $('#state').html("预约状态：已确认");
            break;
        case 3:
            $('#state').html("预约状态：已诊断");
            break;
        case 4:
            $('#state').html("预约状态：已评价");
            break;
        default:
            $('#state').html("预约状态：已终止");
            break;
    }
    $('#problem').html(obj.orderproblem);
    $('#result').html(obj.orderresult);
    $('#resultDate').html('答复时间： '+obj.resulttime);
    $('#rate').html(obj.orderrate);
    $('#username').html('咨询人： '+obj.username);

    $(function () {
        $.ajax({
            url:'admin/queryid',
            data:{
                adminid:obj.adminid
            },
            dataType:'json',
            success:function (res) {
                $('#price').html('费用： '+res.adminprice+'元');
                $('#adminname').html('咨询师： '+res.adminname);
            }
        })
    });

    function closeOur() {
        parent.layer.closeAll()
    }
</script>
</html>
