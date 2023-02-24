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
    <h1 style="text-align:center;">用户评估报表列表</h1>
    <table class="layui-hide" id="test" lay-filter="test"></table>

    <script type="text/html" id="toolbarDemo">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label>得分：</label>
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
                <label>得分：</label>
                <div class="layui-inline">
                    <div class="layui-input-inline">
                        <input type="number" autocomplete="off" id="minscore" class="layui-input">
                    </div>
                    <div class="layui-form-mid">-</div>
                    <div class="layui-input-inline">
                        <input type="number" autocomplete="off" id="maxscore" class="layui-input">
                    </div>
                </div>
                <button class="layui-btn layui-btn-sm" lay-event="chaxun" style="width:50px;">查询</button>
            </div>
        </div>
    </script>

    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="look">查看详情</a>
    </script>
</div>
</body>
<script src="js/layui/layui.js"></script>
<script src="js/jquery-1.7.2.min.js"></script>
<script>
    layui.use('table', function () {
        var table = layui.table;
        var laydate = layui.laydate;
        table.render({
            elem: '#test',
            url: 'report/query',
            where: {
                min: '',
                max: '',
                minscore: -1,
                maxscore: -1
            },
            toolbar: '#toolbarDemo', //开启头部工具栏，并为其绑定左侧模板
            title: '预约列表',
            cols: [[
                {field: 'createtime', title: '评估日期'},
                {field: 'username', title: '用户'},
                {field: 'fieldname', title: '领域'},
                {field: 'score', title: '得分'},
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
                    var socremin = $('#minscore').val();
                    var socremax = $('#maxscore').val();
                    if(socremin.length == 0){
                        socremin = -1
                    }
                    if(socremax.length == 0){
                        socremax = -1
                    }
                    table.reload('test',{
                        where: {
                            min: $('#startDate').val(),
                            max: $('#endDate').val(),
                            minscore: socremin,
                            maxscore: socremax
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
            //console.log(obj)
            if (obj.event === 'look') {
                layer.open({
                    type: 2,
                    skin: 'layui-layer-rim', //加上边框
                    area: ['600px', '550px'], //宽高
                    content: 'reportdetails',
                    success:function(layero, index) {
                        var body=layer.getChildFrame('body',index);
                        body.find('#result').html(data.reportresult);
                        body.find('#context').html(data.reportcontext);
                    }
                });
            }
        });
    });
</script>
</html>
