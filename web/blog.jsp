<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Blog" />
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Blog" />
</jsp:include>
<main>
    <c:if test="${errors.size()>0 }">
        <div class="danger">
            <ul>
                <c:forEach var="error" items="${errors }">
                    <li>${error }</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    <div id="topic1">
        <h3>Hoe was de projectweek?</h3>
        <ul id="topic1-comments"></ul>
        <ul>
            <li><input id="topic1-comment" type="text" placeholder="Enter a comment "></li>
            <li><input id="topic1-name" type="text" placeholder="name"></li>
            <li><input id="topic1-rating" type="number" min="0" max="5" placeholder="score between 0-5" ></li>
            <button id="topic1-button" onclick="send(1)">Commit</button>
        </ul>
    </div>

    <div id="topic2">
        <h3>Wat ben je van plan om te doen vandaag</h3>
        <ul id="topic2-comments"></ul>
        <ul>
            <li><input id="topic2-comment" type="text" placeholder="Enter a comment "></li>
            <li><input id="topic2-name" type="text" placeholder="name"></li>
            <li><input id="topic2-rating" type="number" min="0" max="5" placeholder="score between 0-5" ></li>
            <button id="topic2-button" onclick="send(2)">Commit</button>
        </ul>
    </div>

    <div id="topic3">
        <h3>Naar welke	muziek	ben	je	momenteel aan het luisteren?</h3>
        <ul id="topic3-comments"></ul>
        <ul>
            <li><input id="topic3-comment" type="text" placeholder="Enter a comment "></li>
            <li><input id="topic3-name" type="text" placeholder="name"></li>
            <li><input id="topic3-rating" type="number" min="0" max="5" placeholder="score between 0-5" ></li>
            <button id="topic3-button" onclick="send(3)">Commit</button>
        </ul>
    </div>

    <div id="topic4">
        <h3>Wat	zijn de examenvragen voor het vak Web4?</h3>
        <ul id="topic4-comments"></ul>
        <ul>
            <li><input id="topic4-comment" type="text" placeholder="Enter a comment "></li>
            <li><input id="topic4-name" type="text" placeholder="name"></li>
            <li><input id="topic4-rating" type="number" min="0" max="5" placeholder="score between 0-5" ></li>
            <button id="topic4-button" onclick="send(4)">Commit</button>
        </ul>
    </div>

    <div id="topic5">
        <h3>Wat moet je hier invullen?</h3>
        <ul id="topic5-comments" ></ul>
        <ul>
            <li><input id="topic5-comment" type="text" placeholder="Enter a comment "></li>
            <li><input id="topic5-name" type="text" placeholder="name"></li>
            <li><input id="topic5-rating" type="number" min="0" max="5" placeholder="score between 0-5" ></li>
            <button id="topic5-button" onclick="send(5)">Commit</button>
        </ul>
    </div>
</main>
<script type="text/javascript" src="js/blogPost.js"></script>
</body>
</html>
