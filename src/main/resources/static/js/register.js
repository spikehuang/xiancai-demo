$(function() {

    $("#returnButton").click(function() {
        window.history.go(-1);
    });

    $("#saveButton").click(function() {
        var phone = $("#phone").val();
        var username = $("#username").val();
        var password = $("#password").val();
        var realName = $("#realName").val();
        var address = $("#address").val();
        var user = {
            "phone": phone,
            "username": username,
            "password": password,
            "realName": realName,
            "address": address
        };

        $.ajax({
            url: "/xiancai/user",
            type: "POST",
            contentType: "application/json",
            dataType: "JSON",
            data: JSON.stringify(user),
            success: function() {
                $.alert({
                    type:'green',
                    title: '系统提示',
                    content: '注册成功！',
                    icon:'glyphicon glyphicon-ok-sign',
                    buttons: {
                        OK: {
                            text: "确认",
                            action: function() {
                                location.href='/xiancai/home';
                            }
                        }
                    }
                });
            },
            error: function() {
                flash("#taskId", 8, 10, 100);
            }
        });
    });

    $("input#phone")[0].oninput = function() {
        $.get(
            "/xiancai/user/" + $("#phone").val(),
            function(result) {
                if (result == true) {
                    $("#existInfo").text("该手机号已注册！");
                    $(".form-group:first").addClass("has-error");
                } else {
                    $("#existInfo").text("");
                    $(".form-group:first").removeClass("has-error");
                }
            }
        );
    };

    function flash(obj, time, range, speed) {
            var $panel = $(obj);
            var offset = $panel.offset() - $panel.width();
            var x = offset.left;
            var y = offset.top;
            for (var i = 1; i <= time; i++) {
                if (i % 2 == 0) {
                    $panel.animate({left: '+' + range + 'px'}, speed);
                } else {
                    $panel.animate({left: '-' + range + 'px'}, speed);
                }
            }
            $panel.animate({left: 0}, speed);
            $panel.offset({top: y, left: x});
    }

});