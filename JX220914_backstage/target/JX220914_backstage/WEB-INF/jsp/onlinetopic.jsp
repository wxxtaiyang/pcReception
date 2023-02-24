<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/all.css">
    <link rel="stylesheet" href="js/layui/css/layui.css">
    <link rel="stylesheet" href="css/onlinetopic.css">
</head>

<body>
<div class="father">
    <div class="title font">题库管理</div>
    <div>
        <div class="field">
            <span>领域 ： </span>
            <select id="field" onchange="getOptions(this.value)">
                <option value="1"></option>
            </select>
            <span id="count">共10题</span>
        </div>
        <div class="name">
            <span>题目预览</span>
            <button class="layui-btn layui-btn-normal" onclick="openAdd()">新增</button>
        </div>
    </div>
    <form id="toppic">
        <ol id="toppicol">

        </ol>
    </form>
    <div class="pages">
        <a onclick="upPage()">上一页&nbsp;&nbsp;</a>
        <span id="pages">1/1</span>
        <a onclick="downPage()">&nbsp;&nbsp;下一页</a>
    </div>
</div>
</body>
<script src="js/layui/layui.js"></script>
<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/onlinetopic.js"></script>
</html>
