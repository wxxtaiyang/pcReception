<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/all.css">
    <link rel="stylesheet" href="js/layui/css/layui.css">
    <title>Document</title>
</head>

<body>
<div class="father">
    <h1 style="text-align:center;">预约列表</h1>
    <table class="layui-hide" id="test" lay-filter="test"></table>

    <script type="text/html" id="toolbarDemo">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label>预约日期：</label>
                <div class="layui-inline" id="begin">
                    <div class="layui-input-inline">
                        <input type="text" lay-event="startDate" autocomplete="off" id="startDate" class="layui-input"
                               placeholder="开始日期">
                    </div>
                    <div class="layui-form-mid">-</div>
                    <div class="layui-input-inline">
                        <input type="text" lay-event="endDate" autocomplete="off" id="endDate" class="layui-input"
                               placeholder="结束日期">
                    </div>
                </div>
            </div>
            <div class="layui-inline">
                <label>完成状态：</label>
                <div class="layui-inline">
                    <select name="city" lay-verify="required" id="state">
                        <option value="-1"></option>
                        <option value="0">预约失败</option>
                        <option value="1">已预约</option>
                        <option value="2">已确认</option>
                        <option value="4">已评价</option>
                        <option value="20">已终止</option>
                    </select>
                </div>
                <button class="layui-btn layui-btn-sm" lay-event="chaxun" style="width:50px;">查询</button>
            </div>
        </div>
    </script>

    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="look">查看详情</a>
        {{# if(d.orderstate == 1){ }}
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="sure">确认预约</a>
        {{# } }}
        {{# if(d.orderstate == 2){ }}
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="diagnosis">诊断</a>
        {{# } }}
    </script>
    <script type="text/html" id="orderState">
        <span>
            {{# if(d.orderstate == 0){ }}
            预约失败
            {{# } else if(d.orderstate == 1) { }}
            已预约
            {{# } else if(d.orderstate == 2) { }}
            已确认
            {{# } else if(d.orderstate == 3) { }}
            已诊断
            {{# } else if(d.orderstate == 4){ }}
            已评价
            {{# } else{ updateState(d)}}
            已终止
            {{# } }}
        </span>
    </script>
</div>
</body>
<script src="js/layui/layui.js"></script>
<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/userorder.js"></script>
<script>
    layui.use('table', function () {
        var table = layui.table;
        var laydate = layui.laydate;
        table.render({
            elem: '#test',
            url: 'order/userorder',
            where: {
                min: '',
                max: '',
                state: -1
            },
            toolbar: '#toolbarDemo', //开启头部工具栏，并为其绑定左侧模板
            title: '预约列表',
            cols: [[
                {field: 'ordertime', title: '预约时间'},
                {field: 'username', title: '用户'},
                {field: 'fieldname', title: '领域'},
                {field: 'orderproblem', title: '咨询问题'},
                {field: 'orderstate', title: '咨询状态', templet: '#orderState'},
                {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 200}
            ]],
            limit:2,
            limits:[2,5,10,15,20,30,50],
            page: true,
        });

        //头工具栏事件
        table.on('toolbar(test)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'endDate':
                    laydate.render({
                        elem: '#endDate'
                    });
                    break;
                case 'startDate':
                    laydate.render({
                        elem: '#startDate'
                    });
                    break;
                case 'chaxun':
                    table.reload('test',{
                        where: {
                            min: $('#startDate').val(),
                            max: $('#endDate').val(),
                            state: $('#state').val()
                        },
                        page:{
                            curr:1
                        }
                    });
                    break;
            }
        });

        //监听行工具事件
        table.on('tool(test)', function (obj) {
            var data = obj.data;
            console.log(obj)
            if (obj.event === 'look') {
                lookOeder(data);
            }else if (obj.event === 'sure') {
                layer.confirm("确认预约？",function(){
                    sureOrder(data,table);
                });
            }else if (obj.event === 'diagnosis') {
                diagnosisOrder(data,table)
            }
        });
    });
    function updateState(obj) {
        if(obj.orderstate == 5 || obj.orderstate == 10){
            layer.msg("有预约被终止了");
            var state = obj.orderstate+10;
            $.ajax({
                url:'order/state',
                data:{
                    orderid:obj.orderid,
                    state:state
                },
                dataType:'json',
                success:function (res) {

                }
            })
        }
    }
</script>
</html>
