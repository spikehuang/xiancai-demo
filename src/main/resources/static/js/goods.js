$(function() {

    $(document).ready(function() {
        init();
    });

    function init() {
        var loginModal = $('#loginModal');
        loginModal.modal({
            show: true,
            backdrop: 'static',
            keyboard: false
        });
    }

});