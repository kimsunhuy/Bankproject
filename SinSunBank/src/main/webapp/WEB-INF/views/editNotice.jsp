<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty sessionScope.user}">
    <c:redirect url="${pageContext.request.contextPath}/login.jsp" />
</c:if>
<title>Edit Notice</title>

<h2>Edit Notice</h2>
<form action="editNotice" method="post">
    <input type="hidden" id="noticeId" name="noticeId" value="${notice.id}">
    <label for="noticeTitle">Title:</label>
    <input type="text" id="noticeTitle" name="noticeTitle" value="${notice.title}" required><br>
    <label for="noticeContent">Content:</label>
    <textarea id="noticeContent" name="noticeContent" required>${notice.content}</textarea><br>
    <button type="submit">Update Notice</button>
    <button type="button" onclick="history.back()">Back</button>
</form>

<%@ include file="/WEB-INF/views/footer.jsp" %>


