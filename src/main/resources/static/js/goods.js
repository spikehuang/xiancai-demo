$(function () {

    $(document).ready(function () {
//         Cookies.set('username', 'tom', {expires: 7, path: '/xiancai'});
//         Cookies.set('userId', 7001, {expires: 7, path: '/xiancai'});
        init();
        changeButton();
    });

    function init() {
        var currentUsername = Cookies.get('username');
        if (!currentUsername) {
            var loginModal = $('#loginModal');
            loginModal.modal({
                show: true,
                backdrop: 'static',
                keyboard: false
            });
        }
    }

    function changeButton() {
        var status = $('.status').html();
        if (status !== '正常') {
            $('#buyButton').attr('disabled', 'disabled');
            $('#buyButton').attr('title', '商品正在被交易或已下架，暂时无法购买');
        }
    }

    $("#distributeButton").click(function() {
        location.href = '/xiancai/publish';
    });

    $('#loginButton').click(function () {
        var inputPhone = $('#phone').val();
        var inputPassword = $('#password').val();
//        console.log("input: " + inputPhone + inputPassword);
        $.get(
            "/xiancai/user/" + inputPhone + "/" + inputPassword,
            function (result) {
                if (result.code === 2) {
                    $('#loginMessage').hide().html('<label class="label label-danger">' + result.data + '</label>').show(300);
                } else {
                    Cookies.set('username', result.data.username, {expires: 7, path: '/xiancai'});
                    Cookies.set('userId', result.data.userId, {expires: 7, path: '/xiancai'});
                    window.location.reload();
                }
            }
        );
    });

    $('#buyButton').click(function () {
        var userId = Cookies.get('userId');
        var goodsId = $('#goodsId').val();
        var price = $('#price').val();
        var buyInfo = {
            "userId": userId,
            "goodsId": goodsId,
            "price": price
        };

        $.confirm({
            type: "blue",
            title: "系统提示",
            content: "确定购买[ " + $('#name').val() + " ]吗？",
            icon: 'glyphicon glyphicon-question-sign',
            buttons: {
                confirm: {
                    text: "确认",
                    btnClass: "btn-blue",
                    action: function () {
                        $.ajax({
                            url: "/xiancai/orders",
                            type: "POST",
                            async: "false",
                            contentType: "application/json",
                            dataType: "JSON",
                            data: JSON.stringify(buyInfo),
                            success: function() {
                                var orderId = '';
                                $.ajax({
                                    url: "/xiancai/orders/" + userId + "/" + goodsId,
                                    type: "GET",
                                    success: function(result) {
                                        if (result.code === 1) {
                                            orderId = result.data;
                                            $.alert({
                                                type: "green",
                                                title: "系统提示",
                                                content: "购买成功！",
                                                icon: 'glyphicon glyphicon-ok-sign',
                                                buttons: {
                                                    OK: {
                                                        text: "确认",
                                                        action: function () {
                                                            location.href = '/xiancai/orders/' + orderId + '/detail';
                                                        }
                                                    }
                                                }
                                            });
                                        } else {
                                            console.log(result.msg);
                                        }
                                    }
                                });
                            }
                        });
                    }
                },
                cancel: {
                    text: "取消"
                }
            }
        });
    });

    $('#likeButton').click(function() {
        $.alert({
            type: "green",
            title: "系统提示",
            content: "收藏成功！",
            icon: 'glyphicon glyphicon-ok-sign',
            buttons: {
                OK: {
                    text: "确认"
                }
            }
        });
    });

});
