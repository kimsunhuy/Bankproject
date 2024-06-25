<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<title>Find ID</title>

<h2>Find ID</h2>
<form action="findId" method="post">
    <label for="phoneNumber">Phone Number:</label>
    <input type="text" id="phoneNumber" name="phoneNumber" required><br>
    <button type="submit">Find ID</button>
    <button type="button" onclick="history.back()">Back</button>
</form>

<%@ include file="/WEB-INF/views/footer.jsp" %>


