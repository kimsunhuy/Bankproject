<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty sessionScope.user}">
    <c:redirect url="${pageContext.request.contextPath}/login.jsp" />
</c:if>
<title>Profile</title>

<h2>Profile</h2>
<p>Name: ${member.name}</p>
<p>Email: ${member.email}</p>
<p>Phone: ${member.phone}</p>

<form action="updateProfile" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${member.name}" required><br>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${member.email}" required><br>
    <label for="phone">Phone:</label>
    <input type="text" id="phone" name="phone" value="${member.phone}" required><br>
    <button type="submit">Update Profile</button>
    <button type="button" onclick="history.back()">Back</button>
</form>

<%@ include file="/WEB-INF/views/footer.jsp" %>

