$(function() {

    $("#returnButton").click(function() {
        window.history.go(-1);
    });

    $('#loginButton').click(function () {
        var inputPhone = $('#phone').val();
        var inputPassword = $('#password').val();
        $.get(
            "/xiancai/user/" + inputPhone + "/" + inputPassword,
            function (result) {
                if (result.code === 2) {
                    $('#loginMessage').hide().html('<label class="label label-danger">' + result.data + '</label>').show(300);
                } else {
                    Cookies.set('username', result.data.username, {expires: 7, path: '/xiancai'});
                    Cookies.set('userId', result.data.userId, {expires: 7, path: '/xiancai'});
                    if ($("input[type='checkbox']").is(':checked')) {
                        if (result.data.userType === 1) {
                            location.href = '/xiancai/administrator';
                        } else {
                            $('#loginMessage').hide().html('<label class="label label-danger">您没有管理员权限</label>').show(300);
                        }
                    } else {
                        location.href = '/xiancai';
                    }
                }
            }
        );
    });

});