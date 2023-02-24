<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/all.css">
    <link rel="stylesheet" href="js/layui/css/layui.css">
    <link rel="stylesheet" href="css/insertadmin.css">
    <title>Document</title>
</head>

<body>
<h1 class="font" style="margin: 20px 0">添加管理员</h1>
<form class="layui-form-pane layui-form adminfrom" id="insertadmin">
    <div class="layui-form-item">
        <label class="layui-form-label">昵称</label>
        <div class="layui-input-block">
            <input type="text" name="adminname" lay-verify="title" id="adminname" autocomplete="off"
                   placeholder="请输入昵称" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">账号</label>
        <div class="layui-input-block">
            <input type="text" name="adminacc" lay-verify="title" autocomplete="off" placeholder="请输入账号"
                   class="layui-input" id="adminacc">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input type="password" name="adminpwd" lay-verify="title" autocomplete="off" placeholder="请输入密码"
                   class="layui-input" id="adminpwd">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">角色</label>
        <div class="layui-input-block">
            <select name="roleid" id="roleid" lay-filter="role">
                <option value="2">管理员</option>
                <option value="3">咨询师</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item" style="display:flex;align-items: center;">
        <label class="layui-form-label">头像</label>
        <div class="layui-input-inlink">
            <button type="button" class="layui-btn layui-btn-primary" id="test1">
                <i class="layui-icon">&#xe67c;</i>上传图片
            </button>
        </div>
        <div class="layui-input-block" style="margin-left:20px;">
            <img class="layui-upload-img" id="demo1" style="width:60px;height: 60px;">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">院校(公司)</label>
        <div class="layui-input-block">
            <input type="text" name="adminschool" lay-verify="title" autocomplete="off" placeholder="请输入当前就职院校(公司)"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">职称</label>
        <div class="layui-input-block">
            <input type="text" name="admintitle" lay-verify="title" autocomplete="off" placeholder="请输入职称"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item zixunshi">
        <label class="layui-form-label">价格</label>
        <div class="layui-input-block">
            <input type="text" name="adminprice" lay-verify="title" autocomplete="off" placeholder="请输入价格"
                   class="layui-input">
        </div>
    </div>
    <div class="layui-form-item zixunshi">
        <label class="layui-form-label">所属领域</label>
        <div class="layui-input-block" id="field">
<%--            <input type="checkbox" class="fieldid" title="情绪问题" value="1">--%>
<%--            <input type="checkbox" class="fieldid" title="个人成长" value="2">--%>
<%--            <input type="checkbox" class="fieldid" title="游戏" value="3">--%>
<%--            <input type="checkbox" class="fieldid" title="游戏" value="4">--%>
<%--            <input type="checkbox" class="fieldid" title="游戏" value="5">--%>
<%--            <input type="checkbox" class="fieldid" title="游戏" value="6">--%>
<%--            <input type="checkbox" class="fieldid" title="游戏" value="7">--%>
        </div>
    </div>
    <div class="layui-form-item zixunshi">
        <label class="layui-form-label">专业背景</label>
        <div class="layui-input-block">
            <textarea name="socialcontext" placeholder="请输入内容" class="layui-textarea" maxlength="250"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" type="button" lay-filter="formDemo" onclick="insert()" id="submit">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
</body>
<script src="js/layui/layui.js"></script>
<script src="js/jquery-1.7.2.min.js"></script>
<script>
    var our = parent.layer.getFrameIndex(window.name);
    var form = layui.form;
    var uploadImg;
    layui.use('upload', function () {
        var upload = layui.upload;
        //执行实例
        upload.render({
            elem: '#test1', //绑定元素
            auto: false,
            bindAction: '#submit',
            choose : function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    // console.log(result);
                    $('#demo1').attr('src', result);
                })
            },
            url: 'upload/image', //上传接口
            done: function (res) {
                uploadImg = res.data;
                // layer.msg(uploadImg)
            }
            ,error: function () {
                uploadImg = false;
            }
        });
    });
    form.on('select(role)',function(){
        console.log($('#roleid').val());
        if($('#roleid').val() == 2){
            $('.zixunshi').css({'display':'none'})
        }else{
            $('.zixunshi').css({'display':'block'})
        }
    });
</script>
<script src="js/insertadmin.js"></script>
</html>
