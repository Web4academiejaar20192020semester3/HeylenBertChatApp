<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<p>Welcome ${user.getFirstName()}!</p>

<div style="display: flex">
    <p>Status: <p id="statusText" name="statusText"></p></p>
</div>
<p>Change status: <input type="text" id="statusInput" name="statusInput"> <button id="statusButton">Submit</button></p>

<h3>Friends</h3>
<p>Click on a friend to start a conversation</p>
<Button id="toggle-friends">Toggle Friendlist</Button>
<ul id="friends"></ul>

<p>Add friend: <input type="text" id="addFriend"><button id="addFriendButton">Add</button></p>

<h3>Chat</h3>
<div id="chat">

</div>