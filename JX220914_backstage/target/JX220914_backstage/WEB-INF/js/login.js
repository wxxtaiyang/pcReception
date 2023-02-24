function login(path) {
    $.ajax({
        url:'admin/login',
        data: $('#adminLogin').serialize(),
        type: 'post',
        dataType: 'json',
        success:function (data) {
            if (data.flag){
                layer.msg(data.msg,{icon:1});
                // $(window).attr('location','http://www.baidu.com');
                setTimeout(function () {
                    changeCode();
                    location.href = path+'/homepage';
                },1000);
            }else{

                changeCode();
                layer.msg(data.msg,{icon:2})
            }
        }
    })
}
function changeCode() {
    $.ajax({
        url:'code',
        success:function () {
            $("#identify").attr('src','code');
        }
    });
}