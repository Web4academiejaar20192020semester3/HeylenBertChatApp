<%--
  Created by IntelliJ IDEA.
  User: wilant
  Date: 9/28/18
  Time: 11:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<p>Welcome ${user.getFirstName()}!</p>

<div style="display: flex">
    <p>Status: <p id="statusText" name="statusText"></p></p>
</div>
<p>Change status: <input type="text" id="statusInput" name="statusInput"> <button id="statusButton">Submit</button></p>

<h3>Friends <Button id="toggle-friends">Show/hide</Button></h3>
<ul id="friends"></ul>

<p>Add friend: <input type="text" id="addFriend"><button id="addFriendButton">Add</button></p>

<h3>Chat</h3>
<div id="chat">

</div>