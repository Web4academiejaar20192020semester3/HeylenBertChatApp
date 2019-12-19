<%--
  Created by IntelliJ IDEA.
  User: berth
  Date: 19/12/2019
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="titlle" value="Register" />
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Register" />
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
    <section>
        <form action="Controller?action=Register" method="POST">
            <p>
                <label for="name">Name </label>
                <input type="text" id="name" name="name" required>
            </p>
            <p>
                <label for="lastName">Last name</label>
                <input type="text" id="lastName" name="lastName" required>
            </p>
            <p>
                <label for="email">Your email (= userId) </label>
                <input type="text" id="email" name="email" required>
            </p>
            <p>
                <label for="gender">Gender: </label>
                <select id="gender" name="gender" required>
                    <option>MALE</option>
                    <option>FEMALE</option>
                </select>
            </p>
            <p>
                <label for="password">Your password</label>
                <input type="password" id="password" name="password">
            </p>
            <p>
                <label for="passwordrep">Repeat your password</label>
                <input type="password" id="passwordrep" name="passwordrep">
            </p>
            <p>
                <label for="birthday">Birtday</label>
                <input type="date" id="birthday" name="birthday">
            </p>
            <p>
                <input type="submit" id="registerbtn" value="register">
            </p>
        </form>
    </section>
</main>
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Register"/>
</jsp:include>
</body>
</html>