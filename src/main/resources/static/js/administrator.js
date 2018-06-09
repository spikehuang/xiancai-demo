$(function() {

    $('.list-group-item').click(function () {
        var liId = $(this).attr("id");
        $(".active").removeClass("active");
        $("#" + liId).addClass("active");

        var catId = liId.split("-")[0];
        $('div[style = "display: block;"]').hide().css('display', 'none');
        $('#' + catId).fadeIn().css('display', 'block');
    });

});