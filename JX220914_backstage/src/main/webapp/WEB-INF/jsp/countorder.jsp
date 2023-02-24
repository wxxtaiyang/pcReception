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
    <style>
        .father {
            width: 80%;
            height: 80%;
            padding: 4% 10%;
            box-shadow: 1px 1px 200px white inset;
        }
    </style>
</head>

<body>
<div class="father">
    <h1 style="text-align:center;">渠道统计</h1>
    <div style="font-size:18px;margin: 20px 0;">查询条件：</div>
    <div style="text-align:center;" class="layui-form">
        <div class="layui-inline">
            <label class="layui-form-label">统计时间：</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="start" placeholder="yyyy-MM-dd">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label" style="width:14px">至</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="end" placeholder="yyyy-MM-dd">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label"></label>
            <button type="button" class="layui-btn layui-btn-normal" onclick="getData()">查询</button>
        </div>
    </div>
    <div style="text-align:right; margin: 20px 0;font-size: 18px;">
        <span>该段时间内总预约量为：</span>
        <span id="contextsum">303</span>
    </div>
    <div id="main" style="width:100%;height:50%;"></div>
</div>
</body>
<script src="js/layui/layui.js"></script>
<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/echarts.js"></script>
<script>
    var laydate = layui.laydate;
    //常规用法
    laydate.render({
        elem: '#start'
    });
    laydate.render({
        elem: '#end'
    });

    $(function () {
        getData();
    });

    function getData() {
        $.ajax({
            url:'order/countorder',
            data:{
                min:$('#start').val(),
                max:$('#end').val(),
            },
            type: 'post',
            dataType:'json',
            success:function (res) {
                var str = res.list;
                var num = new Array();
                var sum = 0;
                for (let i = 0; i < str.length; i++) {
                    for (let j = 0; j < res.data.length; j++) {
                        if(res.data[j].timename == str[i]){
                            num[i] = res.data[j].counts;
                            sum+=res.data[j].counts;
                            break;
                        }else {
                            num[i] = 0;
                        }
                    }
                }
                $('#contextsum').html(sum);
                changeChart(str,num)
            }
        })
    }

    function changeChart(str,num){
        var myChart = echarts.init(document.getElementById('main'));
        var option = {
            title: {
                text: ''
            },
            tooltip: {},
            legend: {
                data: ['']
            },
            xAxis: {
                data: str
            },
            yAxis: {},
            series: [
                {
                    name: '销量',
                    type: 'bar',
                    data: num
                }
            ]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    }
</script>

</html>
