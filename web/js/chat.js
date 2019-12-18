$(document).ready(function () {
    $("#toggle-friends").click(function () {
        $("#friends").slideToggle("slow");
    });

});

let currentid = "";

function sendMessage(id) {
    let message = $('#message').val();
    $('#message').val("");
    $.post("Controller", {action: "SendText", message: message, userId: id})

}

function showChat(id) {
    currentid = id;
    setInterval(getChat, 600);
    let strhtml = "<h4>" + id + "</h4>" +
        "<ul id=\"chatUL\">" +
        "</ul>" +
        "<p>" +
        "<input type=\"text\" id=\"message\">" +
        "<button id=\"sendmessage\" onclick=\"sendMessage('" + id + "')\">send</button>" +
        "</p>";
    $('#chat').html(strhtml);
}

function getChat() {
    if (currentid !== "") {
        $.ajax({
            type: "GET",
            url: "Controller?action=Chat&userId=" + currentid,
            dataType: "json",
            success: function (result) {
                $('#chatUL').empty();
                for (var i = 0; i < result.length; i++) {
                    $('#chatUL').append($('<li>' + result[i]+ '</li>'));
                }

            },
            error: function () {
                console.log('error');
            }
        })
    }

}
