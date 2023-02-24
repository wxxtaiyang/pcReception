// 确认预约
function sureOrder(data,table) {
    $.ajax({
        url:'order/sureorder',
        data:{
            orderid:data.orderid,
            userid:data.userid
        },
        type:'post',
        dataType:'json',
        success:function (res) {
            layer.msg(res.msg);
            if(res.flag){
                table.reload('test');
            }
        }
    })
}
// 诊断
function diagnosisOrder(data,table) {
    var url = encodeURI(JSON.stringify(data));
    layer.open({
        type: 2,
        shadeClose: true,
        shade: 0.8,
        title: '查看详情',
        area: ['750px', '650px'],
        content: 'diagnosis?data='+url, //iframe的url
        end: function() {
            table.reload('test');
        }
    });
}
// 查看详情
function lookOeder(data) {
    var url = encodeURI(JSON.stringify(data));
    layer.open({
        type: 2,
        shadeClose: true,
        shade: 0.8,
        title: '查看详情',
        area: ['750px', '650px'],
        content: 'orderdetails?data='+url //iframe的url
    });
}