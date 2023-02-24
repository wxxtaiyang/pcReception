$(function () {
    $.ajax({
        url:'role/getlist',
        dataType: 'json',
        success:function (data) {
            var html = '';
            $.each(data.list,function (i,e) {
                html+= '<li onclick="liClick(this)" value="'+e.roleid+'">'+e.rolename+'</li>';
            })
            $('#role').html(html);
        }
    })
});

function liClick(e){
    roleid = $(e).val();
    // console.log($(e).val());
    $('#role').find('*').css({backgroundColor:'white'});
    e.style="background-color:rgba(0, 0, 255, 0.486)";
    $.ajax({
        url:'power/rolePower',
        data:{
            roleid:roleid
        },
        dataType: 'json',
        success:function (list) {
            let val = new Array();
            for (let i = 0; i < list.not.length;i++) {
                if(list.not[i].prowerparent != 0){
                    var child = new Array();
                    for (let j = i; j < list.not.length; j++) {
                        if(list.not[i].prowerparent === list.not[j].prowerparent){
                            var json = {
                                value:list.not[j].powerid,
                                title:list.not[j].powername,
                                id:list.not[j].powerid,
                                spread:true};
                            child.push(json);
                        }else{
                            i = j-1;
                            break;
                        }
                        if(j == list.not.length-1){
                            i = j;
                            break;
                        }
                    }
                    let jsp = {
                        value:list.not[i].prowerparent,
                        title:list.not[i].fathername,
                        id:list.not[i].prowerparent,
                        spread:true,
                        children:child
                    };
                    val.push(jsp);
                }else{
                    var father = i;
                    let child = new Array();
                    for (let j = i; j < list.not.length; j++) {
                        if(list.not[i].powerid === list.not[j].prowerparent){
                            var json = {
                                value:list.not[j].powerid,
                                title:list.not[j].powername,
                                id:list.not[j].powerid,
                                spread:true};
                            child.push(json);
                        }else{
                            i = j-1;
                            break;
                        }
                        if(j == list.not.length-1){
                            i = j;
                            break;
                        }
                    }
                    let jsp = {
                        value:list.not[father].powerid,
                        title:list.not[father].powername,
                        id:list.not[father].powerid,
                        spread:true,
                        children:child};
                    val.push(jsp);
                }
            }
            let rol = new Array();
            for (let i = 0; i < list.role.length; i++) {
                if(list.role[i].prowerparent == 0){
                    let child = new Array();
                    for (let j = 0; j < list.role.length; j++) {
                        if(list.role[j].prowerparent == list.role[i].powerid){
                            let js ={
                                value:list.role[j].powerid,
                                id:list.role[j].powerid,
                                title:list.role[j].powername,
                                // spread:true
                            };
                            child.push(js);
                        }
                    }
                    let fjs = {
                        value:list.role[i].powerid,
                        id:list.role[i].powerid,
                        title:list.role[i].powername,
                        spread:true,
                        children:child
                    };
                    rol.push(fjs);
                }
            }
            data = val;
            value = rol;
            transfer.render({
                elem: '#transfer',
                // 全部数据
                data: data,
                // 已选择数据，默认在右边
                title: ['未拥有权限', '已拥有权限'],
                value:value,
                // 菜单二级全展开
                spread: true,
            });
        }
    })
}
