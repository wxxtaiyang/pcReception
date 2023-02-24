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
    body{
        display: flex;
        align-items: center;
        justify-content: center;
    }
    .father{
        box-shadow:1px 1px 10px #afafaf inset;
        padding: 20px 40px;
    }
    .father div{
        margin: 10px 0;
        font-size: 15px;
    }
    .context{
        width: 500px;
        height: 300px;
        border: 1px solid #afafaf;
    }
</style>
<body>
<div class="father">
    <h1 style="margin:20px 0;text-align: center;">我的报告</h1>
    <div>
        <span>评测结果： </span>
        <span id="result"></span>
    </div>
    <div>
        <span>报告内容:</span>
        <div class="context" id="context"></div>
    </div>
    <div style="text-align:center;">
        <button class="layui-btn" style="width: 150px;" onclick="closOur()">
            返&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp回</button>
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
    var our = parent.layer.getFrameIndex(window.name);
    function closOur() {
        parent.layer.close(our);
    }
</script>
</html>