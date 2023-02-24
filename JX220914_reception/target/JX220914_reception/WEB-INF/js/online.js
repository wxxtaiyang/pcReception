var urls = window.location.href;
var fieldid = decodeURI(urls.split("=")[1]); //decodeURI解码
console.log(fieldid);
var onlinSize = 0;
$(function () {
    $.ajax({
        url:'online/query',
        data:{
            fieldid:fieldid,
        },
        type:'post',
        dataType: 'json',
        success:function (res) {
            var html='';
            onlinSize = res.length;
            for (let i = 0; i < res.length; i++) {
                html+='<li>\n' +
                    '            <span>'+res[i].onlinecontext+'</span>\n' +
                    '            <div class="options">\n';
                for (let j = 0;j < res[i].options.length;j++){
                    html+='<input type="radio" value="'+res[i].options[j].optionscore+'" name="'+res[i].onlineid+'"/>'
                        +res[i].options[j].optioncontext;
                }
                html+='</div></li>'
            }
            $('#toppic').html(html);
        }
    })
});
function handPaper() {
    var list = $('input:radio:checked');
    console.log($('input:radio:checked'));
    if(list.length < onlinSize){
        layer.msg("请选完所有题目选项");
        return
    }
    var num = 0;
    list.each((i,t)=>{
        num += parseInt($(t).val())
    });
    $.ajax({
       url:'report/insert',
       data:{
           num:num,
           fieldid:fieldid
       },
       type: 'post',
       dataType: 'json',
       success:function (res) {
           layer.msg(res.msg);
       }
    });
}