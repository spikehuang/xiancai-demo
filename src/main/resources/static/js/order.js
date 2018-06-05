$(function() {

    $(document).ready(function() {
        checkStatus();
    });

    function checkStatus() {
        var status = $('#status').text().split("：")[1];
        if (status !== '交易中') {
            $('#updateStatus').hide().html("");
        }
    }

    $('#successButton').click(function() {
        var orderId = $('#orderId').text().split("：")[1];
        $.ajax({
            url: "/xiancai/orders/successful",
            type: "POST",
            contentType: "application/json",
            dataType: "JSON",
            data: orderId,
            success: function(result) {
                if (result.code === 1) {
                    $.alert({
                        type:'green',
                        title: '系统提示',
                        content: '交易已确认！',
                        icon:'glyphicon glyphicon-ok-sign',
                        buttons: {
                            OK: {
                                text: "确认",
                                action: function() {
                                    window.location.reload();
                                }
                            }
                        }
                    });
                } else {
                    console.log(result.data);
                }
            }
        });
    });

    $('#cancelButton').click(function() {
        var orderId = $('#orderId').text().split("：")[1];
        $.ajax({
            url: "/xiancai/orders/cancel",
            type: "POST",
            contentType: "application/json",
            dataType: "JSON",
            data: orderId,
            success: function(result) {
                if (result.code === 1) {
                    $.alert({
                        type:'green',
                        title: '系统提示',
                        content: '交易已取消！',
                        icon:'glyphicon glyphicon-ok-sign',
                        buttons: {
                            OK: {
                                text: "确认",
                                action: function() {
                                    window.location.reload();
                                }
                            }
                        }
                    });
                } else {
                    console.log(result.data);
                }
            }
        });
    });

});