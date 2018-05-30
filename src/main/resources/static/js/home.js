$(function() {

//    $(document).ready(function() {
//        showGoods();
//    });

    $("#distributeButton").click(function() {
        location.href = '/xiancai/publish';
    });

    $(".catsList").click(function() {
        var liId = $(this).attr("id");
//        console.log($(this).attr("id"));
        $(".active").removeClass("active");
        $("#" + liId).addClass("active");

        var catId = liId.split("-")[1];

        $.ajax({
            url: "/xiancai/goods/cat/" + catId,
            async: false,
            success: function(result) {
                if (result.code == 1) {
                    $("#goodsContainer").hide().html("");
                    var goodsContainerHtml = "";
                    var goodsList = result.data;
                    goodsContainerHtml = "<div class='row'>";
                    for (var i = 0; i < goodsList.length; i++) {
                        goodsContainerHtml +=
                            "<div class='col-sm-6 col-md-4'>" +
                                "<div class='thumbnail'>" +
                                    "<a href='/xiancai/goods/" + goodsList[i].goodsId + "/detail' target='_blank'>" +
                                        "<img src='/xiancai" + goodsList[i].img + "' alt='" + goodsList[i].name + "'/>" +
                                    "</a>" +
                                    "<div class='caption'>" +
                                        "<p>" + goodsList[i].name + "</p>" +
                                        "<p style='color: #FF0000;'>￥" + goodsList[i].price + "</p>" +
                                    "</div>" +
                                "</div>" +
                            "</div>"
                    }
                    goodsContainerHtml += "</div>";
                    $("#goodsContainer").html(goodsContainerHtml).show();
                }

            }
        });
    });

});