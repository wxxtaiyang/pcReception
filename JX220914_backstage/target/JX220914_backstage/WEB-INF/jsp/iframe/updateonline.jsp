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
<style>
    .layui-input-block{
        margin-left: 50px;
    }
    body{
        display: flex;
        align-items: center;
        justify-content: center;
    }
    .father{
        width: 600px;
        text-align: center;
        background-color: rgba(237, 237, 237, 0.447);
        border-radius: 20px;
        box-shadow: 0px 0px 5px #000 inset;
    }
</style>
<body>
<div class="father">
    <h1 style="margin: 20px 0;">添加题目</h1>
    <form class="layui-form" action="javascript:void(0)">
        <input type="hidden" id="onlineid">
        <div class="layui-form-item">
            <label class="layui-form-label">题目内容：</label>
            <div class="layui-input-block">
                <input type="text" id="title" name="title" lay-verify="title" autocomplete="off" placeholder="请输入题目"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">题目选项：</label>
        </div>
        <div class="layui-input-block" id="onlineoption">
            <div>
                选项：<input type="text" name="option" lay-verify="title" autocomplete="off" placeholder="请输入选项"
                          class="layui-input-block">
                分值：<input type="number" name="optionnum" lay-verify="title" autocomplete="off" placeholder="请输入分值"
                          class="layui-input-block">
            </div>
            <div>
                选项：<input type="text" name="option" lay-verify="title" autocomplete="off" placeholder="请输入选项"
                          class="layui-input-block">
                分值：<input type="number" name="optionnum" lay-verify="title" autocomplete="off" placeholder="请输入分值"
                          class="layui-input-block">
            </div>
        </div>
        <div class="layui-form-item" style="margin-top:20px;">
            <div class="layui-input-block">
                <button type="button" class="layui-btn layui-btn-primary layui-border-green" onclick="addOptions()">添加选项</button>
                <button type="button" class="layui-btn layui-btn-primary" onclick="removeOptions()">清空选项</button>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="button" class="layui-btn" onclick="addOnline()">立即提交</button>
                <button type="button" id="rest" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>

</body>
<script src="js/layui/layui.js"></script>
<script src="js/jquery-1.7.2.min.js"></script>
<script>
    var our = parent.layer.getFrameIndex(window.name);
    function addOptions(){
        if($('#onlineoption').children('div').length >= 4){
            layer.msg('最多只能有四个选项')
            return
        }
        $('#onlineoption').append('<div>'+
            ' 选项：<input type="text" name="option" lay-verify="title" autocomplete="off" placeholder="请输入选项"'+
            'class="layui-input-block">'+
            ' 分值：<input type="number" name="optionnum" lay-verify="title" autocomplete="off" placeholder="请输入分值"'+
            'class="layui-input-block">'+
            '</div>')
    }

    function removeOptions(){
        $('#onlineoption').empty();
        for (let index = 0; index < 2; index++) {
            addOptions();
        }
    }

    function addOnline(){
        var onlineoption = new Array();
        var num = $('input[name=optionnum]');
        $('input[name=option]').each((i,e)=>{
            onlineoption.push({'optioncontext':$(e).val(),'optionscore':$(num[i]).val()})
        });
        console.log($(window.parent.document).find("#field").val());
        $.ajax({
            url:'onlinetopic/update',
            type:'post',
            data:{
                list:JSON.stringify(onlineoption),
                onlineid:$("#onlineid").val(),
                onlinecontext:$('#title').val()
            },
            dataType:'json',
            success:function (res) {
                layer.msg(res.msg);
                setTimeout(function () {
                    parent.layer.close(our)
                },500)
            }
        })
    }
</script>
</html>
