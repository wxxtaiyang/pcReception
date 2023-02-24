var table = layui.table;
var form = layui.form;
//头工具栏事件
table.on('toolbar(userlist)',function(obj){
    if(obj.event == 'getCheckData'){
        table.reload('userlist',{
            page:{
                curr:1
            },
            where:{
                name:$('#name').val(),
                state:$('#ustate').val()
            }
        })
    }
});
//监听行工具事件
table.on('tool(userlist)', function(obj){
    var data = obj.data;
    // console.log("用户id"+data.userid);
    if(obj.event === 'del'){
        layer.confirm('真的删除行么', function(index){
            $.ajax({
                url: 'user/del',
                data:({userid:data.userid}),
                dataType: 'json',
                success:function (res) {
                    layer.msg(res.msg);
                    if(res.flag){
                        obj.del();
                        layer.close(index);
                    }
                }
            });
        });
    } else if(obj.event === 'edit'){
        layer.confirm("确定重置密码为：123456",function () {
            $.ajax({
                url:'user/resetpwd',
                data:({
                    userid:data.userid
                }),
                dataType: 'json',
                success:function (res) {
                    layer.msg(res.msg)
                }
            })
        })
    }
});
form.on('checkbox(state)', function(obj){
    var msg = ''
    var f = obj.othis[0].innerText;
    if(f=='禁用'){
        msg = '启用';
    }else{
        msg = '禁用';
    }
    layer.confirm("确定"+msg+"该账号",function () {
        $.ajax({
            url: 'user/updatestate',
            data: ({
                userid: obj.value
            }),
            dataType: 'json',
            success: function (data) {
                layer.msg(data.msg);
                table.reload('userlist')
            }
        })
    },function () {
        table.reload('userlist')
    })
});