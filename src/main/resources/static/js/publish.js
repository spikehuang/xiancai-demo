$(function() {

    $(document).ready(function() {
        init();
        fillCats();
        initUpload();
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

    function fillCats() {
        $.get(
            "/xiancai/goodsCat",
            function (result) {
                if (result.code === 1) {
                    var data = result.data;
                    $.each(data, function (i) {
                        $('#cat.selectpicker').append('<option value="' + data[i].catId + '">' + data[i].catName + '</option>');
                    });
                    $('#cat').selectpicker('refresh');
                }
            }
        );
    }

    function initUpload() {
        $('.file-caption-name').attr('placeholder', '请选择图片');
    }

//    $("#img").fileinput({
//        uploadUrl:"/xiancai/upload",
//        uploadAsync : true, //默认异步上传
//        showUpload : false, //是否显示上传按钮,跟随文本框的那个
//        showRemove : false, //显示移除按钮,跟随文本框的那个
//        showCaption : true,//是否显示标题,就是那个文本框
//        maxFileCount : 1, //表示允许同时上传的最大文件个数
//        enctype : 'multipart/form-data',
//        validateInitialCount : true,
//        language : 'zh'
//    });
//
//    $("#img").on("fileuploaded", function(event, data, previewId, index) {
//        console.log("fileuploaded");
//        var ref = $(this).attr("data-ref");
//        $("input[name='" + ref + "']").val(data.response.url);
//    });

//    $('.selectpicker').change(function () {
//        var slecteditem= $(this).find("option:selected").val();
//        alert(slecteditem);
//    });

//    $('#publishButton').click(function() {
//        alert($('.file-caption-name').attr('title'));
//    });

//    $('#testButton').click(function() {
//        var $img = $('#img').val();
//        var arr = $img.split('\\');
//        var imgName = arr[arr.length - 1];
//        alert(imgName);
//    });

    $('#publishButton').click(function() {
        var userId = Cookies.get('userId');
        var goodsName = $('#goodsName').val();
        var imgArray = $('#img').val().split('\\');
        var img = "/img/" + imgArray[imgArray.length - 1];
        var price = $('#price').val();
        var catId = $('.selectpicker').find("option:selected").val();
        var description = $('#description').val();
        var goods = {
            "userId": userId,
            "name": goodsName,
            "img": img,
            "price": price,
            "catId": catId,
            "description": description
        };
        $.ajax({
            url: '/xiancai/goods',
            type: "POST",
            contentType: "application/json",
            dataType: "JSON",
            data: JSON.stringify(goods)
        });
    });

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