$(function() {

    $(document).ready(function() {
        init();
    });

    function init() {
        var currentUsername = Cookies.get('username');
        var currentUserId = Cookies.get('userId');
        if (currentUsername) {
            var loginNavBar = $('.navbar-right');
            loginNavBar.empty();
            loginNavBar.html(
                '<li class="dropdown">' +
                    '<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">' + currentUsername + '<span class="caret"></span></a>' +
                    '<ul class="dropdown-menu">' +
                        '<li><a href="/xiancai/user-center/' + currentUserId + '">个人中心</a></li>' +
                        '<li><a href="/xiancai/orders/user/' + currentUserId + '">已购商品</a></li>' +
                        '<li><a href="#">收藏夹</a></li>' +
                        '<li role="separator" class="divider"></li>' +
                        '<li><a href="#" id="logOut">退出登录</a></li>' +
                    '</ul>' +
                '</li>'
            );
        }
    }

    $('.navbar-right').on('click', '#logOut', function () {
        Cookies.remove("username", { path: '/xiancai' });
        Cookies.remove("userId", { path: '/xiancai' });
        location.href = '/xiancai';
    });

});