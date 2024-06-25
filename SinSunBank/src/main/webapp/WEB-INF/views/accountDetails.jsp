<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty sessionScope.user}">
    <c:redirect url="${pageContext.request.contextPath}/login.jsp" />
</c:if>
<title>Account Details</title>

<h2>Account Details</h2>
<p>Account Number: ${account.acNumber}</p>
<p>Account Balance: ${account.acBalance}</p>

<button type="button" onclick="history.back()">Back</button>

<%@ include file="/WEB-INF/views/footer.jsp" %>


