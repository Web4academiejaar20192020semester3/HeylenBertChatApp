window.onload = function(){
    getStatus();
    getFriends();
};

let button = document.getElementById("statusButton");
button.onclick = UpdateStatus;

let  xHRObjectUpdateStatus = new XMLHttpRequest();

function UpdateStatus() {
    let statusUpdate = document.getElementById("statusInput").value;

    if (statusUpdate !== "") {
        xHRObjectUpdateStatus.open("POST", "Controller?action=UpdateStatus&statusText="+encodeURIComponent(statusUpdate), true);
        xHRObjectUpdateStatus.setRequestHeader("Content-type", "application/x-www-from-urlencoded");
        xHRObjectUpdateStatus.send();
        document.getElementById("statusText").innerText = statusUpdate;
    }
}

let xHRObjectStatus = new XMLHttpRequest();

function getStatus() {
    xHRObjectStatus.open("GET", "Controller?action=GetStatus");
    xHRObjectStatus.onreadystatechange = getData;
    xHRObjectStatus.send(null);
}

function getData() {
    if(xHRObjectStatus.status === 200){
        if(xHRObjectStatus.readyState === 4){
            document.getElementById("statusText").innerText = xHRObjectStatus.responseText;
        }
    }
}
