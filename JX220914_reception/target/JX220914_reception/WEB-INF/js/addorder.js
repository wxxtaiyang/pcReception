$(function() {
    $.ajax({
        url:'field/query',
        dataType:'json',
        success:function (res) {
            var hm='<option value=""></option>';
            res.forEach((item,index)=>{
                hm+='<option value="'+item.fieldid+'">'+item.fieldname+'</option>'
            });
            $('#field').html(hm);
            form.render('select');
        }
    })
});
form.on('select(field)', function (data){
    if(data.elem.id == 'field'){
        queryAdmin(data.value)
    }else{
        $.ajax({
            url:'field/admins',
            data:{adminid:data.value},
            type:'post',
            dataType: 'json',
            success:function (res) {
                var admin = res.admin;
                var fields = res.fields;
                $('#imgheader').attr('src',admin.adminimg);
                $('#adminname').html('咨询师姓名： '+admin.adminname);
                $('#school').html(admin.adminschool+'  '+admin.admintitle);
                var hms = '擅长领域： ';
                fields.forEach((item,index)=>{
                    hms+=item.fieldname+" ";
                });
                price = admin.adminprice;
                $('#fields').html(hms);
                $('#price').html('服务价格： '+admin.adminprice+'元/次');
                $('#backdrop').html('专业背景： '+admin.socialcontext);
            }
        })
    }
});
function queryAdmin(value) {
    $.ajax({
        url:'field/fields',
        data:{fieldid:value},
        type:'post',
        dataType: 'json',
        success:function (res) {
            var hm='<option value=""></option>';
            res.data.forEach((item,index)=>{
                hm+='<option value="'+item.adminid+'">'+item.adminname+'</option>'
            });
            $('#admin').html(hm);
            form.render('select');
        }
    })
}
function queryDateTime(datetime) {
    $.ajax({
        url:'field/datetime',
        data:{
            datetime:datetime,
            adminid:$('#admin').val()
        },
        type:'post',
        dataType:'json',
        success:function (res) {
            console.log(res);
            $('#buttons button').each((i,t)=>{
                $(t).attr('class','layui-btn layui-btn-primary layui-btn-disabled')
            })
            res.data.forEach((item,index)=>{
                var i = item.ordertimeint-1;
                if(item.orderstate != 1){
                    $($('#buttons button').get(i)).attr('class','layui-btn layui-btn-disabled reds');
                    // $($('#buttons button').get(i)).css();
                }else{
                    $($('#buttons button').get(i)).attr('class','layui-btn layui-btn-primary');
                    $($('#buttons button').get(i)).on('click',changeColor);
                }
            })

        }
    })
}
function changeColor() {
    $('#buttons button').each((i,t)=>{
        if(t == this){
            $(this).css({'background':'#1E9FFF','color':'#fff'});
            time = i+1;
        }else{
            $(t).css({'background':'','color':''});
        }
    })
    console.log(time);
}

function insertOrder() {
    $.ajax({
        url:'order/insert',
        data:{
            adminid:$('#admin').val(),
            fieldid:$('#field').val(),
            date:$('#date').val(),
            time:time,
            problem:$('#pro').val(),
            price:price
        },
        type:'post',
        dataType:'json',
        success:function (res) {
            console.log(res);
            if(res.flag){
                layer.msg(res.msg,{icon: 1});
                setTimeout(function () {
                    parent.layer.close(our);//关闭当前页
                    parent.table.reload('orders');
                },500)
            }else{
                layer.msg(res.msg,{icon:2})
            }
        }

    })
}