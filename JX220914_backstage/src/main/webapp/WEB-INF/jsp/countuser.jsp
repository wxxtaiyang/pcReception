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
        #weeks,
        #months,
        #years {
            color: black !important;
        }
    </style>
</head>

<body>
<div class="father">
    <h1 style="text-align:center;">用户统计</h1>
    <div style="font-size:18px;margin: 20px 0;">统计：</div>
    <div style="text-align:center;">
        <button class="layui-btn layui-btn-primary layui-border-green" onclick="weeks()" id="weeks"
                style="background:#00968880;">本周</button>
        <button class="layui-btn layui-btn-primary layui-border-blue" onclick="months()" id="months">本月</button>
        <button class="layui-btn layui-btn-primary layui-border-orange" onclick="years()" id="years">近半年</button>
    </div>
    <div style="text-align:right; margin: 20px 0;font-size: 18px;">
        <span id="contextnum">本周总新增用户数：</span>
    </div>
    <div id="main" style="width:100%;height:50%;"></div>
</div>
</body>
<script src="js/layui/layui.js"></script>
<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/echarts.js"></script>
<script>

    function weeks() {
        $('#weeks').css('background', '#00968880');
        $('#months').css('background', '');
        $('#years').css('background', '');
        $.ajax({
            url:'user/usercount',
            data:{type:1},
            dataType:'json',
            success:function (res) {
                var sum = 0;
                var num = new Array();
                var str = ['星期一', '星期二', '星期三', '星期四', '星期五', '星期六', '星期日'];
                for (let i = 0; i < str.length; i++) {
                    for (let j = 0; j < res.list.length; j++) {
                        if(res.list[j].timename == str[i]){
                            num[i] = res.list[j].counts;
                            sum+=res.list[j].counts;
                            break;
                        }else {
                            num[i] = 0;
                        }
                    }
                }
                $('#contextnum').html("本周总新增用户数："+sum);
                changeChart(str,num)
            }
        })
    }

    function months() {
        $('#weeks').css('background', '');
        $('#months').css('background', '#1E9FFF80');
        $('#years').css('background', '');
        $.ajax({
            url:'user/usercount',
            data:{type:2},
            dataType:'json',
            success:function (res) {
                var sum = 0;
                var num = new Array();
                var str = ['第一周', '第二周', '第三周', '第四周', '第五周', '第六周'];
                for (let i = 0; i < str.length; i++) {
                    for (let j = 0; j < res.list.length; j++) {
                        if(res.list[j].timename == str[i]){
                            num[i] = res.list[j].counts;
                            sum+=res.list[j].counts;
                            break;
                        }else {
                            num[i] = 0;
                        }
                    }
                }
                $('#contextnum').html("本月总新增用户数："+sum);
                changeChart(str,num)
            }
        })
    }

    function years() {
        $('#weeks').css('background', '');
        $('#months').css('background', '');
        $('#years').css('background', '#FFB80080');
        $.ajax({
            url:'user/usercount',
            data:{type:3},
            dataType:'json',
            success:function (res) {
                var sum = 0;
                var num = new Array();
                var str = res.data;
                for (let i = 0; i < str.length; i++) {
                    for (let j = 0; j < res.list.length; j++) {
                        if(res.list[j].timename == str[i]){
                            num[i] = res.list[j].counts;
                            sum+=res.list[j].counts;
                            break;
                        }else {
                            num[i] = 0;
                        }
                    }
                }
                $('#contextnum').html("近半年总新增用户数："+sum);
                changeChart(str,num)
            }
        })
    }

    $(function () {
        weeks();
    })

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
