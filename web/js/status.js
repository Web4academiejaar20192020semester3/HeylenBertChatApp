window.onload = function(){
    getStatus();
    getFriends();
};

let button = document.getElementById("statusButton");
button.onclick = changeStatus;

let  xHRObjectChangeStatus = new XMLHttpRequest();

function changeStatus() {
    let statusUpdate = document.getElementById("statusInput").value;

    if (statusUpdate !== "") {
        xHRObjectChangeStatus.open("POST", "Controller?action=ChangeStatus&statusText="+encodeURIComponent(statusUpdate), true);
        xHRObjectChangeStatus.setRequestHeader("Content-type", "application/x-www-from-urlencoded");
        xHRObjectChangeStatus.send();
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
