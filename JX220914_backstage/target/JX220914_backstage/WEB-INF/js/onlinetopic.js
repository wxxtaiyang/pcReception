var htmlPage = 1;
var htmLength = 0;
$(function() {
    changeField();
});
function changeField() {
    $.ajax({
        url:'field/all',
        dataType:'json',
        async:true,
        success:function (res) {
            var html='';
            var list = res.list;
            for (let i = 0; i < list.length; i++) {
                html+='<option value="'+list[i].fieldid+'">'+list[i].fieldname+'</option>';
            }
            $('#field').html(html);
            getOptions(1);
        }
    })
}
function getOptions(value) {
    $.ajax({
        url:'onlinetopic/query',
        data:{
            fieldid:value,
            page:htmlPage,
            size:6,
        },
        type:'post',
        dataType: 'json',
        success:function (res) {
            var html="";
            for (let i = 0; i < res.data.length; i++) {
                var d = JSON.stringify(res.data[i]).replace(/\"/g,"'");
                html+='<li>\n' +
                    '                <div class="subject">\n' +
                    '                    <span>'+res.data[i].onlinecontext+'</span>\n' +
                    '                    <span>\n' +
                    '                        <button type="button" style="margin-right:10px;" onclick="updateOnline('+d+')">修改</button>\n' +
                    '                        <button type="button" onclick="delonline('+res.data[i].onlineid+')">删除</button>\n' +
                    '                    </span>\n' +
                    '                </div>\n' +
                    '                <div class="options">\n';
                    for (let j = 0;j < res.data[i].options.length;j++){
                        html+='<input type="radio" value="'+res.data[i].options[j].optionid+'" name="'+res.data[i].onlineid+'"/>'
                            +res.data[i].options[j].optioncontext;
                    }
                    html+='</div></li>'
            }
            $('#toppicol').html(html);
            htmLength = res.count;
            $('#pages').html(htmlPage+"/"+htmLength);
        }
    })
}

function openAdd() {
    layer.open({
        type: 2,
        title: '添加在线题目',
        shadeClose: true,
        shade: 0.8,
        area: ['620px', '600px'],
        content: 'addonline', //iframe的url
        end:function () {
            getOptions($('#field').val());
        }
    });
}

function updateOnline(obj){
    console.log(obj)
    layer.open({
        type: 2,
        title: '添加在线题目',
        shadeClose: true,
        shade: 0.8,
        area: ['620px', '600px'],
        content: 'updateonline', //iframe的url
        success:function(layero, index){
            var body=layer.getChildFrame('body',index);
            body.find('#onlineid').val(obj.onlineid);
            body.find('#title').val(obj.onlinecontext);
            var html = '';
            for (let j = 0;j < obj.options.length;j++){
                html+='<div>'+
                    ' 选项：<input type="text" name="option" lay-verify="title" autocomplete="off" placeholder="请输入选项"'+
                    'class="layui-input-block" value="'+obj.options[j].optioncontext+'">'+
                    ' 分值：<input type="number" name="optionnum" lay-verify="title" autocomplete="off" placeholder="请输入分值"'+
                    'class="layui-input-block" value="'+obj.options[j].optionscore+'">'+
                    '</div>'

            }
            body.find('#onlineoption').html(html);
            body.find('#rest').click(function () {
                body.find('#title').val(obj.onlinecontext);
                body.find('#onlineoption').html(html);
            })
        },
        end:function () {
            getOptions($('#field').val());
        }
    });
}

function delonline(value) {
    //询问框
    layer.confirm('是否取消该题目？', {
        btn: ['确定','取消'] //按钮
    }, function(){
        $.ajax({
            url:'onlinetopic/del',
            data:{onlineid:value},
            type:'post',
            dataType:'json',
            success:function (res) {
                layer.msg(res.msg);
                getOptions($('#field').val());
            }
        })
    }, function(){});

}

function upPage() {
    if(htmlPage-1 >= 1){
        htmlPage--;
        getOptions($('#field').val());
    }
}
function downPage() {
    if(htmlPage+1 <= htmLength){
        htmlPage++;
        getOptions($('#field').val());
    }
}