$(function() {

    $("#distributeButton").click(function() {
        location.href = '/xiancai/publish';
    });

    $("#searchButton").click(function() {
        var keyWord = $("#keyWordInput").val();
        $.ajax({
            url: "/xiancai/goods/" + keyWord,
            async: true,
            success: function(result) {
                if (result.code === 1) {
                    var goodsContainer = $("#goodsContainer");
                    goodsContainer.hide().html("");
                    var goodsContainerHtml = "";
                    if (result.data.length === 0) {
                        goodsContainerHtml +=
                            "<div style='display: flex;align-items:center;justify-content:center;'>" +
                                "<img src='/xiancai/img/error.png' alt='未查找到商品'/>" +
                                "<p style='margin: 15px 0 0 0'>未查找到商品</p>" +
                            "</div>"
                    } else {
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
                    }
                    goodsContainer.html(goodsContainerHtml).show(500);
                }

            }
        });
    });

    $("body").keydown(function() {
        if (event.keyCode == "13") {
            $('#searchButton').click();
        }
    });

    $(".catsList").click(function() {
        var liId = $(this).attr("id");
//        console.log($(this).attr("id"));
        $(".active").removeClass("active");
        $("#" + liId).addClass("active");

        var catId = liId.split("-")[1];

        $.ajax({
            url: "/xiancai/goods/cat/" + catId,
            async: true,
            success: function(result) {
                if (result.code === 1) {
                    var goodsContainer = $("#goodsContainer");
                    goodsContainer.hide().html("");
                    var goodsContainerHtml = "";
                    if (result.data.length === 0) {
                        goodsContainerHtml +=
                            "<div style='display: flex;align-items:center;justify-content:center;'>" +
                                "<img src='/xiancai/img/error.png' alt='未查找到商品'/>" +
                                "<p style='margin: 15px 0 0 0'>未查找到商品</p>" +
                            "</div>"
                    } else {
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
                    }
                    goodsContainer.html(goodsContainerHtml).show(500);
                }

            }
        });
    });

});