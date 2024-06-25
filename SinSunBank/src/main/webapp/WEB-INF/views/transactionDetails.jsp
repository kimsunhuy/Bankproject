<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty sessionScope.userId}">
    <c:redirect url="${pageContext.request.contextPath}/members/login.jsp" />
</c:if>
<title>Transaction Details</title>

<h2>Transaction Details</h2>
<p>Transaction ID: ${transaction.tId}</p>
<p>Account Number: ${transaction.tAccount_number}</p>
<p>Amount: ${transaction.tAmount}</p>
<p>Date: ${transaction.tDate}</p>
<p>Type: ${transaction.tType}</p>

<button type="button" onclick="history.back()">Back</button>

<%@ include file="/WEB-INF/views/footer.jsp" %>

