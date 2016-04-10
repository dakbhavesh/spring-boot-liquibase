$(document).ready(function() {
    var messageList = $("#messages");

    // defined a connection to a new socket endpoint
    var socket = new SockJS('/stomp');

    var stompClient = Stomp.over(socket);

    socket.onopen = function() {
        console.log('open');
    };
    socket.onmessage = function(e) {
        console.log('message', e.data);
    };
    socket.onclose = function() {
        console.log('close');
    };

    stompClient.connect({ }, function(frame) {
        // subscribe to the /topic/message endpoint
        stompClient.subscribe("/topic/message", function(data) {
            var message = data.body;
            messageList.append("<li>" + message + "</li>");
        });
    });
});