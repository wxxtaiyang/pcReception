$(function () {
    $.ajax({
        url:'field/all',
        dataType: 'json',
        success:function (res) {
            var html='';
            res.list.forEach((item,index)=>{
                html+='<input type="checkbox" class="fieldid" title="'+item.fieldname+'" value="'+item.fieldid+'">';
            });
            $('#field').html(html);
            form.render();
        }
    });
    $.ajax({
        url:'role/getlist',
        dataType:'json',
        success:function (res) {
            var html='';
            res.list.forEach((item,index)=>{
                html+='<option value="'+item.roleid+'">'+item.rolename+'</option>';
            });
            $('#roleid').html(html);
        }
    })
});

function insert() {
    var index = layer.load(1, {shade: false});
    setTimeout(function (){
        if (uploadImg == false && uploadImg != undefined){
            layer.close(index);
            layer.msg("上传失败！",{icon:2});
            return;
        }
        if(!checkNull()){
            layer.close(index);
            return;
        }
        if(uploadImg == undefined){
            uploadImg = "upload/user.jpg";
        }
        let arr = new Array();
        $("input[class='fieldid']:checkbox:checked").each(function () {
            arr.push($(this).val());
        });
        if($("input[name='adminprice']").val() == ''){
            $("input[name='adminprice']").val(0)
        }
        $.ajax({
            url:'admin/add',
            type: 'post',
            data: $('#insertadmin').serialize()+'&adminimg='+uploadImg+'&arr='+JSON.stringify(arr),
            dataType: 'json',
            success:function (res) {
                layer.close(index);
                if(res.flag){
                    layer.msg(res.msg,{time:1000});
                    parent.layer.close(our);//关闭当前页
                    parent.table.reload('adminlist');
                }else{
                    layer.msg(res.msg,{time:1000});
                }
            }
        });
        // parent.layer.close(our);//关闭当前页
    },1000);

}

function checkNull() {
    if($('#adminname').val().length === 0){
        layer.msg("昵称不能为空",{icon: 2});
        return false;
    }
    if($('#adminacc').val().length === 0){
        layer.msg("账号不能为空",{icon: 2});
        return false;
    }
    if($('#adminpwd').val().length === 0){
        layer.msg("密码不能为空",{icon: 2});
        return false;
    }
    return true;
}