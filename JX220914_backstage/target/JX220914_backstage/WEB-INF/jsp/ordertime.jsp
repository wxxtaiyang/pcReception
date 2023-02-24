<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/all.css">
    <link rel="stylesheet" href="js/layui/css/layui.css">
    <link rel="stylesheet" href="css/ordertime.css">
    <title>Document</title>
</head>
<body>
<div class="site-demo-laydate father">
    <h1>预约时间设置</h1>
    <div class="butt">
        <div class="layui-inline" id="test-n1"></div>
        <form class="layui-form " action="">
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <input type="checkbox" name="timeslot" value="1" lay-skin="primary" title="08:00-09:00">
                    <input type="checkbox" name="timeslot" value="2" lay-skin="primary" title="09:00-10:00">
                    <br>
                    <input type="checkbox" name="timeslot" value="3" lay-skin="primary" title="10:00-11:00">
                    <input type="checkbox" name="timeslot" value="4" lay-skin="primary" title="11:00-12:00">
                    <br>
                    <br>
                    <input type="checkbox" name="timeslot" value="5" lay-skin="primary" title="14:00-15:00">
                    <input type="checkbox" name="timeslot" value="6" lay-skin="primary" title="15:00-16:00">
                    <br>
                    <input type="checkbox" name="timeslot" value="7" lay-skin="primary" title="16:00-17:00">
                    <input type="checkbox" name="timeslot" value="8" lay-skin="primary" title="17:00-18:00">
                </div>
            </div>
            <br>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" type="button" onclick="ordertime()" lay-filter="formDemo">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/layui/layui.js"></script>
<script src="js/ordertime.js"></script>
<script>
    var dateValue;
    var laydate = layui.laydate;
    var form = layui.form;
    //直接嵌套显示
    laydate.render({
        elem: '#test-n1',
        position: 'static',
        min: 1,
        btns: [],
        ready: function (data) {
            dateValue = data.year + '-' + data.month + '-' + data.date;
            clickDate(dateValue);
        },
        done: function (value) {
            dateValue = value;
            clickDate(dateValue);
        }
    });
</script>
</html>
