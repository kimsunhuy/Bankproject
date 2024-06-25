<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty sessionScope.user}">
    <c:redirect url="${pageContext.request.contextPath}/login.jsp" />
</c:if>
<title>Create Notice</title>

<h2>Create Notice</h2>
<form action="createNotice" method="post">
    <label for="noticeTitle">Title:</label>
    <input type="text" id="noticeTitle" name="noticeTitle" required><br>
    <label for="noticeContent">Content:</label>
    <textarea id="noticeContent" name="noticeContent" required></textarea><br>
    <button type="submit">Submit Notice</button>
    <button type="button" onclick="history.back()">Back</button>
</form>

<%@ include file="/WEB-INF/views/footer.jsp" %>


