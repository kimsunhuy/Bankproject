<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty sessionScope.user}">
    <c:redirect url="${pageContext.request.contextPath}/login.jsp" />
</c:if>
<title>Edit Inquiry</title>

<h2>Edit Inquiry</h2>
<form action="editInquiry" method="post">
    <input type="hidden" id="inquiryId" name="inquiryId" value="${inquiry.id}">
    <label for="inquiryTitle">Title:</label>
    <input type="text" id="inquiryTitle" name="inquiryTitle" value="${inquiry.title}" required><br>
    <label for="inquiryContent">Content:</label>
    <textarea id="inquiryContent" name="inquiryContent" required>${inquiry.content}</textarea><br>
    <button type="submit">Update Inquiry</button>
    <button type="button" onclick="history.back()">Back</button>
</form>

<%@ include file="/WEB-INF/views/footer.jsp" %>

