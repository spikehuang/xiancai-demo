$(function() {

    $('.list-group-item').click(function () {
        var liId = $(this).attr("id");
        $(".active").removeClass("active");
        $("#" + liId).addClass("active");

        var catId = liId.split("-")[0];
        $('div[style = "display: block;"]').hide().css('display', 'none');
        $('#' + catId).fadeIn().css('display', 'block');
    });

    $('#updateButton').click(function () {
        var user = {
            "userId": Cookies.get('userId'),
            "phone": $('#phone').val(),
            "username": $('#username').val(),
            "password": $('#password').val(),
            "realName": $('#realName').val(),
            "address": $('#address').val()
        };

        $.ajax({
            url: "/xiancai/user",
            type: "PUT",
            contentType: "application/json",
            dataType: "JSON",
            data: JSON.stringify(user),
            success: function(result) {
                if (result.code === 1) {
                    $.alert({
                        type:'green',
                        title: '系统提示',
                        content: '个人信息修改成功！',
                        icon:'glyphicon glyphicon-ok-sign',
                        buttons: {
                            OK: {
                                text: "确认",
                                action: function() {
                                    $('#person-item').click();
                                }
                            }
                        }
                    });
                }
            }
        });
    });

    $('#publish-item').click(function() {
        var goodsTable = $('#goodsTable');
        var tableCode = '';
        goodsTable.html('');

        $.get(
            '/xiancai/user/' + Cookies.get('userId') + '/goods',
            function(result) {
                if (result.code === 1) {
                    var length = result.data.length;
                    // console.log(length);
                    for (var i = 0; i < length; i++) {
                        var goodsId = result.data[i].goodsId;
                        tableCode += '<tr><td class = "goodsId"><a href="/xiancai/goods/' + goodsId + '/detail">' + goodsId + '</a></td>';
                        tableCode += '<td>' + result.data[i].name + '</td>';
                        tableCode += '<td>' + result.data[i].price + '</td>';
                        tableCode += '<td>' + result.data[i].createTime + '</td>';
                        tableCode +=
                            '<td>' +
                                '<button type="button" class="btn btn-primary btn-xs updateButton">' +
                                    '<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>' +
                                '</button>&nbsp;&nbsp;' +
                                '<button type="button" class="btn btn-danger btn-xs removeButton">' +
                                    '<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>' +
                                '</button>' +
                            '</td></tr>';
                    }
                    goodsTable.html(tableCode);
                }
            }
        );
    });

    $('#goodsTable').on('click', '.removeButton', function () {
        var goodsId = $(this).parent().siblings(".goodsId").html();
        // alert(goodsId);
        $.ajax({
            url: '/xiancai/goods/' + goodsId,
            type: 'DELETE',
            success: function (result) {
                if (result.code === 1) {
                    $('#publish-item').click();
                }
            }
        });
    });

});