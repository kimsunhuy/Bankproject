<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty sessionScope.user}">
    <c:redirect url="${pageContext.request.contextPath}/login.jsp" />
</c:if>
<title>Deposit</title>

<h2>Deposit</h2>
<form action="deposit" method="post">
    <label for="accountNumber">Account Number:</label>
    <input type="text" id="accountNumber" name="accountNumber" required><br>
    <label for="depositAmount">Amount:</label>
    <input type="number" id="depositAmount" name="depositAmount" required><br>
    <button type="submit">Deposit</button>
    <button type="button" onclick="history.back()">Back</button>
</form>

<%@ include file="/WEB-INF/views/footer.jsp" %>

