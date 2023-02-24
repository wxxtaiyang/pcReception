var table = layui.table;
var form = layui.form;
table.on('toolbar(adminlist)',function (obj) {
    if(obj.event == 'getCheckData'){
        table.reload('adminlist',{
            page:{
                curr:1
            },
            where:{
                name:$('#name').val(),
                state:$('#state').val()
            }
        })
    }else if(obj.event == 'addData'){
        layer.open({
            type: 2,
            title: '添加管理员',
            shadeClose: true,
            shade: 0.8,
            area: ['650px', '650px'],
            content: 'insertadmin' //iframe的url
        });
    }
});
//监听行工具事件
table.on('tool(adminlist)', function(obj){
    var data = obj.data;
    if(obj.event === 'del'){
        layer.confirm('真的删除行么', function(index){
            $.ajax({
                url: 'admin/del',
                data:({adminid:data.adminid}),
                dataType: 'json',
                success:function (res) {
                    if(res.flag > 1){
                        layer.msg("删除成功");
                        obj.del();
                        layer.close(index);
                    }else{
                        layer.msg("删除失败");
                    }
                }
            });
        });
    } else if(obj.event === 'edit'){
        layer.confirm("确定重置密码为：123456",function () {
            $.ajax({
                url:'admin/reset',
                data:({
                    adminid:data.adminid
                }),
                dataType: 'json',
                success:function (res) {
                    if(res.flag > 0){
                        layer.msg("重置成功")
                    }else {
                        layer.msg("重置失败")
                    }

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
            url: 'admin/update',
            data: ({
                adminid: obj.value
            }),
            dataType: 'json',
            success: function (data) {
                if(data.flag>0){
                    layer.msg("修改成功");
                }else{
                    layer.msg("修改失败");
                }
                table.reload('adminlist')
            }
        })
    },function () {
        table.reload('adminlist')
    })
});