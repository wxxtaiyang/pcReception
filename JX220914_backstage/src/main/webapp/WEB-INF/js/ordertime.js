function clickDate(dateValue) {
    $.ajax({
        url:'ordertime/query',
        data:{"data":dateValue},
        dataType:'json',
        success:function (res) {
            $('input[name=timeslot]').each(function () {
                $(this).attr('checked',false)
            });
            for (let i = 0; i < res.length; i++) {
                $('input[name=timeslot]').eq(res[i].ordertimeint-1).attr('checked',true);
            }
            form.render();
        }
    })
}
function ordertime() {
    var arr = new Array();
    $('input[name=timeslot]:checked:checked').each(function () {
        arr.push($(this).val())
    });
    $.ajax({
        url:'ordertime/update',
        data:{"data":dateValue,
               arr:arr },
        dataType:'json',
        success:function (res) {
            layer.msg(res.msg);
        }
    })
}