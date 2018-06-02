$(function() {

    $(document).ready(function() {
        init();
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

    $('#loginButton').click(function () {
        var inputPhone = $('#phone').val();
        var inputPassword = $('#password').val();
        $.get(
            "/xiancai/user/" + inputPhone + "/" + inputPassword,
            function(result) {
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

});