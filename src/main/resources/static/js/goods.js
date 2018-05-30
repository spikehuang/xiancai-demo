$(function() {

    $(document).ready(function() {
//         Cookies.set('username', 'tom', {expires: 7, path: '/xiancai'});
//         Cookies.set('userId', 7001, {expires: 7, path: '/xiancai'});
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

        var loginNavBar = $('.navbar-right');
        loginNavBar.empty();
        loginNavBar.html(
            '<li class="dropdown">' +
                '<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">' + currentUsername + '<span class="caret"></span></a>' +
                '<ul class="dropdown-menu">' +
                    '<li><a href="/xiancai/home">查看个人信息</a></li>' +
                    '<li><a href="#">已购商品</a></li>' +
                    '<li><a href="#">收藏夹</a></li>' +
                    '<li role="separator" class="divider"></li>' +
                    '<li><a href="#" id="logOut">退出登录</a></li>' +
                '</ul>' +
            '</li>'
        );
    }
    
    $('.navbar-right').on('click', '#logOut', function () {
        Cookies.remove("username", { path: '/xiancai' });
        Cookies.remove("userId", { path: '/xiancai' });
        location.href = '/xiancai';
    });

});
