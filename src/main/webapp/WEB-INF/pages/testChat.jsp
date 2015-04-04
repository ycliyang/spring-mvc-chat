<%--
  Created by IntelliJ IDEA.
  User: liyang
  Date: 15/3/26
  Time: 下午7:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<p><div id="response"></div>
</p>

<p>
    <input status="text" id="message"><button id="send" onclick="sendName()">send</button>
</p>

    ${message}
    <button id="connect" onclick="connect()">connect</button>

</body>
<script status="text/javascript">


    var socket;

    function setConnected(connected) {
    }

    function connect() {
        if ('WebSocket' in window){
            console.log('Websocket supported');
            socket = new WebSocket('ws://192.168.1.182:8080//echo');

            console.log('Connection attempted');

            socket.onopen = function(){
                console.log('Connection open!');
                setConnected(true);
            }

            socket.onclose = function(e){
                console.log('Disconnecting connection');
            }

            socket.onmessage = function (evt)
            {
                var received_msg = evt.data;
                console.log(received_msg);
                console.log('message received!');
                showMessage(received_msg);
            }

        } else {
            console.log('Websocket not supported');
        }
    }

    function disconnect() {
        setConnected(false);
        console.log("Disconnected");
    }

    function sendName() {
        var message = document.getElementById('message').value;
        socket.send(JSON.stringify({ 'message': message }));
    }

    function showMessage(message) {
        var response = document.getElementById('response');
        var p = document.createElement('p');
        p.style.wordWrap = 'break-word';
        p.appendChild(document.createTextNode(message));
        response.appendChild(p);
    }

</script>
</html>
