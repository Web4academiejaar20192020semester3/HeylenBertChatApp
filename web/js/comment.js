
let webSocket;

function openSocket() {
    webSocket = new WebSocket("ws://localhost:8080/Blog");

    webSocket.onopen = function (event) {
    };

    webSocket.onmessage = function (event) {
        writeResponse(event.data);
    };

    webSocket.onclose = function (event) {
    };
}


function send(id) {
    let comment =  {};
    comment.topicId = id;
    comment.comment = document.getElementById('topic' + id + '-comment').value;
    comment.name = document.getElementById('topic' + id + '-name').value;
    comment.rating = document.getElementById('topic' + id + '-rating').value;

    webSocket.send(JSON.stringify(comment));
}

function closeSocket() {
    webSocket.close();
}

function writeResponse(text) {
    let result = JSON.parse(text);
    for (let i = 0; i < result.length; i++) {
        let commentsUL = document.getElementById("topic" + result[i].topicId + "-comments");
        let commentLI = document.createElement('li');
        let commentTxt = document.createTextNode(result[i].name + " (" + result[i].rating + "/5) : " + result[i].comment);
        commentLI.appendChild(commentTxt);
        commentsUL.appendChild(commentLI);
    }
}

openSocket();