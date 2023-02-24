function changeIdentify() {
    $.ajax({
        url:'identify',
        success:function () {
            $("#imgcode").attr('src','identify');
        }
    });
}

function userLogin() {
    $.ajax({
        url: 'user/login',
        data: $("#userlogin").serialize(),
        type: 'post',
        dataType: 'json',
        success:function (data) {
            if(!data.flag){
                layer.msg(data.msg,{icon:2});
                changeIdentify()
            }else{
                layer.msg(data.msg,{icon:1});
                setTimeout(function () {
                    changeIdentify();
                    location.href = 'homepage';
                },1000);
            }
        }
    })
}

function userRegister() {
    if(!checkInput()){
        return;
    }
    $.ajax({
        url:'user/register',
        data: $('#userRegsiter').serialize(),
        type: 'post',
        dataType: 'json',
        success:function (data) {
            if(data.flag){
                layer.msg(data.msg,{icon: 1});
                document.getElementById('userRegsiter').reset();
                leftMove()
            }else{
                layer.msg(data.msg,{icon:2});
            }
        }
    })
}

function checkInput() {
    var accPattern = /^[A-Za-z0-9]{6,15}$/;// 账号密码正则
    var phonePattern = /^((13[0-9])|(14[1|5|7])|(15([0-3]|[5-9]))|(18[0-2,5-9]))\d{8}$/;// 电话正则
    if(!accPattern.test($('#useracc').val())){
        layer.msg("请输入以字母或数字组成的6-15位账号",{icon:2});
        return false;
    }
    if(!accPattern.test($('#userpwd').val())){
        layer.msg("请输入以字母或数字组成的6-15位密码",{icon:2});
        return false;
    }
    if($('#userpwd').val() != $('#usercheckpwd').val()){
        layer.msg("两次密码不一致！",{icon:2});
        return false;
    }
    if(!phonePattern.test($('#userphone').val())){
        layer.msg("联系方式格式错误!",{icon:2});
        return false;
    }
    return true;
}