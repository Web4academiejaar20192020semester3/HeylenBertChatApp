let xHRObjectAddFriend = new XMLHttpRequest();
let friendButton = document.getElementById("addFriendButton");
friendButton.onclick = addFriend;


function addFriend() {
    let friend = document.getElementById('addFriend').value;

    if(friend !== ''){
        xHRObjectAddFriend.open("POST", "Controller?action=AddFriend&friend="+encodeURIComponent(friend), true);
        xHRObjectAddFriend.setRequestHeader("Content-type", "application/x-www-from-urlencoded");
        xHRObjectAddFriend.send();
        getFriends();
    }
}