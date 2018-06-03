$(function() {

    $('.list-group-item').click(function () {
        var liId = $(this).attr("id");
        $(".active").removeClass("active");
        $("#" + liId).addClass("active");

        var catId = liId.split("-")[0];
        $('div[style = "display: block;"]').hide().css('display', 'none');
        $('#' + catId).fadeIn().css('display', 'block');
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
                    console.log(length);
                    for (var i = 0; i < length; i++) {
                        tableCode += '<tr><td class = "userId">' + result.data[i].goodsId + '</td>';
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

});