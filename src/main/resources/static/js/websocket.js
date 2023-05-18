// 주문 생성 함수를 추가합니다.
function createNewOrder(order, orderDetail) {
    var orderDiv = $("<div>").addClass("order-details").attr("id", "order-details-" + order.idx);
    var orderIdSpan = $("<span>").text(order.idx.toString().padStart(5, '0')).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[메뉴 " + orderDetail.length + "개]&nbsp;&nbsp;합계&nbsp;&nbsp;" + order.price + "원<br>");
    orderDiv.append(orderIdSpan);
    orderDiv.append("<br>");

    for (var i = 0; i < orderDetail.length; i++) {
        var menuItem = $("<span>").addClass("menu-item").text(orderDetail[i].menuName +" x " + orderDetail[i].count);
        orderDiv.append(menuItem);
    }

    var acceptDiv = $("<div>").addClass("accept").attr("id", "accept-" + order.idx).text("수락하기");
    var rejectDiv = $("<div>").addClass("reject").attr("id", "reject-" + order.idx).text("거절하기");

    orderDiv.append(acceptDiv);
    orderDiv.append(rejectDiv);

    $(".v1_4").append(orderDiv);

}
//수락
$(document).on('click', '.accept', function() {
    var orderIdx = this.id.split('-')[1];

    // 서버로 요청을 보내 상태를 변경합니다.
    $.ajax({
        url: '/order/update', // 이 URL을 실제 URL로 변경해야 합니다.
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify({
            orderIdx: orderIdx,
            status: 'DOING'
        }),
        success: function(data) {
            // 요청이 성공하면 order-details div를 삭제합니다.
            $('#order-details-' + orderIdx).remove();
        }
    });
});
//거절
$(document).on('click', '.reject', function() {
    var orderIdx = this.id.split('-')[1];

    // 서버로 요청을 보내 상태를 변경합니다.
    $.ajax({
        url: '/order/update', // 이 URL을 실제 URL로 변경해야 합니다.
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify({
            orderIdx: orderIdx,
            status: 'REJECT'
        }),
        success: function(data) {
            // 요청이 성공하면 order-details div를 삭제합니다.
            $('#order-details-' + orderIdx).remove();
        }
    });
});



// 웹소켓 연결을 생성합니다. URL은 실제 서버에 맞게 변경해야 합니다.
let socket = new WebSocket("ws://localhost:8080/orders");

// 연결이 열렸을 때 실행할 코드를 설정합니다.
socket.onopen = function(e) {
    console.log("[open] Connection established");
    console.log("Sending to server");
    socket.send("web 연결");
};

// 메시지를 받았을 때 실행할 코드를 설정합니다.
socket.onmessage = function(event) {
    console.log(`[message] Data received from server: ${event.data}`);
    var data = JSON.parse(event.data);
    if (data.message === "새 주문") {
        var order = data.order;
        var orderDetail = data.orderDetails;
        createNewOrder(order, orderDetail);
    }
};

// 연결이 닫혔을 때 실행할 코드를 설정합니다.
socket.onclose = function(event) {
    if (event.wasClean) {
        console.log(`[close] Connection closed cleanly, code=${event.code} reason=${event.reason}`);
    } else {
        console.log('[close] Connection died');
    }
};

// 에러가 발생했을 때 실행할 코드를 설정합니다.
socket.onerror = function(error) {
    console.error(`[error] ${error.message}`);
};
