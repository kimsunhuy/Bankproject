<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
    <h1>Home Page</h1>
    <c:if test="${not empty sessionScope.userId}">
        <p>Logged in as: ${sessionScope.userName} (${sessionScope.userId})</p>
    </c:if>
    <c:if test="${empty sessionScope.userId}">
        <p>You are not logged in.</p>
    </c:if>
</body>
</html>
<%@ include file="/WEB-INF/views/footer.jsp" %>
